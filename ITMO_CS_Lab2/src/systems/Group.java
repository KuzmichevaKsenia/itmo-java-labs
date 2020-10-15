package systems;

import java.util.Arrays;

public class Group {
    int num;
    String[] student;

    public Group(int num, String[] student) {
        this.num = num;
        this.student = student;
    }

    @Override
    public String toString() {
        return "num: " + num + "; students: " + Arrays.toString(student);
    }
}
