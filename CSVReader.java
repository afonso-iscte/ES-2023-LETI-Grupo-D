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
    public List<Horario> readCSV(String filePath) {
        List<Horario> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Horario h = new Horario(new Curso(values[0]), new Unidade_Curricular(values[1]), 
                						new Turno(values[2]),new Turma(values[3]), 
                						Integer.parseInt(values[4]), new Day(values[5]),
                						new Time(values[6],values[7]), new Date(values[8]), 
                						values[9],new Sala(values[10]));
                data.add(h);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
