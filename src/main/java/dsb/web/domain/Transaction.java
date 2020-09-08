package dsb.web.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private int transactionID;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account transactionAccountDebet;
    @ManyToOne(fetch = FetchType.LAZY)
    private Account transactionAccountCredit;

    private double transactionAmount;
    private String message;
    private Timestamp transactionTimestamp;

    public Transaction(int transactionID, Account transactionAccountDebet, Account transactionAccountCredit, double transactionAmount, String message, Timestamp transactionTimestamp) {
        this.transactionID = transactionID;
        this.transactionAccountDebet = transactionAccountDebet;
        this.transactionAccountCredit = transactionAccountCredit;
        this.transactionAmount = transactionAmount;
        this.message = message;
        this.transactionTimestamp = transactionTimestamp;
    }

    public Transaction(Account transactionAccountDebet, Account transactionAccountCredit, double transactionAmount, String message, Timestamp transactionTimestamp) {
        this(0, transactionAccountDebet, transactionAccountCredit, transactionAmount, message, transactionTimestamp);
    }

    public Transaction() {
    }


    @Override
    //TODO evt nog bijwerken
    public String toString() {
        String s = new SimpleDateFormat("MM/dd/yyyy '|' HH:mm").format(transactionTimestamp);
        return String.format("%s - %s - %s - %.2f - %s", s, transactionAccountDebet.getAccountNo(),
                transactionAccountCredit.getAccountNo(), transactionAmount, message);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return  Double.compare(that.getTransactionAmount(), getTransactionAmount()) == 0 &&
                getTransactionAccountDebet().equals(that.getTransactionAccountDebet()) &&
                getTransactionAccountCredit().equals(that.getTransactionAccountCredit()) &&
                getMessage().equals(that.getMessage()) &&
                getTransactionTimestamp().equals(that.getTransactionTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransactionID(), getTransactionAccountDebet(), getTransactionAccountCredit(), getTransactionAmount(), getMessage(), getTransactionTimestamp());
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public Account getTransactionAccountDebet() {
        return transactionAccountDebet;
    }

    public void setTransactionAccountDebet(Account transactionAccountDebet) {
        this.transactionAccountDebet = transactionAccountDebet;
    }

    public Account getTransactionAccountCredit() {
        return transactionAccountCredit;
    }

    public void setTransactionAccountCredit(Account transactionAccountCredit) {
        this.transactionAccountCredit = transactionAccountCredit;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(Timestamp transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }
}
