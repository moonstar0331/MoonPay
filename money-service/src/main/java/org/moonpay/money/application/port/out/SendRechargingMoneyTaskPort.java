package org.moonpay.money.application.port.out;

import org.moonpay.common.RechargingMoneyTask;

public interface SendRechargingMoneyTaskPort {
    void sendRechargingMoneyTaskPort(RechargingMoneyTask task);
}
