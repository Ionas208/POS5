package at.kaindorf.pattern.immutable_exa;

import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 10:51
*/
public final class ImmutableClub {
    private final String name;
    private final int geheimzahl;
    private final List<Member> members;

    public ImmutableClub(String name, int geheimzahl, List<Member> members) {
        this.name = name;
        this.geheimzahl = geheimzahl;
        this.members = new ArrayList<>(members);
    }

    public String getName() {
        return name;
    }

    public int getGeheimzahl() {
        return geheimzahl;
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public ImmutableClub addMember(Member member) {
        List<Member> newMembers = new ArrayList<>(members);
        newMembers.add(member);
        return new ImmutableClub(name, geheimzahl, newMembers);
    }
}
