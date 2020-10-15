package systems;

import java.util.Arrays;

public class EducationalInstitution {
    protected String[] teacher;
    protected Group[] group;
    protected String location;
    protected String name;

    public EducationalInstitution(String[] teacher, Group[] group, String location, String name) {
        this.teacher = teacher;
        this.group = group;
        this.location = location;
        this.name = name;
    }

    public void setTeacher(String[] teacher) {
        this.teacher = teacher;
    }

    public void setGroup(Group[] group) {
        this.group = group;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String collectGeneralInfo() {
        String res = "Teachers: " + Arrays.toString(teacher) + "\n"
                + "group: " + Arrays.toString(group) + "\n"
                + "location: " + location + "\nname: " + name;
        return res;
    }

    public void printGeneralInfo() {
        System.out.println(collectGeneralInfo());
    }

}
