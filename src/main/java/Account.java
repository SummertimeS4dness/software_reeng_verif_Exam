public class Account {

    private String iban;

    private AccountType type;

    private int daysOverdrawn;

    private AccountMoney accountMoney;

    private Customer customer;

    public Account(AccountType type, int daysOverdrawn) {
        super();
        this.type = type;
        this.daysOverdrawn = daysOverdrawn;
    }

    public double bankcharge() {
        double result = 4.5;

        result += overdraftCharge();

        return result;
    }

    private double overdraftCharge() {
        if (type.isPremium()) {
            double result = 10;
            if (getDaysOverdrawn() > 7)
                result += (getDaysOverdrawn() - 7) * 1.0;
            return result;
        } else
            return getDaysOverdrawn() * 1.75;
    }

    public double overdraftFee() {
        if (type.isPremium()) {
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

    public AccountType getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Account: IBAN: " + iban + ", Money: " + accountMoney.getMoney() + ", Account type: " + type;
    }
}
