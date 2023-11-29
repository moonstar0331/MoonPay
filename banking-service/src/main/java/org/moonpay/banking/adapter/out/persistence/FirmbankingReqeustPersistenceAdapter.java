package org.moonpay.banking.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.moonpay.banking.application.port.out.RegisterBankAccountPort;
import org.moonpay.banking.application.port.out.RequestFirmbankingPort;
import org.moonpay.banking.domain.FirmbankingRequest;
import org.moonpay.banking.domain.RegisteredBankAccount;
import org.moonpay.common.PersistentAdapter;

import java.util.UUID;

@PersistentAdapter
@RequiredArgsConstructor
public class FirmbankingReqeustPersistenceAdapter implements RequestFirmbankingPort {

    private final SpringDataFirmbankingRequestRepository firmbankingRequestRepository;

    @Override
    public FirmbankingRequestJpaEntity createFirmbankingReqeust(FirmbankingRequest.FromBankName fromBankName, FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber, FirmbankingRequest.ToBankName toBankName, FirmbankingRequest.ToBankAccountNumber toBankAccountNumber, FirmbankingRequest.MoneyAmount moneyAmount, FirmbankingRequest.FirmbankingStatus firmbankingStatus) {
        FirmbankingRequestJpaEntity entity = firmbankingRequestRepository.save(new FirmbankingRequestJpaEntity(
                fromBankName.getFromBankName(),
                fromBankAccountNumber.getFromBankAccountNumber(),
                toBankName.getToBankName(),
                toBankAccountNumber.getToBankAccountNumber(),
                moneyAmount.getMoneyAmount(),
                firmbankingStatus.getFirmBankingStatus(),
                UUID.randomUUID())
        );
        return entity;
    }

    @Override
    public FirmbankingRequestJpaEntity modifyFirmbankingReqeust(FirmbankingRequestJpaEntity entity) {
        return firmbankingRequestRepository.save(entity);
    }
}
