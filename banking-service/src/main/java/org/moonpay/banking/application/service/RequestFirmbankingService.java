package org.moonpay.banking.application.service;

import lombok.RequiredArgsConstructor;
import org.moonpay.banking.adapter.out.external.bank.BankAccount;
import org.moonpay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import org.moonpay.banking.adapter.out.external.bank.FirmbankingResult;
import org.moonpay.banking.adapter.out.external.bank.GetBankAccountRequest;
import org.moonpay.banking.adapter.out.persistence.FirmbankingRequestJpaEntity;
import org.moonpay.banking.adapter.out.persistence.FirmbankingRequestMapper;
import org.moonpay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import org.moonpay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import org.moonpay.banking.application.port.in.RegisterBankAccountCommand;
import org.moonpay.banking.application.port.in.RegisterBankAccountUseCase;
import org.moonpay.banking.application.port.in.RequestFirmbankingCommand;
import org.moonpay.banking.application.port.in.RequestFirmbankingUseCase;
import org.moonpay.banking.application.port.out.RegisterBankAccountPort;
import org.moonpay.banking.application.port.out.RequestBankAccountInfoPort;
import org.moonpay.banking.application.port.out.RequestExternalFirmbankingPort;
import org.moonpay.banking.application.port.out.RequestFirmbankingPort;
import org.moonpay.banking.domain.FirmbankingRequest;
import org.moonpay.banking.domain.RegisteredBankAccount;
import org.moonpay.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmbankingService implements RequestFirmbankingUseCase {

    private final FirmbankingRequestMapper mapper;
    private final RequestFirmbankingPort requestFirmbankingPort;
    private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;


    @Override
    public FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command) {

        // Business Logic
        // a -> b 계좌

        // 1. 요청에 대해 정보를 먼저 write. "요청" 상태로
        FirmbankingRequestJpaEntity requestedEntity = requestFirmbankingPort.createFirmbankingReqeust(
                new FirmbankingRequest.FromBankName(command.getFromBankName()),
                new FirmbankingRequest.FromBankAccountNumber(command.getToBankAccountNumber()),
                new FirmbankingRequest.ToBankName(command.getToBankName()),
                new FirmbankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
                new FirmbankingRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmbankingRequest.FirmbankingStatus(0)
        );

        // 2. 외부 은행에 펌뱅킹 요청
        FirmbankingResult result = requestExternalFirmbankingPort.reqeustExternalFirmbanking(new ExternalFirmbankingRequest(
                command.getFromBankName(),
                command.getFromBankAccountNumber(),
                command.getToBankName(),
                command.getToBankAccountNumber()
        ));

        // Transactional UUID
        UUID randomUUID = UUID.randomUUID();
        requestedEntity.setUuid(randomUUID);

        // 3. 결과에 따라서 1번에 작성했던 FirmbankingRequest 정보를 Update
        if(result.getResultCode() == 0) {
            // 성공
            requestedEntity.setFirmbankingStatus(1);
        } else {
            // 실패
            requestedEntity.setFirmbankingStatus(2);
        }

        // 4. 결과를 리턴하기 전에 바뀐 상태 값을 기준으로 다시 save
        return mapper.mapToDomainEntity(requestFirmbankingPort.modifyFirmbankingReqeust(requestedEntity), randomUUID);
    }
}
