public class Policy {
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    // Static field to keep track of the number of Policy objects created
    private static int policyCount = 0;

    // No-argument constructor
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "Unknown";
        this.policyHolder = new PolicyHolder();  // use default PolicyHolder
        policyCount++;
    }

    // Parameterized constructor
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = new PolicyHolder(policyHolder); // defensive copy
        policyCount++;
    }

    // Getters and setters
    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public PolicyHolder getPolicyHolder() {
        return new PolicyHolder(policyHolder); // return a copy
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = new PolicyHolder(policyHolder); // defensive copy
    }

    // Calculate Policy Price
    public double calculatePolicyPrice() {
        double baseFee = 600;
        double additionalFee = 0;

        if (policyHolder.getAge() > 50) {
            additionalFee += 75;
        }

        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            additionalFee += 100;
        }

        double bmi = policyHolder.getBMI();
        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20;
        }

        return baseFee + additionalFee;
    }

    // Static method to get total number of policies created
    public static int getPolicyCount() {
        return policyCount;
    }

    // toString method
    public String toString() {
        return "Policy Number: " + policyNumber + "\n" +
               "Provider Name: " + providerName + "\n" +
               policyHolder.toString() +
               "Policy Price: $" + String.format("%.2f", calculatePolicyPrice()) + "\n";
    }
}
