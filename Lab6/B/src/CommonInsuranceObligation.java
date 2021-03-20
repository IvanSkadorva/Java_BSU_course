import java.io.Serializable;

public class CommonInsuranceObligation extends InsuranceObligation implements InsuranceObligationInformation, Serializable {
    CommonInsuranceObligation(double cost, int riskDegree) {
        super(cost, riskDegree, "health");
    }

    public void getInformationAboutObligation() {
        System.out.println("""
                A consideration of value that is insured under a policy.
                 A person with insurable interest will suffer a genuine hardship if a loss should occur to the person or property they've insured. 
                 For instance, people have an insurable interest in their own lives and property, 
                 but generally do not have insurable interest in their neighbor's life or property. 
                Insurable interest must be present in order for an insurance contract to be legal and valid.
                """);

    }
}
