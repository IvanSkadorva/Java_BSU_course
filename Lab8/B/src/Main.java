import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * @author Ivan Skadorva.
     * Банковский вклад.
     * Возможности: изменить продолжительность вклада (бессрочный/долгосрочный/краткосрочный);
     * узнать, какой вклад (отзывной или безотзывной);
     * закрыть один вклад и открыть новый с такими же условиями, но в другой валюте;
     * рассчитать начисление процентов по вкладу.
     */
    public static void main(String[] args) {

        BankDeposit deposit = new BankDeposit();
        System.out.println("A: get deposit info");
        System.out.println("B: set new duration ");
        System.out.println("C: is it revocable ");
        System.out.println("D: Open a new deposit with other currency ");
        System.out.println("E: get accrual ");
        System.out.println("Q: Quit");

        String choice = "";
        while (!choice.equals("Q")) {
            System.out.println("Select something: ");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();
            switch (choice) {
                case "A" -> System.out.println("Deposit : " + deposit.toString());
                case "B" -> {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Enter new duration: ");
                    String duration = in.nextLine();
                    deposit.setDuration(duration);
                }
                case "C" -> System.out.println(" Is the deposit revocable: " + deposit.isRevocable());
                case "D" -> {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Enter new currency: ");
                    String currency = in.nextLine();
                    deposit = deposit.openNewDepositWithCurrency(currency);
                }
                case "E" -> System.out.println("Accrual is: " + deposit.getAccrual());

            }
        }

    }
}
