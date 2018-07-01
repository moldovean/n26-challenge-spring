package club.cheapok.n26.event;

import club.cheapok.n26.model.Transaction;
import org.springframework.context.ApplicationEvent;

public class TransactionToBeRemovedEvent extends ApplicationEvent {
    private final Transaction transaction;

    public TransactionToBeRemovedEvent(final Object source, final Transaction transaction) {
        super(source);
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
