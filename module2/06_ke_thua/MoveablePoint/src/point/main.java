package point;

public class main {
    public static void main(String[] args) {
        MoveablePoint a = new MoveablePoint(3,4,5,6);
        System.out.println(a.toString());
        a.move();
        System.out.println(a.toString());
    }
}
