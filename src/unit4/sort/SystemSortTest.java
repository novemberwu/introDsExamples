package unit4.sort;

import java.util.Arrays;

public class SystemSortTest {
    public static void main(String[] args) {
        StudentScore[] s = new StudentScore[8];
        s[0] = new StudentScore("0", "G11", 84);
        s[1] = new StudentScore("1", "G11", 89);
        s[2] = new StudentScore("2", "G11", 80);
        s[3] = new StudentScore("3", "G11", 81);
        s[4] = new StudentScore("4", "G12", 84);
        s[5] = new StudentScore("5", "G12", 89);
        s[6] = new StudentScore("6", "G12", 80);
        s[7] = new StudentScore("7", "G12", 81);
        System.out.println("\nSort by score first");
        Arrays.sort(s, StudentScore.sortByScore());
        Arrays.stream(s).forEach(System.out::println);

        System.out.println("\nSort by grade second");
        Arrays.sort(s, StudentScore.sortByGrade());
        Arrays.stream(s).forEach(System.out::println);
    }
}
