import java.util.Objects;

public class Horse extends ChessPiece {
    public Horse(String color) {super(color);}

    @Override
    public String getColor() {return this.color;}

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)){                            //Выходит лошадь за пределы доски?
            if (line != toLine && column != toColumn &&                                                               //Нельзя ходить на месте
                    (chessBoard.board[toLine][toColumn] == null && chessBoard.board[line][column] != null ||          //Ходить нужно на пустое место с не пустого
                            Objects.equals(chessBoard.board[toLine][toColumn].color, this.color))  &&                 //Проверка цвета
                    Objects.equals(chessBoard.board[line][column], this)) {

                //Возможные лошадиные ходы
                int[][] horsePositions = new int[][]{
                        {line - 2, column - 1}, {line - 2, column + 1},
                        {line + 2, column - 1}, {line + 2, column + 1},
                        {line - 1, column - 2}, {line - 1, column + 2},
                        {line + 1, column - 2}, {line + 1, column + 2}};

                for (int[] horsePosition : horsePositions) {                                                          //Проверка хода лошади по линиям и колоннам
                    if (horsePosition[0] == toLine && horsePosition[1] == toColumn)
                        return true;
                }
        } else return false;
    }return false;
    }

    @Override
    public String getSymbol() {return "H";}

    public boolean checkPos(int pos) {                                                                                //Метод для проверки выхода за пределы доски
        return (pos >= 0 && pos <= 7);
    }
}
