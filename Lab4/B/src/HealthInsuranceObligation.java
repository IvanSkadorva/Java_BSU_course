public class HealthInsuranceObligation extends  InsuranceObligation implements InsuranceObligationInformation{
    HealthInsuranceObligation(double cost, int riskDegree){
        super(cost, riskDegree, "health");
    }

    public void getInformationAboutObligation(){
        System.out.println("""
                In order to meet health insurance requirements, a small business must provide copies of all relevant legal, tax, and accounting information when applying for group coverage. Employers are required to submit certain forms of documentation, including:
                           
                Proof of business location
                Proof of business type
                Payroll 
                This standard information is used to verify and authenticate the legitimacy of a small business, and much of it is available through a previous year’s business tax filings. Ensuring that your company provides the right documentation can help streamline the process of meeting the health insurance requirements needed to offer group coverage to your employees.""");
    }
}
