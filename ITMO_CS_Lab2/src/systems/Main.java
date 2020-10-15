package systems;

public class Main {
    public static void main(String[] args) {
        Group[] p = {new Group(3121, new String[] {"student1", "student2"}),
                new Group(3122, new String[] {"student3", "student4"})};
        Group[] m = {new Group(3435, new String[] {"student5", "student6"}),
                new Group(3436, new String[] {"student7", "student8"})};
        EducationalInstitution ei = new EducationalInstitution(new String[] {"teacher1", "teacher2", "teacher3", "teacher4"},
                p, "Saint-Petersburg", "ITMO");
        HighSchool hs = new HighSchool(new String[] {"teacher1", "teacher2"},
                p, "Saint-Petersburg", "ITMO", new String[] {"a1", "a2"});
        College c = new College(new String[] {"teacher3", "teacher4"},
                m, "Saint-Petersburg", "ITMO", new String[] {"a3", "a4"});

        ei.printGeneralInfo();
        hs.printInfo();
        c.printInfo();

        ei.setName("EPFL");
        hs.setScienceActivity(new String[] {"b3", "b4"});
        c.setPracticeActivity(new String[] {"b1", "b2"});

        ei.printGeneralInfo();
        hs.printInfo();
        c.printInfo();
    }
}