package HelpMeAmStuck.Petri;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotepadApp3 extends JFrame {

    private JTextArea textArea;
    private JList<String> fileList;
    private DefaultListModel<String> listModel;
    private JFileChooser fileChooser;

    public NotepadApp3() {
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
                    String selectedPath = fileList.getSelectedValue();
                    if (selectedPath != null) {
                        File selectedFile = new File(selectedPath);
                        if (selectedFile.isDirectory()) {
                            listFilesAndFolders(selectedFile);
                        } else {
                            openFile(selectedFile);
                        }
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

        JPanel colorModePanel = new JPanel(new FlowLayout());
        JLabel colorModeLabel = new JLabel("Color Mode: ");

        String[] colorModes = {"Default", "Dark", "Red", "Green", "Blue", "Yellow", "Cyan", "Magenta", "Pink"};
        JComboBox<String> colorModeComboBox = new JComboBox<>(colorModes);
        colorModeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColorMode = (String) colorModeComboBox.getSelectedItem();
                setColorMode(selectedColorMode);
            }
        });

        colorModePanel.add(colorModeLabel);
        colorModePanel.add(colorModeComboBox);
        userOptionsPanel.add(colorModePanel, BorderLayout.CENTER);
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
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile.isDirectory()) {
                listFilesAndFolders(selectedFile);
            } else {
                openFile(selectedFile);
            }
        }
    }

    private void openFile(File file) {
        if (file.isFile()) {
            String filePath = file.getAbsolutePath();
            if (!listModel.contains(filePath)) {
                listModel.addElement(filePath);
            }
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
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

    private void setColorMode(String colorMode) {
        switch (colorMode) {
            case "Default":
                setDefaultMode();
                break;
            case "Dark":
                setDarkMode();
                break;
            case "Red":
                setRedMode();
                break;
            case "Green":
                setGreenMode();
                break;
            case "Blue":
                setBlueMode();
                break;
            case "Yellow":
                setYellowMode();
                break;
            case "Cyan":
                setCyanMode();
                break;
            case "Magenta":
                setMagentaMode();
                break;
            case "Pink":
                setPinkMode();
                break;
        }
    }

    private void setDefaultMode() {
        textArea.setBackground(UIManager.getColor("TextArea.background"));
        textArea.setForeground(UIManager.getColor("TextArea.foreground"));
    }

    private void setDarkMode() {
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.WHITE);
    }

    private void setRedMode() {
        textArea.setBackground(Color.RED);
        textArea.setForeground(Color.WHITE);
    }

    private void setGreenMode() {
        textArea.setBackground(Color.GREEN);
        textArea.setForeground(Color.WHITE);
    }

    private void setBlueMode() {
        textArea.setBackground(Color.BLUE);
        textArea.setForeground(Color.WHITE);
    }

    private void setYellowMode() {
        textArea.setBackground(Color.YELLOW);
        textArea.setForeground(Color.BLACK);
    }

    private void setCyanMode() {
        textArea.setBackground(Color.CYAN);
        textArea.setForeground(Color.BLACK);
    }

    private void setMagentaMode() {
        textArea.setBackground(Color.MAGENTA);
        textArea.setForeground(Color.WHITE);
    }

    private void setPinkMode() {
        textArea.setBackground(Color.PINK);
        textArea.setForeground(Color.BLACK);
    }

    private void listFilesAndFolders(File directory) {
        listModel.clear();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                listModel.addElement(file.getAbsolutePath());
            }
        }
    }

    public static void Swinger3() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NotepadApp3().setVisible(true);
            }
        });
    }
}
