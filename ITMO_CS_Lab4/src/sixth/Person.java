package sixth;

import java.util.Calendar;

public class Person {
    private String lastname;
    private String firstname;
    private String middlename;
    private Calendar birthday;

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getFIO() {
        return lastname + ' ' + firstname.charAt(0) + '.' + middlename.charAt(0) + '.';
    }
}
