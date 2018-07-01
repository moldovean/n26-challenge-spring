package club.cheapok.n26.event.listener;

import club.cheapok.n26.event.TransactionToBeRemovedEvent;
import club.cheapok.n26.model.Transaction;
import club.cheapok.n26.repository.TransactionRepository;
import club.cheapok.n26.service.StatisticsService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionToBeRemovedEventListener implements ApplicationListener<TransactionToBeRemovedEvent> {
    private final StatisticsService statisticsService;
    private final TransactionRepository transactionRepository;

    public TransactionToBeRemovedEventListener(final StatisticsService statisticsService,
                                               final TransactionRepository transactionRepository) {
        this.statisticsService = statisticsService;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void onApplicationEvent(final TransactionToBeRemovedEvent event) {
        final Transaction transaction = event.getTransaction();

        try {
            Thread.sleep(transaction.getTimestamp() + 60000 - System.currentTimeMillis());
        } catch (InterruptedException ignored) {
        }

        transactionRepository.remove(transaction);
        statisticsService.updateStatistics();
    }

}
