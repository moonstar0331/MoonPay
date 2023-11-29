package org.moonpay.membership.application.port.in;

import org.moonpay.membership.domain.Membership;

public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
