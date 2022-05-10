import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class FileAbbreviationsReader {
    private FileAbbreviationsReader() {
    }

    public static Map<String, Racer> getMapWithRacers(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Charset charset = StandardCharsets.UTF_8;
        return Files.readAllLines(path, charset).stream()
                .map(line -> line.split("_"))
                .collect(Collectors.toMap(
                        (String[] line) -> line[0],
                        (String[] line) -> new Racer(line[1], line[2]))
                );

    }
}
