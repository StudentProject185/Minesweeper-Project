package Part03;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MatchDataset {

    private SortedSet<MatchSummary> matches;

    public MatchDataset() {
        this.matches = new TreeSet<>();
    }

    public void addMatch(MatchSummary match) {
        matches.add(match);
    }

    public SortedSet<MatchSummary> getMatches() {
        return matches;
    }

    public long countByResult(String result) {
        return matches.stream()
                .filter(m -> m.getResult().equalsIgnoreCase(result))
                .count();
    }

    public Double getAverageClicksByResult(String result) {
        return matches.stream()
                .filter(m -> m.getResult().equalsIgnoreCase(result))
                .mapToInt(MatchSummary::getTotalClicks)
                .average()
                .orElse(0.0);
    }

    public MatchSummary getMatchWithHighestClickRate() {
        return matches.stream()
            .max(Comparator.comparingDouble(m -> {
                long t = m.getTimeMs() == 0 ? 1 : m.getTimeMs(); 
                return (double) m.getTotalClicks() / t;
            }))
            .orElse(null);
    }
}