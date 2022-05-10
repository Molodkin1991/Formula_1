import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

public class BestLap implements Comparable<BestLap> {
    private final Racer racer;
    private final Instant start;
    private final Instant finish;

    public BestLap(final Racer racer,
                   final Instant start,
                   final Instant finish) {
        this.racer = racer;
        this.start = start;
        this.finish = finish;
    }

    public Racer getRacer() {
        return racer;
    }

    public Duration getTIme() {
        return Duration.between(start, finish);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BestLap)) return false;
        BestLap bestLap = (BestLap) o;
        return Objects.equals(racer, bestLap.racer) && Objects.equals(start, bestLap.start) && Objects.equals(finish, bestLap.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racer, start, finish);
    }

    @Override
    public String toString() {
        return "BestLap{" +
                "racer=" + racer +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }

    public Long lapSeconds() {
        return finish.getEpochSecond() - start.getEpochSecond();
    }

    public Integer lapNanoSeconds() {
        return finish.getNano() - start.getNano();
    }

    @Override
    public int compareTo(BestLap o) {
        int seconds = this.lapSeconds().compareTo(o.lapSeconds());
        return seconds != 0 ? seconds : this.lapNanoSeconds().compareTo(o.lapNanoSeconds());
    }
}
