public class PersonCustomer extends Customer {
    public PersonCustomer(String name, String surname, String email, CustomerType customerType, Account account) {
        super(name, surname, email, customerType, account);
    }

    @Override
    protected void weAreInOverdraft(double sum) {
        if (getAccount().getMoney() < 0) {
            getAccount().setMoney((getAccount().getMoney() - sum) - sum * getAccount().overdraftFee());
        } else {
            getAccount().setMoney(getAccount().getMoney() - sum);
        }
    }
}
