package form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form {


    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public static void main(String[] args) {
        Form form = new Form();
        form.go();
    }
    public void go(){
        JFrame frame = new JFrame("Simple chat client");
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        frame.setSize(400, 500);
        frame.setVisible(true);
    }
}
class SendButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event){
        try{

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
