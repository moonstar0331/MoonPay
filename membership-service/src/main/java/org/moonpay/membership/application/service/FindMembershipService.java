package org.moonpay.membership.application.service;

import lombok.RequiredArgsConstructor;
import org.moonpay.membership.adapter.out.persistence.MembershipJpaEntity;
import org.moonpay.membership.adapter.out.persistence.MembershipMapper;
import org.moonpay.membership.application.port.in.FindMembershipCommand;
import org.moonpay.membership.application.port.in.FindMembershipUseCase;
import org.moonpay.membership.application.port.out.FindMembershipPort;
import org.moonpay.membership.common.UseCase;
import org.moonpay.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
        return membershipMapper.mapToDomainEntity(entity);
    }
}
