public class Student {
    public int id;
    public double firstExamScore;
    public double secondExamScore;
    public double homeworkScore;
    public double projectScore;
    public double finalExamScore;
    public double grade; // New field for grade
    public int totalClasses;
    public int attendedClasses;
    public String gradeWithSign;

    public Student(int id, double firstExamScore, double secondExamScore, double homeworkScore, double projectScore, double finalExamScore, int totalClasses, int attendedClasses) {
        this.id = id;
        this.firstExamScore = firstExamScore;
        this.secondExamScore = secondExamScore;
        this.homeworkScore = homeworkScore;
        this.projectScore = projectScore;
        this.finalExamScore = finalExamScore;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
        calculateGrade(); // Calculate grade
        calculateGradeWithSign(); // Calculate grade with sign
    }

    // Getter for grade
    public double getGrade() {
        return grade;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for gradeWithSign
    public String getGradeWithSign() {
        return gradeWithSign;
    }

    // Getter for attendancePercentage
    public int getAttendancePercentage() {
        return calculateAttendancePercentage();
    }

    private void calculateGrade() {
        double totalScore = firstExamScore + secondExamScore + homeworkScore + projectScore + finalExamScore;
        if (totalScore > 100) {
            totalScore = 100;
        }
        this.grade = totalScore; // Assign the calculated grade
    }

    private void calculateGradeWithSign() {
        int roundedGrade = (int) Math.round(grade);
        char letterGrade = (roundedGrade >= 95) ? 'A' :
                (roundedGrade >= 90) ? 'A' :
                        (roundedGrade >= 85) ? 'B' :
                                (roundedGrade >= 80) ? 'B' :
                                        (roundedGrade >= 75) ? 'C' :
                                                (roundedGrade >= 70) ? 'C' :
                                                        (roundedGrade >= 65) ? 'D' :
                                                                (roundedGrade >= 60) ? 'D' :
                                                                        'F'; // Handle cases below 60 as F

        String gradeWithSign = String.valueOf(letterGrade);

        
        if ((letterGrade == 'A' && roundedGrade == 100) || 
           (letterGrade == 'A' || letterGrade == 'B' || letterGrade == 'C' || letterGrade == 'D') &&
            roundedGrade % 10 >= 5 ) {
            gradeWithSign += '+';
        }


    
        this.gradeWithSign = gradeWithSign;
    }

    public int calculateAttendancePercentage() {
        return 100 - ((attendedClasses * 100) / totalClasses);
    }
}
