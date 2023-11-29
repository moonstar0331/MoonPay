package org.moonpay.banking.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.moonpay.banking.application.port.in.RegisterBankAccountCommand;
import org.moonpay.banking.application.port.in.RegisterBankAccountUseCase;
import org.moonpay.banking.application.port.in.RequestFirmbankingCommand;
import org.moonpay.banking.application.port.in.RequestFirmbankingUseCase;
import org.moonpay.banking.domain.FirmbankingRequest;
import org.moonpay.banking.domain.RegisteredBankAccount;
import org.moonpay.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmbankingController {

    private final RequestFirmbankingUseCase requestFirmbankingUseCase;

    @PostMapping("/banking/firmbanking/register")
    FirmbankingRequest registerMembership(@RequestBody RequestFirmbankingRequest request) {
        RequestFirmbankingCommand command = RequestFirmbankingCommand.builder()
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .fromBankName(request.getFromBankName())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();


        return requestFirmbankingUseCase.requestFirmbanking(command);
    }
}
