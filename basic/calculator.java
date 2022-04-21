import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField display;
    private JButton[] buttons;
    private String[] labels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+",
    };

    private double result = 0;
    private String operation = "=";
    private boolean start = true;

    public calculator() {
        display = new JTextField(30);
        panel = new JPanel();

        setSize(200, 250);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setText("0");
        panel.setLayout(new GridLayout(4, 4, 1, 1));
        buttons = new JButton[16];
        int index = 0;

        for (int rows = 0; rows < 4; rows++) {
            for (int cols = 0; cols < 4; cols++) {
                buttons[index] = new JButton(labels[index]);
                panel.add(buttons[index]);
                buttons[index].addActionListener(this);
                index++;
            }
        }
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("C")) {
            start = true;
            result = 0;
            operation = "=";
            display.setText("0");
        } else if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            if (start)
                display.setText(cmd);
            else
                display.setText(display.getText() + cmd);

            start = false;
        } else {
            if (start) {
                if (cmd.equals("-")) {
                    display.setText(cmd);
                    start = false;
                } else {
                    operation = cmd;
                }
            } else {
                double x = Double.parseDouble(display.getText());
                calculate(x);
                operation = cmd;
                start = true;
            }
        }
    }

    private void calculate(double x) {
        if (operation.equals("+"))
            result += x;
        else if (operation.equals("-"))
            result -= x;
        else if (operation.equals("*"))
            result *= x;
        else if (operation.equals("/"))
            result /= x;
        else if (operation.equals("="))
            result = x;
        display.setText("" + result);
    }

    public static void main(String[] args) {
        new calculator();
    }

}