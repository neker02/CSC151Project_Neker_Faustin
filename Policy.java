public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;
    private double height;
    private double weight;

    // No-arg constructor
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "Unknown";
        this.policyholderFirstName = "Unknown";
        this.policyholderLastName = "Unknown";
        this.policyholderAge = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
    }

    // Constructor with arguments
    public Policy(int policyNumber, String providerName, String policyholderFirstName, String policyholderLastName,
                  int policyholderAge, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Getters and Setters
    public int getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    public String getPolicyholderFirstName() { return policyholderFirstName; }
    public String getPolicyholderLastName() { return policyholderLastName; }
    public int getPolicyholderAge() { return policyholderAge; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
    public void setPolicyholderFirstName(String policyholderFirstName) { this.policyholderFirstName = policyholderFirstName; }
    public void setPolicyholderLastName(String policyholderLastName) { this.policyholderLastName = policyholderLastName; }
    public void setPolicyholderAge(int policyholderAge) { this.policyholderAge = policyholderAge; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }
    public void setHeight(double height) { this.height = height; }
    public void setWeight(double weight) { this.weight = weight; }

    // Calculate BMI
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    // Calculate Policy Price
    public double calculatePolicyPrice() {
        double baseFee = 600;
        double additionalFee = 0;

        if (policyholderAge > 50) {
            additionalFee += 75;
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            additionalFee += 100;
        }
        double bmi = calculateBMI();
        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20;
        }
        return baseFee + additionalFee;
    }
}