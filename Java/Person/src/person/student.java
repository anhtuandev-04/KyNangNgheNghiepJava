// Trương Anh Tuấn 220616
package person;

public class student extends person {
    private String program;
    private int year;
    private double score;

    public student(String name, String address, String program, int year, double score) {
        super(name, address); 
        this.program = program;
        this.year = year;
        this.score = score;
    }

    public String getProgram() {
        return program;
    }

    public int getYear() {
        return year;
    }

    public double getScore() {
        return score;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRating() {
        if (score >= 9.0) {
            return "Excellent";
        } else if (score >= 7.0) {
            return "Good";
        } else if (score >= 5.0) {
            return "Average";
        } else {
            return "Poor";
        }
    }

    @Override
    public String toString() {
        return "Student[" + super.toString() + 
               ", program=" + program + 
               ", year=" + year + 
               ", score=" + String.format("%.2f", score) + 
               ", rating=" + getRating() + "]";
    }
}
