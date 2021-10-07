package lab2;
import javax.swing.*;
public class SecondFrame {
    static JLabel a;
    static JLabel b;
    static JLabel c;
    static JLabel d;
    static JLabel e;

    private JFrame f = new JFrame("Second");

    public SecondFrame() {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,300);
        f.setVisible(true);
    }

    public SecondFrame(String ho, String ten, String email, String matKhau, String ngaySinh) {
        f = new JFrame("textfield");

        // create a label to display text
        a = new JLabel(ho + " | ");
        b = new JLabel(ten+ " | ");
        c = new JLabel(email+ " | ");
        d = new JLabel(matKhau+ " | ");
        e = new JLabel(ngaySinh+ " | ");
        JPanel p = new JPanel();
        p.add(a);
        p.add(b);
        p.add(c);
        p.add(d);
        p.add(e);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,300);
        f.setVisible(true);

    }
}