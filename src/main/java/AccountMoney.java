public class AccountMoney {
    private double money;
    private String currency;

    public AccountMoney(double money, String currency) {
        this.money = money;
        this.currency = currency;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void withdraw(double sum, String currency, double overdraftFee, double overdraftDiscount) {
        if (!this.currency.equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
        weAreInOverdraft(sum, overdraftFee, overdraftDiscount);
    }

    private void weAreInOverdraft(double sum, double overdraftFee, double overdraftDiscount) {
        if (money < 0) {
            money = (money - sum) - sum * overdraftFee * overdraftDiscount;
        } else {
            money = money - sum;
            int i = 0;
        }
    }
}
