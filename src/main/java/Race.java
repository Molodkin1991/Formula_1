import java.util.Comparator;
import java.util.List;

public class Race {
    List<BestLap> bestLapList;

    public Race(List<BestLap> bestLapList) {
        this.bestLapList = bestLapList;
    }

    public List<BestLap> getBestLapListSortedByTimeForFirstFifteen() {
        return bestLapList.stream()
                .sorted(Comparator.comparingLong(BestLap::lapSeconds).thenComparingInt(BestLap::lapNanoSeconds))
                .toList().subList(0, 14);
    }

    public List<BestLap> getBestLapListSortedByTimeAfterFirstFifteen() {
        return bestLapList.stream()
                .sorted(Comparator.comparingLong(BestLap::lapSeconds).thenComparingInt(BestLap::lapNanoSeconds))
                .toList().subList(14, bestLapList.size());
    }

    @Override
    public String toString() {
        return "Race{" +
                "bestLapList=" + bestLapList +
                '}';
    }
}
