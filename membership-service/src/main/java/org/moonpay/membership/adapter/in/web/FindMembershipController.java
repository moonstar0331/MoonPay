package org.moonpay.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.moonpay.common.WebAdapter;
import org.moonpay.membership.application.port.in.FindMembershipCommand;
import org.moonpay.membership.application.port.in.FindMembershipUseCase;
import org.moonpay.membership.domain.Membership;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RequiredArgsConstructor
@RestController
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("/membership/{membershipId}")
    ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId) {

        FindMembershipCommand command = FindMembershipCommand.builder()
                .membershipId(membershipId)
                .build();

        return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
    }
}
