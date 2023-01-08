
public class Pawn  extends ChessPiece{

    public Pawn(String color) {super(color);}

    @Override
    public String getColor() {return this.color;}


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        int pawnMoves;

        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)                              //На доске ли пешка окажется в движении
                && chessBoard.board[line][column] != null && column == toColumn) {                                    //Никого не трогает

                if (color.equals("White")) {                                                                          //Ход белых пешек
                    pawnMoves = 1;
                } else {                                                                                               //Ход черных
                    pawnMoves = -1;
                }

                if (line + pawnMoves == toLine) {return true;}                                                        //Ходить пешкой надо прямо

            return line == 1 | line == 6 && line + 2 * pawnMoves == toLine;                                           //Со стартовой позиции можно шагнуть на 2 клетки

            } else if (column != toColumn){                                                                           // Планирует потрогать

            if ((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1) && // check that piece another color
                    chessBoard.board[toLine][toColumn] != null) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(color);
            } else return false;
        }return false;
}

    @Override
    public String getSymbol() {return "P";}

    private boolean checkPos(int pos) {
        return (pos >= 0 && pos <= 7);
    }
}
