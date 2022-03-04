package at.kaindorf.pattern.immutable_exa;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 10:51
*/
public class Member {
    private String firstname;
    private String lastname;

    public Member(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
