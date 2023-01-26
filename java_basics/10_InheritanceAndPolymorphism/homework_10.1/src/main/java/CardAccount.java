public class CardAccount extends BankAccount {
    @Override
    public boolean take(double amount) {
        return super.take(amount * 1.01);
    }
}
