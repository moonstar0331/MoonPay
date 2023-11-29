package org.moonpay.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.moonpay.membership.application.port.in.ModifyMembershipCommand;
import org.moonpay.membership.application.port.in.ModifyMembershipUseCase;
import org.moonpay.membership.common.WebAdapter;
import org.moonpay.membership.domain.Membership;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RequiredArgsConstructor
@RestController
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PostMapping("/membership/modify")
    ResponseEntity<Membership> findMembershipByMemberId(@RequestBody ModifyMembershipRequest request) {

        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(request.getMembershipId())
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(request.isValid())
                .isCorp(request.isCorp())
                .build();

        return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
    }
}
