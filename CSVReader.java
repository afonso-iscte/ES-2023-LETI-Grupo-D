package projeto_es;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Teste {
	
    private JFrame frame;
    private JButton openButton;
    private JEditorPane editorPane;

    public Teste() {
        frame = new JFrame("Leitor CSV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        openButton = new JButton("Abrir Ficheiro CSV");
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    List<Horario> data = readCSV(filePath);
                    String htmlContent = generateHTMLTable(data);
                    displayHTMLContent(htmlContent);

                    // Ask user to choose the file destination for saving the HTML file
                    int saveValue = fileChooser.showSaveDialog(null);
                    if (saveValue == JFileChooser.APPROVE_OPTION) {
                        saveHTMLToFile(htmlContent, fileChooser.getSelectedFile());
                    }
                }
            }
        });

        editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        JScrollPane scrollPane = new JScrollPane(editorPane);

        frame.add(openButton, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(1000,400); 
        frame.setVisible(true);
    }
