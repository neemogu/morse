import java.util.HashSet;
import java.util.Set;

public class StatisticsCounter {
    private final Set<Statistics> statTable = new HashSet<>();
    public void CountChar(String ch) {
        Statistics newStat = new Statistics(ch);
        if (!statTable.contains(newStat)) {
            newStat.countIncrement();
            statTable.add(newStat);
        }
        else {
            for (Statistics stat : statTable) {
                if (stat.equals(newStat)) {
                    stat.countIncrement();
                    break;
                }
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Statistics stat : statTable) {
            result.append("'")
                    .append(stat.getCharName())
                    .append("'")
                    .append(" : ")
                    .append(stat.getValue())
                    .append('\n');
        }
        return result.toString();
    }
}
