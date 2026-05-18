package Part02;
import Part01.Board;
import Part01.CellState;
import Part01.GameOutcome;
import java.util.Random;


public class Player {
    private MyLinkedList moveHistory = new MyLinkedList();
    private Board board;
	Random r = new Random();

    public Player(Board board) {
        this.board = board;
    }

    public GameOutcome playTurn() {
        int size = board.getGridLength();
        int[][] hidden = new int[size * size][2];
        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.getCell(i, j).getStatus() == CellState.HIDDEN) {
                    hidden[count][0] = i;
                    hidden[count][1] = j;
                    count++;
                }
            }
        }
        int rInt = r.nextInt(0, count);

        board.revealCell(hidden[rInt][0], hidden[rInt][1]);
        Move move = new Move(hidden[rInt][0], hidden[rInt][1], !board.getCell(hidden[rInt][0], hidden[rInt][1]).isMine());
        this.moveHistory.insert(move);

        return board.getGameState();
    }

    public MyLinkedList getMoveHistory() {
        return this.moveHistory;
    }
}
