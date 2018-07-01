package club.cheapok.n26.service.impl;

import club.cheapok.n26.model.Statistics;
import club.cheapok.n26.model.Transaction;
import club.cheapok.n26.repository.TransactionRepository;
import club.cheapok.n26.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    private Statistics statistics;

    private final TransactionRepository transactionRepository;

    public StatisticsServiceImpl(final TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void updateStatistics() {
        double sum = 0;
        double max = 0;
        double min = 0;

        final List<Transaction> transactions = transactionRepository.transactions();
        final int size = transactions.size();

        if (size == 0) {
            statistics = Statistics.EMPTY;
            return;
        }

        for (Transaction transaction : transactions) {
            final double amount = transaction.getAmount();

            sum += amount;

            if (amount > max) max = amount;

            if (min == 0 || amount < min) min = amount;
        }

        statistics = new Statistics(sum, sum / size, max, min, size);
    }

    @Override
    public Statistics getSummary() {
        return statistics == null ? Statistics.EMPTY : statistics;
    }

}
