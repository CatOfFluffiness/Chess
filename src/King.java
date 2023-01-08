import java.util.Objects;

public class King extends ChessPiece{
    public King(String color) {super(color);}

    public String getColor() {return this.color;}

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //Возможные королёвые ходы
        int[][] kingMoves = {
                {line - 1, column - 1}, {line + 1, column + 1},
                {line + 1, column - 1}, {line - 1, column + 1},
                {line - 1, column}, {line, column - 1},
                {line + 1, column}, {line, column + 1}};

        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)){                            //Выходит король за пределы доски?
            if (line != toLine || column != toColumn &&                                                               //Нельзя ходить на месте
                    (chessBoard.board[toLine][toColumn] == null && chessBoard.board[line][column] != null ||          //Ходить нужно по доске на пустое место с не пустого
                            Objects.equals(chessBoard.board[toLine][toColumn].color, this.color))  &&                 //Или кого-нибудь есть
                    Objects.equals(chessBoard.board[line][column], this)) {

                for (int[] kingMove : kingMoves)                                                                      //Проверка хода короли по линиям и колоннам
                    if (kingMove[0] == toLine && kingMove[1] == toColumn)
                        return true;
            } else return false;
        }return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (checkPos(line) && checkPos(column)) {
            for (int l = 0, c = 0; l < 7 && c < 7; l++, c++) {
                if (chessBoard.board[l][c] != null) {
                    if (Objects.equals(chessBoard.board[l][c].getColor(), color) &&
                            chessBoard.board[l][c].canMoveToPosition(chessBoard, l, c, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public String getSymbol() {return "K";}

    private boolean checkPos(int pos) {
        return (pos >= 0 && pos <= 7);
    }
}
