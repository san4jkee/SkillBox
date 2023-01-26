import java.util.Date;

public class Operations {
    private String accountType;
    private Double accountNumber;
    private String currency;
    private Date dateOfOperation;
    private String transactionReference;
    private String descriptionOfTheOperation;
    private Double coming;
    private Double expenditure;

    public Operations(String accountType,
                      Double accountNumber,
                      String currency,
                      Date dateOfOperation,
                      String transactionReference,
                      String descriptionOfTheOperation,
                      Double coming,
                      Double expenditure) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.dateOfOperation = dateOfOperation;
        this.transactionReference = transactionReference;
        this.descriptionOfTheOperation = descriptionOfTheOperation;
        this.coming = coming;
        this.expenditure = expenditure;
    }

    public String getAccountType() {
        return accountType;
    }
}
