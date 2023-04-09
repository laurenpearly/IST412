package Course.Model;

public class PercentGrading implements GradingStrategy {
    
    private double weight;
    
    public PercentGrading(double weight) {
        this.weight = weight;
    }
    
    public Double calculateGrade(Assignment assignment) {
        return assignment.getScore() * weight;
    }
}