import java.util.List;

public class RacePrinter {

    private RacePrinter() {
    }

    public static void printTheRace(Race race) {
        List<BestLap> bestLapList = race.getBestLapListSortedByTimeForFirstFifteen();
        for (int i = 0; i < bestLapList.size(); i++) {
            printSingleBestLap(bestLapList.get(i), i + 1);
        }
        printLine('=',50);

        List<BestLap> bestLapListAfterFifteen = race.getBestLapListSortedByTimeAfterFirstFifteen();
        for (int i = 0; i < bestLapListAfterFifteen.size(); i++) {
            printSingleBestLap(bestLapListAfterFifteen.get(i), i + 16);
        }
    }

    private static void printLine(char symbol, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(symbol);
        }
        System.out.print('\n');
    }
    private static void correctPrintSize(){

    }

    private static void printSingleBestLap(BestLap bestLap, int place) {

        System.out.println(String.format("%02d. %s | %s | %s",
                place, bestLap.getRacer().getName(), bestLap.getRacer().getTeam(), bestLap.getTIme()));
    }

}
