public class CompanyCustomer extends Customer {
    public CompanyCustomer(String name, String surname, String email, CustomerType customerType, Account account) {
        super(name, surname, email, customerType, account);
    }

    // use only to create companies
    public CompanyCustomer(String name, String email, Account account, double companyOverdraftDiscount) {
        super(name, email, account, companyOverdraftDiscount);
    }

    @Override
    protected void weAreInOverdraft(double sum) {
        if (getAccount().getMoney() < 0) {
            getAccount().setMoney((getAccount().getMoney() - sum) - sum * getAccount().overdraftFee() * getCompanyOverdraftDiscountBasedOnPremium());
        } else {
            getAccount().setMoney(getAccount().getMoney() - sum);
        }
    }

    private double getCompanyOverdraftDiscountBasedOnPremium() {
        return getAccount().getType().isPremium() ? getCompanyOverdraftDiscount() / 2 : getCompanyOverdraftDiscount();
    }
}
