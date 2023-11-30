package org.moonpay.money.application.port.out;


import org.moonpay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import org.moonpay.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import org.moonpay.money.domain.MemberMoney;
import org.moonpay.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {

    MoneyChangingRequestJpaEntity createMoneyChangingRequest(
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.MoneyChangingType moneyChangingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus,
            MoneyChangingRequest.Uuid uuid
    );

    MemberMoneyJpaEntity increaseMoney(
            MemberMoney.MembershipId memberId,
            int increaseMoneyAmount
    );
}
