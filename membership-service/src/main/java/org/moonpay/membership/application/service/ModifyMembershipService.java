package org.moonpay.membership.application.service;

import lombok.RequiredArgsConstructor;
import org.moonpay.membership.adapter.out.persistence.MembershipJpaEntity;
import org.moonpay.membership.adapter.out.persistence.MembershipMapper;
import org.moonpay.membership.application.port.in.ModifyMembershipCommand;
import org.moonpay.membership.application.port.in.ModifyMembershipUseCase;
import org.moonpay.membership.application.port.in.RegisterMembershipCommand;
import org.moonpay.membership.application.port.in.RegisterMembershipUseCase;
import org.moonpay.membership.application.port.out.ModifyMembershipPort;
import org.moonpay.membership.application.port.out.RegisterMembershipPort;
import org.moonpay.membership.common.UseCase;
import org.moonpay.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {

        MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        // entity -> Membership
        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
