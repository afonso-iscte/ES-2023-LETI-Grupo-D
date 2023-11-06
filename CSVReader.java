package projeto_es;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	
    private JFrame frame;
    private JButton openButton;
    private JEditorPane editorPane;

    public CSVReader() {
        frame = new JFrame("Leitor CSV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        openButton = new JButton("Abrir ficheiro CSV");
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    List<String[]> data = readCSV(filePath);
                    String htmlContent = generateHTMLTable(data);
                    displayHTMLContent(htmlContent);
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

    public List<String[]> readCSV(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public String generateHTMLTable(List<String[]> data) {
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">");
        htmlHeader(htmlContent);
        //makeJavaScript(htmlContent);
        htmlContent.append("<body><table border='1'>");
        if (data.isEmpty()) {
            htmlContent.append("<tr><td colspan='5'>O ficheiro esta vazio ou nao existe</td></tr>");
        } else {
            for (String[] row : data) {
                htmlContent.append("<tr>");
                for (String value : row) {
                    htmlContent.append("<td>").append(value).append("</td>");
                }
                htmlContent.append("</tr>");
            }
        }

        htmlContent.append("</table></body></html>");
        return htmlContent.toString();
    }

    private void htmlHeader(StringBuilder htmlContent) {
    	htmlContent.append("\n");
		htmlContent.append("<head>");
		
		htmlContent.append("<meta charset='utf-8' />");
		htmlContent.append("<link href=\"https://unpkg.com/tabulator-tables@4.8.4/dist/css/tabulator.min.css\" rel=\"stylesheet\">");
		htmlContent.append("<script type=\"text/javascript\" src=\"https://unpkg.com/tabulator-tables@4.8.4/dist/js/tabulator.min.js\"></script>");

		htmlContent.append("</head>");	
	}


	public void displayHTMLContent(String htmlContent) {
        editorPane.setText(htmlContent);
    }

    public void saveHTMLToFile(String htmlContent, File destinationFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            writer.write(htmlContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CSVReader());
    }
    
}
