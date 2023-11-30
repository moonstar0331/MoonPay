package org.moonpay.money.application.port.in;

import org.moonpay.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyRequestUseCase {

    MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);

    MoneyChangingRequest increaseMoneyRequestAsync(IncreaseMoneyRequestCommand command);
}
