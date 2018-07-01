package club.cheapok.n26.service.impl;

import club.cheapok.n26.event.TransactionToBeRemovedEvent;
import club.cheapok.n26.model.Transaction;
import club.cheapok.n26.repository.TransactionRepository;
import club.cheapok.n26.service.StatisticsService;
import club.cheapok.n26.service.TransactionService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final StatisticsService statisticsService;
    private final TransactionRepository transactionRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public TransactionServiceImpl(final StatisticsService statisticsService,
                                  final TransactionRepository transactionRepository,
                                  final ApplicationEventPublisher applicationEventPublisher) {
        this.statisticsService = statisticsService;
        this.transactionRepository = transactionRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void save(final Transaction transaction) {
        transactionRepository.save(transaction);
        statisticsService.updateStatistics();

        applicationEventPublisher.publishEvent(new TransactionToBeRemovedEvent(this, transaction));
    }

}
