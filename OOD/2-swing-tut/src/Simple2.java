import javax.swing.*;

public class Simple2 extends JFrame{
    JFrame f;
    Simple2 () {
        JButton b = new JButton("click");
        b.setBounds(100,100,100,100);
        add(b);
        setSize(400, 500);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Simple2();
    }
}
