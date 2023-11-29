package org.moonpay.membership.application.port.out;

import org.moonpay.membership.adapter.out.persistence.MembershipJpaEntity;
import org.moonpay.membership.domain.Membership;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(
            Membership.MembershipId membershipId
    );
}
