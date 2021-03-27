import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankDeposit implements  Deposit {
    public Double accrual;
    public Boolean revocable;
    public String currency;
    public String duration;
    List<BankDeposit> deposits = new ArrayList<BankDeposit>(0);


    BankDeposit(Double accrual, Boolean revocable, String currency, String duration) {
        this.accrual = accrual;
        this.duration = duration;
        this.revocable = revocable;
        this.currency = currency;

    }

    BankDeposit() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a duration: ");
        this.duration = scanner.nextLine();
        System.out.println("Input an accrual: ");
        this.accrual = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Input a currency: ");
        this.currency = scanner.nextLine();
        System.out.println("Is it revocable? ");
        this.revocable = scanner.nextBoolean();
        System.out.println("That's it! ");


    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(String.format("The bank deposit with %-2s accrual, also it's the %-1s %-1s bank deposit in %-1s", accrual, duration, revocable, currency ));
        for (BankDeposit deposit : deposits) {
            sb.append(System.getProperty("line.separator")).append(deposit.toString());
        }
        return sb.toString();
    }

    @Override
    public void getDepositInfo() {
        System.out.println("this is a deposit of something");
    }

    @Override
    public void setDuration(String newDuration) {
        this.duration = newDuration;
    }

    @Override
    public boolean isRevocable() {
        return this.revocable;
    }

    @Override
    public BankDeposit openNewDepositWithCurrency(String newCurrency) {
        return new BankDeposit(this.accrual, this.revocable, newCurrency, this.duration);
    }

    @Override
    public Double getAccrual() {
        return this.accrual;
    }
}
