import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Policy> policyList = new ArrayList<>();

        try {
            File file = new File("PolicyInformation.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                int policyNumber = Integer.parseInt(fileScanner.nextLine());
                String providerName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String lastName = fileScanner.nextLine();
                int age = Integer.parseInt(fileScanner.nextLine());
                String smokingStatus = fileScanner.nextLine();
                double height = Double.parseDouble(fileScanner.nextLine());
                double weight = Double.parseDouble(fileScanner.nextLine());

                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policyList.add(policy);
            }

            fileScanner.close();

            // Temporary check to make sure everything loaded
           int smokerCount = 0;
int nonSmokerCount = 0;

for (Policy policy : policyList) {
    System.out.println("\nPolicy Number: " + policy.getPolicyNumber());
    System.out.println("Provider Name: " + policy.getProviderName());
    System.out.println("Policyholder's First Name: " + policy.getPolicyholderFirstName());
    System.out.println("Policyholder's Last Name: " + policy.getPolicyholderLastName());
    System.out.println("Policyholder's Age: " + policy.getPolicyholderAge());
    System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
    System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
    System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
    System.out.printf("Policyholder's BMI: %.2f%n", policy.calculateBMI());
    System.out.printf("Policy Price: $%.2f%n", policy.calculatePolicyPrice());

    // Count smokers vs. non-smokers
    if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) {
        smokerCount++;
    } else {
        nonSmokerCount++;
    }
}

System.out.println("\nThe number of policies with a smoker is: " + smokerCount);
System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found! Make sure PolicyInformation.txt is in the same folder.");
            System.out.println("Current directory: " + System.getProperty("user.dir"));
        }
    }
}
