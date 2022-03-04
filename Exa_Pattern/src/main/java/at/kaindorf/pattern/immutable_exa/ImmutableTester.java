package at.kaindorf.pattern.immutable_exa;

import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 10:51
*/
public class ImmutableTester {
    public static void main(String[] args) {
        Member member = new Member("Jonas", "Seidl");

        List<Member> members = new ArrayList<>();
        members.add(member);
        Club club = new Club("Kaindorf", 1, members);
        ImmutableClub immutableClub = new ImmutableClub("Kaindorf", 1, members);

        Member member2 = new Member("Waul", "Peiß");
        club.addMember(member2);
        immutableClub = immutableClub.addMember(member2);
        System.out.println(club.getMembers().size());
        System.out.println(immutableClub.getMembers().size());
        Member member3 = new Member("Franz", "Hans");
        members.add(member3);
        System.out.println(club.getMembers().size());
        System.out.println(immutableClub.getMembers().size());
    }
}
