package club.cheapok.n26.service;

import club.cheapok.n26.model.Statistics;

public interface StatisticsService {
    void updateStatistics();

    Statistics getSummary();
}
