import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsuranceObligation {
    public Double cost;
    public Integer riskDegree;
    public String insuranceSubject;
    List<InsuranceObligation> derivative = new ArrayList<InsuranceObligation>(0);


    InsuranceObligation(Double cost, Integer riskDegree, String insuranceSubject) {
        this.cost = cost;
        this.riskDegree = riskDegree;
        this.insuranceSubject = insuranceSubject;
    }

    InsuranceObligation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input an insurance subject: ");
        this.insuranceSubject = scanner.nextLine();
        System.out.println("Input cost: ");
        this.cost = scanner.nextDouble();
        System.out.println("Input risk degree: ");
        this.riskDegree = scanner.nextInt();

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(String.format("The insurance obligation of %-2s with cost %-1s and risk degree %-1s", insuranceSubject, cost, riskDegree));
        for (InsuranceObligation obligation : derivative) {
            sb.append(System.getProperty("line.separator")).append(obligation.toString());
        }
        return sb.toString();
    }
}
