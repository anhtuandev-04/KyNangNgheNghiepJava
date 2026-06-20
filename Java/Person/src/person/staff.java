// Trương Anh Tuấn 220616
package person;

public class staff extends person {
    private String school;
    private double salary; 

    public staff(String name, String address, String school, double salary) {
        super(name, address); 
        this.school = school;
        this.salary = salary;
    }

    public String getSchool() {
        return school;
    }

    public double getSalary() {
        return salary;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double upToSalary(int percent) {
        this.salary += this.salary * percent / 100.0;
        return this.salary;
    }

    @Override
    public String toString() {
        return "Staff[" + super.toString() + 
               ", school=" + school + 
               ", salary=" + String.format("%,.2f", salary) + "]";
    }
}