import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

public class FileTimesReader {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS").withZone(ZoneOffset.UTC);

    private FileTimesReader() {
    }

    public static Map<String, Instant> getMapWithTimesTime(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Charset charset = StandardCharsets.UTF_8;
        return Files.readAllLines(path, charset).stream()
                .collect(Collectors
                        .toMap(
                                (String line) -> line.substring(0, 3),
                                (String line) -> Instant.from(DATE_TIME_FORMATTER.parse(line.substring(3)))
                        ));
    }
}
