package Fan;

public class FanMain {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setColor("Đỏ");
        fan1.setOn(true);
        fan1.setRadius(30);
        fan1.setSpeed(1);
        System.out.println(fan1.toString());
        Fan fan2 = new Fan();
        fan2.setColor("Xanh");
        fan2.setOn(false);
        fan2.setRadius(35);
        fan2.setSpeed(2);
        System.out.println(fan2.toString());

    }


}
