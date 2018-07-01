package club.cheapok.n26.model;

import java.io.Serializable;

public class Statistics implements Serializable {

    private static final long serialVersionUID = -4297539591084785833L;

    public static final Statistics EMPTY = new Statistics(0, 0, 0, 0, 0);

    private final double sum;
    private final double avg;
    private final double max;
    private final double min;
    private final long count;

    public Statistics(final double sum,
                      final double avg,
                      final double max,
                      final double min,
                      final long count) {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public long getCount() {
        return count;
    }
}
