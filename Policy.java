/**
 * The Policy class represents an insurance policy.
 * It contains policy details and provides methods to calculate BMI and policy price.
 */
public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;
    private double height;
    private double weight;

    /**
     * No-argument constructor that initializes the Policy object with default values.
     */
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

    /**
     * Constructs a Policy object with the given parameters.
     * 
     * @param policyNumber The policy number
     * @param providerName The name of the provider
     * @param policyholderFirstName The policyholder's first name
     * @param policyholderLastName The policyholder's last name
     * @param policyholderAge The age of the policyholder
     * @param smokingStatus The smoking status ("smoker" or "non-smoker")
     * @param height The height of the policyholder in inches
     * @param weight The weight of the policyholder in pounds
     */
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

    /** @return The policy number */
    public int getPolicyNumber() { return policyNumber; }

    /** @return The provider name */
    public String getProviderName() { return providerName; }

    /** @return The policyholder's first name */
    public String getPolicyholderFirstName() { return policyholderFirstName; }

    /** @return The policyholder's last name */
    public String getPolicyholderLastName() { return policyholderLastName; }

    /** @return The policyholder's age */
    public int getPolicyholderAge() { return policyholderAge; }

    /** @return The smoking status of the policyholder */
    public String getSmokingStatus() { return smokingStatus; }

    /** @return The height of the policyholder in inches */
    public double getHeight() { return height; }

    /** @return The weight of the policyholder in pounds */
    public double getWeight() { return weight; }

    /**
     * Sets the policy number.
     * @param policyNumber The policy number to set
     */
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    /**
     * Sets the provider name.
     * @param providerName The provider name to set
     */
    public void setProviderName(String providerName) { this.providerName = providerName; }

    /**
     * Sets the policyholder's first name.
     * @param policyholderFirstName The first name to set
     */
    public void setPolicyholderFirstName(String policyholderFirstName) { this.policyholderFirstName = policyholderFirstName; }

    /**
     * Sets the policyholder's last name.
     * @param policyholderLastName The last name to set
     */
    public void setPolicyholderLastName(String policyholderLastName) { this.policyholderLastName = policyholderLastName; }

    /**
     * Sets the policyholder's age.
     * @param policyholderAge The age to set
     */
    public void setPolicyholderAge(int policyholderAge) { this.policyholderAge = policyholderAge; }

    /**
     * Sets the smoking status.
     * @param smokingStatus The smoking status to set
     */
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

    /**
     * Sets the height.
     * @param height The height in inches to set
     */
    public void setHeight(double height) { this.height = height; }

    /**
     * Sets the weight.
     * @param weight The weight in pounds to set
     */
    public void setWeight(double weight) { this.weight = weight; }

    /**
     * Calculates and returns the Body Mass Index (BMI).
     * @return The BMI value
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates and returns the price of the policy based on
     * age, smoking status, and BMI.
     * @return The calculated policy price
     */
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
