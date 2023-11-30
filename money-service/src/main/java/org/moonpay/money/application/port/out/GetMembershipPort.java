package org.moonpay.money.application.port.out;

public interface GetMembershipPort {

    public MembershipStatus getMembership(String membershipId);
}
