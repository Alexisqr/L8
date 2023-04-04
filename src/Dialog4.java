import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class Dialog4 extends JFrame {

    JTextField fld = new JTextField();
    JTextField fld2 = new JTextField();
    JButton btn = new JButton("Скопіювати");
    JButton btn2 = new JButton("Друк");
    JLabel lbl = new JLabel(" ");
    JLabel lbl1 = new JLabel(" ");
    JLabel lbl2 = new JLabel(" ");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    ArrayList List = new ArrayList();
    Dialog4() {
        super("Слухачі (listeners) полів та кнопок");
        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
            ;
        }
        catch(Exception e) {
        }
        fld.setColumns(20);
        fld2.setColumns(20);
        setSize(400, 150);
        Container c = getContentPane();
        //panel1.add(lbl, BorderLayout.NORTH);
        lbl1.setText("Поле вводу:  ");
        panel1.add(lbl1, BorderLayout.NORTH);
        panel1.add(fld, BorderLayout.CENTER);

        lbl2.setText("Поле виводу:");
        panel2.add(lbl2, BorderLayout.NORTH);
        panel2.add(fld2, BorderLayout.CENTER);
        c.add(panel1, BorderLayout.NORTH);
        c.add(panel2, BorderLayout.CENTER);
        panel3.add(btn, BorderLayout.WEST);
        panel3.add(btn2, BorderLayout.EAST);
        c.add(panel3, BorderLayout.SOUTH);
        fld.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                fld2.setText(fld.getText());

            }
        });
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                List.add(fld.getText());
                StringSelection selection = new StringSelection(fld.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, null);

            }
        });
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                StringSelection selection = new StringSelection(fld.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, null);
                System.out.println(List);
            }
        });
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Dialog4();
    }
}