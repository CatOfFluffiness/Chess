import java.util.Objects;

public class Bishop extends ChessPiece{
    public Bishop(String color) {super(color);}

    public String getColor() {return this.color;}

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //Возможные слоновые ходы
        int[][] bishopMoves = {
                {line - 1, column - 1}, {line + 1, column + 1},
                {line - 2, column - 2}, {line + 2, column + 2},
                {line - 3, column - 3}, {line + 3, column + 3},
                {line - 4, column - 4}, {line + 4, column + 4},
                {line - 5, column - 5}, {line + 5, column + 5},
                {line - 6, column - 6}, {line + 6, column + 6},
                {line - 7, column - 7}, {line + 7, column + 7},
                {line + 1, column - 1}, {line - 1, column + 1},
                {line + 2, column - 2}, {line - 2, column + 2},
                {line + 3, column - 3}, {line - 3, column + 3},
                {line + 4, column - 4}, {line - 4, column + 4},
                {line + 5, column - 5}, {line - 5, column + 5},
                {line + 6, column - 6}, {line - 6, column + 6},
                {line + 7, column - 7}, {line - 7, column + 7}};

        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)){                            //Выходит слон за пределы доски?
            if (line != toLine && column != toColumn &&                                                               //Нельзя ходить на месте
                    (chessBoard.board[toLine][toColumn] == null && chessBoard.board[line][column] != null ||          //Ходить нужно по доске на пустое место с не пустого
                            Objects.equals(chessBoard.board[toLine][toColumn].color, this.color))  &&                 //Или кого-нибудь есть
                    Objects.equals(chessBoard.board[line][column], this)) {

                for (int[] bishopMove : bishopMoves)                                                                  //Проверка хода слона по линиям и колоннам
                    if (bishopMove[0] == toLine && bishopMove[1] == toColumn)
                        return true;
            } else return false;
        }return false;
    }

    @Override
    public String getSymbol() {return "B";}

    private boolean checkPos(int pos) {
        return (pos >= 0 && pos <= 7);
    }
}
