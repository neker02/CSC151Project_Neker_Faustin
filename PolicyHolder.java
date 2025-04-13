public class PolicyHolder {
    // Fields
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double height; // in inches
    private double weight; // in pounds

    // Default constructor
    public PolicyHolder() {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "";
        height = 0.0;
        weight = 0.0;
    }

    // Parameterized constructor
    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Copy constructor (for security/encapsulation)
    public PolicyHolder(PolicyHolder other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.age = other.age;
        this.smokingStatus = other.smokingStatus;
        this.height = other.height;
        this.weight = other.weight;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    // BMI calculation
    public double getBMI() {
        return (weight * 703) / (height * height);
    }

    // toString method
    public String toString() {
        return "Policyholder's First Name: " + firstName + "\n" +
               "Policyholder's Last Name: " + lastName + "\n" +
               "Policyholder's Age: " + age + "\n" +
               "Policyholder's Smoking Status (Y/N): " + smokingStatus + "\n" +
               "Policyholder's Height: " + height + " inches\n" +
               "Policyholder's Weight: " + weight + " pounds\n" +
               "Policyholder's BMI: " + String.format("%.2f", getBMI()) + "\n";
    }
}
