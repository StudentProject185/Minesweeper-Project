package Part02;

public class Move {
    private int row;
    private int column;
    private boolean wasSafe;

    public Move(int row, int column, boolean wasSafe) {
        this.row = row;
        this.column = column;
        this.wasSafe = wasSafe;
    }
}
