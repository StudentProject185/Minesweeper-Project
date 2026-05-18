package Part03;

import Part03.MatchDataset;
import Part03.MatchFactory;
import Part03.MatchSummary;

public class TestMatchesAnalysis {

    public static void main(String[] args) {

        String filePath = "matches.csv";

        MatchDataset dataset = MatchFactory.fromCsvFile(filePath);

        System.out.println("Total matches loaded: " + dataset.getMatches().size());
        System.out.println("  - VICTORY: " + dataset.countByResult("VICTORY"));
        System.out.println("  - DEFEAT:  " + dataset.countByResult("DEFEAT"));
        System.out.println();

        System.out.println("All Matches (sorted by time):");
        for (MatchSummary m : dataset.getMatches()) {
            System.out.println(m);
        }
        System.out.println();

        double avgVictoryClicks = dataset.getAverageClicksByResult("VICTORY");
        System.out.printf("Average clicks on VICTORY: %.2f%n", avgVictoryClicks);

        double avgDefeatClicks = dataset.getAverageClicksByResult("DEFEAT");
        System.out.printf("Average clicks on DEFEAT:  %.2f%n", avgDefeatClicks);

        System.out.println();

        MatchSummary fastest = dataset.getMatchWithHighestClickRate();
        if (fastest != null) {
            long t = fastest.getTimeMs() == 0 ? 1 : fastest.getTimeMs();
            double rate = (double) fastest.getTotalClicks() / t;
            
            System.out.println("Match with Highest Click Rate:");
            System.out.println(fastest);
            System.out.printf("Click rate: %.2f clicks/ms%n", rate);
        }
    }
}