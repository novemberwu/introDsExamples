package unit4.sort;

import java.util.Comparator;

public class StudentScore {
    private String studentId;
    private String grade;
    private double score;

    public StudentScore(String id, String grade, double score){
        this.studentId = id;
        this.grade = grade;
        this.score = score;
    }

    public static Comparator<StudentScore> sortByScore(){
        return new Comparator<StudentScore>() {
            @Override
            public int compare(StudentScore o1, StudentScore o2) {
                return (int)(o1.score - o2.score);
            }
        };

    }

    public static  Comparator<StudentScore> sortByGrade(){
        return new Comparator<StudentScore>() {
            @Override
            public int compare(StudentScore o1, StudentScore o2) {
                return o1.grade.compareTo(o2.grade);
            }
        };

    }

    public String toString(){
        return "id:"+studentId + " grade:" +grade +" score:" + score;
    }
}
