package org.moonpay.banking.application.port.in;

import org.moonpay.banking.domain.FirmbankingRequest;

public interface RequestFirmbankingUseCase {

    FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
}
