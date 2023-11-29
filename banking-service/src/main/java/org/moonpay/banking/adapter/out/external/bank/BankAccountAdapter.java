package org.moonpay.banking.adapter.out.external.bank;

import lombok.RequiredArgsConstructor;
import org.moonpay.banking.application.port.out.RequestBankAccountInfoPort;
import org.moonpay.common.ExternalSystemAdapter;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

        // 실제로 외부 은행에 http 을 통해서
        // 실제 은행 계좌 정보를 가져오고

        // 실제 은행 계좌 -> BankAccount
        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }
}
