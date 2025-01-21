package streams.miniproject.mini1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MiniProject2 {

	public static void main(String[] args)   {

        JFrame frame = new JFrame("Postleitzahl Suche");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new FlowLayout());
        JLabel label = new JLabel("Bitte geben Sie eine fünfstellige Postleitzahl ein:");
        JTextField postalCodeField = new JTextField(10);
        
        JButton searchButton = new JButton("Suchen");
        
        JTextArea resultArea = new JTextArea(10, 30);
        
        resultArea.setEditable(false);
        
        searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String inputPLZ = postalCodeField.getText().trim();
				if(!isValidInput(inputPLZ)){
					resultArea.setText("Ungültige Postleitzahl.");
				}
				try {
					datenNachPostleitzahlfinden(inputPLZ , resultArea);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        });
             
        frame.add(label);
        frame.add(postalCodeField);
        frame.add(searchButton);
        frame.add(new JScrollPane(resultArea));

        frame.setVisible(true);
	}
	
	static List<Ort> getListPLZOrt() throws IOException{
		Stream<String> filesStream = Files.lines(Paths.get("plz_ort.csv"));
		
		List<Ort> orte = filesStream.skip(1)  	
								 .map(zeile -> zeile.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")) // split bei Kommas außerhalb von Anführungszeichen
								 .map(entry -> new Ort(  Integer.parseInt(entry[0]), 	// OSM_ID
										 				 entry[1], 						// Ort (Ohne quotes)
										 				 entry[2] ,   					// PLZ
										 				 entry[3]))						// Bundesland
								 .collect(Collectors.toList());
		return orte;
	}
	
	static void datenNachPostleitzahlfinden(String postleitzahl, JTextArea result) throws IOException {
		
		result.setText(""); // clear 
		result.append("Postleitzahl " + postleitzahl + ":\n");
		
		List<Ort> listFile = getListPLZOrt();  

		Predicate<Ort> pred = ort -> ort.getPostleitzahl().contains(postleitzahl);
		List<Ort> matchList = listFile.stream().filter(pred).collect(Collectors.toList());

		
        if (matchList.isEmpty()) {
        	result.append("Kein Ort gefunden!: ");
        } else {
        	for (Ort place : matchList) {
            	result.append("- " + place.getBundesland() + " (" + place.getOrt() + ")\n");
            }
        }
    }
	
	static boolean isValidInput(String plz) {
		return plz.length() == 5 ? true : false;
	}

}
