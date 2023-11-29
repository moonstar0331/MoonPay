package org.moonpay.banking.application.port.out;

import org.moonpay.banking.adapter.out.external.bank.BankAccount;
import org.moonpay.banking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
