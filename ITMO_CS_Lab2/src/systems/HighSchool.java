package systems;

import java.util.Arrays;

public class HighSchool extends EducationalInstitution {
    private String[] scienceActivity;

    public HighSchool(String[] teacher,
                      Group[] group,
                      String location,
                      String name,
                      String[] scienceActivity) {
        super(teacher, group, location, name);
        this.scienceActivity = scienceActivity;
    }

    public void setScienceActivity(String[] scienceActivity) {
        this.scienceActivity = scienceActivity;
    }

    public void printInfo() {
        printGeneralInfo();
        System.out.println("scienceActivity: " + Arrays.toString(scienceActivity));
    }
}
