package Part02;

import java.io.FileWriter;
import java.io.IOException;

import Part01.Board;
import Part01.GameOutcome;

public class GamesSimulator {
    public static Player createBot(Board board) {
        return new Player(board);
    }

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("matches.csv");
        fw.write("MatchId,BotType,Result,TimeMs,TotalClicks\n");

        for (int matchCount = 1; matchCount <= 1000; matchCount++) {
            Board board = new Board(8, 6);
            Player bot = createBot(board);

            long start = System.currentTimeMillis();

            GameOutcome result = bot.playTurn();
            while (result == GameOutcome.IN_PROGRESS) {
                result = bot.playTurn();
            }
            
            long timeMs = System.currentTimeMillis() - start;

            int clicks = 0;
            NodeMove click = bot.getMoveHistory().getHead();
            while (click != null) {
                clicks++;
                click = click.next;
            }

            fw.write(String.format("%04d", matchCount) + ",RandomBot," + result + "," + timeMs + "," + clicks + "\n");
        }

        fw.close();
    }
}
