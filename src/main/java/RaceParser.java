import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class RaceParser {
    public static Race getRace(
            String fileAbbreviations,
            String fileStart,
            String fileEnd) throws IOException {

        Map<String, Racer> mapWithRacers = FileAbbreviationsReader.getMapWithRacers(fileAbbreviations);
        Map<String, Instant> mapWithStartTime = FileTimesReader.getMapWithTimesTime(fileStart);
        Map<String, Instant> mapWithEndTime = FileTimesReader.getMapWithTimesTime(fileEnd);

        List<BestLap> bestLapList = mapWithRacers.entrySet().stream()
                .map(entry -> new BestLap(entry.getValue(), mapWithStartTime.get(entry.getKey()), mapWithEndTime.get(entry.getKey())))
                .toList();
        return new Race(bestLapList);
    }


}
