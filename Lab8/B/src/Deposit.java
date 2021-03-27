public interface Deposit {
    Double accrual = 0.0;
    Boolean revocable = false;
    String currency = "$";
    String duration = "long-term";
    void getDepositInfo();
    void setDuration(String newDuration);
    boolean isRevocable();
    BankDeposit openNewDepositWithCurrency(String newCurrency);
    Double getAccrual();
}
