package Circle;

import Shape.Shape;

public class SquareTest {
    public static void main(String[] args) {
        Square[] squares = new Square[3];

        squares[0] = new Square(4);
        squares[1] = new Square(3);
        squares[2] = new Square(5);

        for (Square square : squares) {
            System.out.println(square);
            square.howToColor();

        }
    }
}
