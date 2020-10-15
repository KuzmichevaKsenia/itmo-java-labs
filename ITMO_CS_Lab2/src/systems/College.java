package systems;

import java.util.Arrays;

public class College extends EducationalInstitution {
    private String[] practiceActivity;

    public College(String[] teacher,
                   Group[] group,
                   String location,
                   String name,
                   String[] practiceActivity) {
        super(teacher, group, location, name);
        this.practiceActivity = practiceActivity;
    }

    public void setPracticeActivity(String[] practiceActivity) {
        this.practiceActivity = practiceActivity;
    }

    public void printInfo(){
        printGeneralInfo();
        System.out.println("practiceActivity: " + Arrays.toString(practiceActivity));
    }
}