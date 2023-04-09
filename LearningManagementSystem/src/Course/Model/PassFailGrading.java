package Course.Model;

public class PassFailGrading implements GradingStrategy {

    private double passingGrade;

    public PassFailGrading(double passingGrade) {
        this.passingGrade = passingGrade;
    }

    @Override
    public Double calculateGrade(Assignment assignment) {
        double score = assignment.getScore();
        if (score >= passingGrade) {
            return 4.0;
        } else {
            return 0.0;
        }
    }
}