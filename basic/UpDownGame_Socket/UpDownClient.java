import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpDownClient extends JFrame implements ActionListener {
    private BufferedReader in;
    private PrintWriter out;
    private JTextField field;
    private JTextArea area;

    public UpDownClient() throws Exception, IOException {
        setTitle("UpDownGame - Client");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        field = new JTextField(50);
        field.addActionListener(this);

        area = new JTextArea(10, 50);

        area.setEditable(false);
        add(field, BorderLayout.NORTH);
        add(area, BorderLayout.CENTER);

        Socket socket = new Socket("localhost", 9100);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        area.append(in.readLine() + "\n");
        area.append(in.readLine() + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        out.println(field.getText());
        String response = null;

        try {
            response = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        area.append(response + "\n");
    }

    public static void main(String[] args) throws Exception {
        new UpDownClient();
    }
}
