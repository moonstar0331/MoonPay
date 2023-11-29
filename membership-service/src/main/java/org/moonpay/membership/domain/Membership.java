package org.moonpay.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    @Getter
    private final String memebershipId;

    @Getter
    private final String name;

    @Getter
    private final String email;

    @Getter
    private final String address;

    @Getter
    private final boolean isValid;

    @Getter
    private final boolean isCorp;

    public static Membership generateMember(MembershipId membershipId,
                                            MembershipName membershipName,
                                            MembershipEmail membershipEmail,
                                            MembershipAddress membershipAddress,
                                            MembershipIsValid membershipIsValid,
                                            MembershipIsCorp membershipIsCorp) {
        return new Membership(
                membershipId.membershipId,
                membershipName.nameValue,
                membershipEmail.emailValue,
                membershipAddress.addressValue,
                membershipIsValid.isValidValue,
                membershipIsCorp.isCorpValue
        );
    }

    @Value
    public static class MembershipId {
        String membershipId;

        public MembershipId(String value) {
            this.membershipId = value;
        }
    }

    @Value
    public static class MembershipName {
        String nameValue;

        public MembershipName(String value) {
            this.nameValue = value;
        }
    }

    @Value
    public static class MembershipEmail {
        String emailValue;

        public MembershipEmail(String value) {
            this.emailValue = value;
        }
    }

    @Value
    public static class MembershipAddress {
        String addressValue;

        public MembershipAddress(String value) {
            this.addressValue = value;
        }
    }

    @Value
    public static class MembershipIsValid {
        boolean isValidValue;

        public MembershipIsValid(boolean value) {
            this.isValidValue = value;
        }
    }

    @Value
    public static class MembershipIsCorp {
        boolean isCorpValue;

        public MembershipIsCorp(boolean value) {
            this.isCorpValue = value;
        }
    }
}
