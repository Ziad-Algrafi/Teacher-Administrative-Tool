public class Student {
    public int id;
    public double firstExamScore;
    public double secondExamScore;
    public double homeworkScore;
    public double projectScore;
    public double finalExamScore;
    public double grade; 
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
        calculateGrade(); 
        calculateGradeWithSign(); 
    }

 
    public double getGrade() {
        return grade;
    }

   
    public int getId() {
        return id;
    }

    
    public String getGradeWithSign() {
        return gradeWithSign;
    }

    
    public int getAttendancePercentage() {
        return calculateAttendancePercentage();
    }

    private void calculateGrade() {
        double totalScore = firstExamScore + secondExamScore + homeworkScore + projectScore + finalExamScore;
        if (totalScore > 100) {
            totalScore = 100;
        }
        this.grade = totalScore; 
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
                                                                        'F'; 

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
