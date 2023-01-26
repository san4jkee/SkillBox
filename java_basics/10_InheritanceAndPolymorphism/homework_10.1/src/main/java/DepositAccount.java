import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {
    public LocalDate lastIncome;

    @Override
    protected boolean take(double amountToTake) {
        if (amountToTake < amount && lastIncome.plus(1, ChronoUnit.MONTHS).isBefore(LocalDate.now())) {
            amount = amount - amountToTake;
        }
        return false;
    }
}
