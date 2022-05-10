import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileAbbreviationsReaderTest {
    String filePath = "src/test/resources/abbreviations.txt";

    Racer racer1 = new Racer("Sebastian Vettel", "FERRARI");
    Racer racer2 = new Racer("Daniel Ricciardo", "RED BULL RACING TAG HEUER");

    Map<String, Racer> forTest = new HashMap<String, Racer>() {{
        put("SVF", racer1);
        put("DRR", racer2);
    }};

    @Test
    void ReadeFileWithAbbreviations() throws IOException {

        assertEquals(forTest, FileAbbreviationsReader.getMapWithRacers(filePath));
    }


}