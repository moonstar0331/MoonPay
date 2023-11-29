package org.moonpay.banking.application.port.out;

import org.moonpay.banking.adapter.out.persistence.FirmbankingRequestJpaEntity;
import org.moonpay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import org.moonpay.banking.domain.FirmbankingRequest;
import org.moonpay.banking.domain.RegisteredBankAccount;

public interface RequestFirmbankingPort {

    FirmbankingRequestJpaEntity createFirmbankingReqeust(
            FirmbankingRequest.FromBankName fromBankName,
            FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber,
            FirmbankingRequest.ToBankName toBankName,
            FirmbankingRequest.ToBankAccountNumber toBankAccountNumber,
            FirmbankingRequest.MoneyAmount moneyAmount,
            FirmbankingRequest.FirmbankingStatus firmbankingStatus
    );

    FirmbankingRequestJpaEntity modifyFirmbankingReqeust(
            FirmbankingRequestJpaEntity entity
    );
}
