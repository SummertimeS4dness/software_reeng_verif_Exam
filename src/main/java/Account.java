public class Account {

    private String iban;

    private boolean premium;;

    private int daysOverdrawn;

    private AccountMoney accountMoney;

    private Customer customer;

    public Account(boolean premium, int daysOverdrawn) {
        super();
        this.premium = premium;
        this.daysOverdrawn = daysOverdrawn;
    }

    public double bankcharge() {
        double result = 4.5;

        result += overdraftCharge();

        return result;
    }

    private double overdraftCharge() {
        if (premium) {
            double result = 10;
            if (getDaysOverdrawn() > 7)
                result += (getDaysOverdrawn() - 7) * 1.0;
            return result;
        } else
            return getDaysOverdrawn() * 1.75;
    }

    public double overdraftFee() {
        if (premium) {
            return 0.10;
        } else {
            return 0.20;
        }
    }

    public void withdraw(double sum, String currency) {
        accountMoney.withdraw(sum, currency, overdraftFee(), customer.getCompanyOverdraftDiscountBasedOnPremium());
    }

    public int getDaysOverdrawn() {
        return daysOverdrawn;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setAccountMoney(AccountMoney accountMoney) {
        this.accountMoney = accountMoney;
    }

    public AccountMoney getAccountMoney() {
        return accountMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getType() {
        return premium ? "premium" : "normal";
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "Account: IBAN: " + iban + ", Money: " + accountMoney.getMoney() + ", Account type: " + getType();
    }
}
