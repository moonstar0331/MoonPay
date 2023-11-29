package org.moonpay.banking.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.moonpay.banking.application.port.in.RegisterBankAccountCommand;
import org.moonpay.banking.application.port.in.RegisterBankAccountUseCase;
import org.moonpay.banking.domain.RegisteredBankAccount;
import org.moonpay.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping("/banking/account/register")
    RegisteredBankAccount registerMembership(@RequestBody RegisterBankAccountRequest request) {
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(request.isValid())
                .build();

        RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);
        if (registeredBankAccount == null) {
            return null;
        }

        return registeredBankAccount;
    }
}
