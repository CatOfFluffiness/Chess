import java.util.Objects;

public class Rook extends ChessPiece{
    public Rook(String color) {super(color);}

    public String getColor() {return this.color;}
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //Возможные ладьёвые ходы
        int[][] rookMoves = {
                {line - 1, column}, {line, column - 1},
                {line - 2, column}, {line, column - 2},
                {line - 3, column}, {line, column - 3},
                {line - 4, column}, {line, column - 4},
                {line - 5, column}, {line, column - 5},
                {line - 6, column}, {line, column - 6},
                {line - 7, column}, {line, column - 7},
                {line + 1, column}, {line, column + 1},
                {line + 2, column}, {line, column + 2},
                {line + 3, column}, {line, column + 3},
                {line + 4, column}, {line, column + 4},
                {line + 5, column}, {line, column + 5},
                {line + 6, column}, {line, column + 6},
                {line + 7, column}, {line, column + 7}};

        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)){                            //Выходит ладья за пределы доски?
            if ((line != toLine || column != toColumn &&                                                              //Нельзя ходить на месте
                    chessBoard.board[toLine][toColumn] == null && chessBoard.board[line][column] != null ||           //Ходить нужно по доске на пустое место с не пустого
                            Objects.equals(chessBoard.board[toLine][toColumn].color, this.color))  &&                 //Или кого-нибудь есть
                    Objects.equals(chessBoard.board[line][column], this)) {

                for (int[] rookMove : rookMoves)                                                                      //Проверка возможных ладьёвых ходов
                    if (rookMove[0] == toLine && rookMove[1] == toColumn)
                        return true;
            } else return false;
        }return false;
    }

    @Override
    public String getSymbol() {return "R";}

    private boolean checkPos(int pos) {
        return (pos >= 0 && pos <= 7);
    }
}
