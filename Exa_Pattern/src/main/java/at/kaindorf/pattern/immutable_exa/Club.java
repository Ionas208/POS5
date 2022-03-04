package at.kaindorf.pattern.immutable_exa;

import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 10:51
*/
public class Club {
    private String name;
    private int geheimzahl;
    private List<Member> members;

    public Club(String name, int geheimzahl, List<Member> members) {
        this.name = name;
        this.geheimzahl = geheimzahl;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public int getGeheimzahl() {
        return geheimzahl;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        members.add(member);
    }
}
