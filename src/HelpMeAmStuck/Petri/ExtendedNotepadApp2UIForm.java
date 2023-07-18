package HelpMeAmStuck.Petri;

import javax.swing.*;

public class ExtendedNotepadApp2UIForm extends JFrame {
    private JPanel panel1;
    private JButton Archive;
    private JButton Save;
    private JButton button3;
    private JButton button4;
    private JList FileList;
    private JButton Files;
    private JScrollPane ScrollArea;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button5;

    ExtendedNotepadApp2UIForm(){
        this.setContentPane(this.panel1);
    }

    public static void Lunch(){
        ExtendedNotepadApp2UIForm win = new ExtendedNotepadApp2UIForm();
        win.setSize(640,480);
        win.setVisible(true);
    }
}
