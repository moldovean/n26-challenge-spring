package club.cheapok.n26.controller;

import club.cheapok.n26.model.Statistics;
import club.cheapok.n26.service.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(final StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    public Statistics statistics() {
        return statisticsService.getSummary();
    }

}
