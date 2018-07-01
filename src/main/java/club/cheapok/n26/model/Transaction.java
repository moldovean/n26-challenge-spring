package club.cheapok.n26.model;

import club.cheapok.n26.constraint.AcceptedRange;

import javax.validation.constraints.Positive;
import java.io.Serializable;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 874428129454357036L;

    @Positive(message = "Amount should be positive")
    private double amount;

    @AcceptedRange(message = "Transaction is too old", seconds = 60)
    private long timestamp;

    public Transaction() {
    }

    public double getAmount() {
        return amount;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
