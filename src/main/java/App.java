import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/abbreviations.txt";
        String filePath2 = "src/main/resources/end.log";
        String filePath3 = "src/main/resources/start.log";

        Race race = RaceParser.getRace(filePath, filePath3, filePath2);
        RacePrinter.printTheRace(race);

    }
}