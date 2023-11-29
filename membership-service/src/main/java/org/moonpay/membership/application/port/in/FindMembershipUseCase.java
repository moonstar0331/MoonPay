package org.moonpay.membership.application.port.in;

import org.moonpay.membership.domain.Membership;

public interface FindMembershipUseCase {
    Membership findMembership(FindMembershipCommand command);
}
