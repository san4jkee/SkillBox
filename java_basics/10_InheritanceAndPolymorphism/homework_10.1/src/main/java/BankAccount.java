
public class BankAccount {
  double amount;

  public double getAmount() {
    return amount;
  }

  public boolean put(double amountToPut) {
    if (amountToPut > 0){
      amount = amount + amountToPut;
      return true;
    }
    return false;
  }

  protected boolean take(double amountToTake) {
    if (amountToTake < amount) {
      amount = amount - amountToTake;
      return true;
    }
    return false;
  }
}
