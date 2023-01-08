import java.util.Objects;

public class Horse extends ChessPiece {
    public Horse(String color) {super(color);}

    @Override
    public String getColor() {return this.color;}



    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //Возможные лошадиные ходы
        int[][] horseMoves = {
                {line - 2, column - 1}, {line - 2, column + 1},
                {line + 2, column - 1}, {line + 2, column + 1},
                {line - 1, column - 2}, {line - 1, column + 2},
                {line + 1, column - 2}, {line + 1, column + 2}};

        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)){                            //Выходит лошадь за пределы доски?
            if (line != toLine && column != toColumn &&                                                               //Нельзя ходить на месте
                    (chessBoard.board[toLine][toColumn] == null && chessBoard.board[line][column] != null ||          //Ходить нужно по доске на пустое место с не пустого
                            Objects.equals(chessBoard.board[toLine][toColumn].color, this.color))  &&                 //Или кого-нибудь есть
                    Objects.equals(chessBoard.board[line][column], this)) {

                for (int[] horseMove : horseMoves) {                                                          //Проверка хода лошади по линиям и колоннам
                    if (horseMove[0] == toLine && horseMove[1] == toColumn)
                        return true;
                }
        } else return false;
    }return false;
    }

    @Override
    public String getSymbol() {return "H";}

    private boolean checkPos(int pos) {
        return (pos >= 0 && pos <= 7);
    }
}
