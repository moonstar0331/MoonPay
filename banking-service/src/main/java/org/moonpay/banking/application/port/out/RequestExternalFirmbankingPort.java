package org.moonpay.banking.application.port.out;

import org.moonpay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import org.moonpay.banking.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {
    FirmbankingResult reqeustExternalFirmbanking(ExternalFirmbankingRequest request);
}
