import javax.swing.*;
import java.awt.*;

public class Instructions {
    private JFrame frame;
    private JTextArea area;
    private JScrollPane pane;
    public Instructions(String title, String words) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setVisible(true);
        area = new JTextArea(words);
        area.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
        area.setBounds(5, 5, 290, 290);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        pane = new JScrollPane(area);
        frame.add(pane, BorderLayout.CENTER);
    }
}
