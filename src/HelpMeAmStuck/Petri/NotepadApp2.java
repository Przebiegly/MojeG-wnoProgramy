package HelpMeAmStuck.Petri;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotepadApp2 extends JFrame {

    private JTextArea textArea;
    private JList<String> fileList;
    private DefaultListModel<String> listModel;
    private JFileChooser fileChooser;

    public NotepadApp2() {
        setTitle("Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // File List Panel
        JPanel fileListPanel = new JPanel(new BorderLayout());
        JLabel fileListLabel = new JLabel("File List");
        fileListPanel.add(fileListLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        fileList = new JList<>(listModel);
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedFile = fileList.getSelectedValue();
                    if (selectedFile != null) {
                        openFile(selectedFile);
                    }
                }
            }
        });

        JScrollPane fileListScrollPane = new JScrollPane(fileList);
        fileListPanel.add(fileListScrollPane, BorderLayout.CENTER);

        // Text Area Panel
        JPanel textAreaPanel = new JPanel(new BorderLayout());
        JLabel textAreaLabel = new JLabel("Text Area");
        textAreaPanel.add(textAreaLabel, BorderLayout.NORTH);

        textArea = new JTextArea();
        JScrollPane textAreaScrollPane = new JScrollPane(textArea);
        textAreaPanel.add(textAreaScrollPane, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, fileListPanel, textAreaPanel);
        splitPane.setDividerLocation(200);
        mainPanel.add(splitPane, BorderLayout.CENTER);

        // User Options Panel
        JPanel userOptionsPanel = new JPanel(new BorderLayout());
        JLabel userOptionsLabel = new JLabel("User Options");
        userOptionsPanel.add(userOptionsLabel, BorderLayout.NORTH);

        JCheckBox darkModeCheckBox = new JCheckBox("Dark Mode");
        darkModeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (darkModeCheckBox.isSelected()) {
                    setDarkMode();
                } else {
                    setLightMode();
                }
            }
        });

        userOptionsPanel.add(darkModeCheckBox, BorderLayout.CENTER);
        mainPanel.add(userOptionsPanel, BorderLayout.EAST);

        add(mainPanel);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    private void openFile() {
        fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            if (!listModel.contains(filePath)) {
                listModel.addElement(filePath);
            }
            openFile(filePath);
        }
    }

    private void openFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            reader.close();
            textArea.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile() {
        fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(textArea.getText());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setDarkMode() {
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.WHITE);
    }

    private void setLightMode() {
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);
    }

    public static void Swinger2() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NotepadApp2().setVisible(true);
            }
        });
    }
}
