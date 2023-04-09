package Course.Model;

public class LetterGrading implements GradingStrategy {
    
    public Double calculateGrade(Assignment assignment) {
        double score = assignment.getScore();
        if (score >= 90) {
            return 4.0;
        } else if (score >= 80) {
            return 3.0;
        } else if (score >= 70) {
            return 2.0;
        } else if (score >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}