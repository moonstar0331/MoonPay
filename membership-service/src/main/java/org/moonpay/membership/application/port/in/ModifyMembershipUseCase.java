package org.moonpay.membership.application.port.in;

import org.moonpay.membership.domain.Membership;

public interface ModifyMembershipUseCase {

    Membership modifyMembership(ModifyMembershipCommand command);
}
