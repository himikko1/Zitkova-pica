
package lv.pizza;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;


public class Pica {
	 	static void writeFile(String line) {
	 		try {
	 			FileWriter fw = new FileWriter("fails.txt", true);
	 			PrintWriter wr =  new PrintWriter(fw);
	 			wr.println(line);
	 			wr.close();
	 		}catch(Exception e) {
	 			JOptionPane.showMessageDialog(null, "Kļūda ierakstot datus failā", "Kļūda", JOptionPane.ERROR_MESSAGE);
	 		}
	 		static String izmers [] = {"Maza-20 cm(+1,00 eiro)", "Vidēja-30 cm(+3,00 eiro)", "Liela-50 cm(+3,50 eiro)"};
		   	static String pica[]= {"Margarita-9,00 eiro", "Peperoni-13,00 eiro", "Studentu piza-12,00 eiro", "Chilli pizza-11,00 eiro"};
		   	static String merce [] = {"Kečups", "Hot chilli", "Majonēze"};
		   	static double picasCenas[]={9.00, 13.00, 12.00, 11.00};
			static double izmeraCenas[]={1.00, 3.00, 3.50};
			static double merceCenas[]={0.85, 1.00, 0.60};

			public static void main(String[] args) {
				String izvele;
				/*
				 * cenas
				 */
				
				double summa = 0;
				
				do{
					izvele = JOptionPane.showInputDialog("Izvēle-Apskatīt picas| "+
							"Pasūtījums-Izveidot pasūtījumu | "+ "Informācija-Paskatīties informāciju par pasūtījumu |"+" stop-Apturēt programmu ");
					/*
					 * Darbibas
					 */
					switch(izvele){
					case "Izvēle":
//						JOptionPane.showInputDialog(null, "Izvēlies picu", "Izvēle", 
//								JOptionPane.QUESTION_MESSAGE, null, pica, pica[0]);
						String str = "";
						for(int i=0; i<pica.length; i++) {
							str += pica[i]+"\n";
						}
						str+="Izmēri:\n";
						for(int i=0; i<izmers.length; i++) {
							str += izmers[i]+"\n";
						}
						str+="Mērces:\n";
						for(int i=0; i<merce.length; i++) {
							str += merce[i]+"\n";
						}
						JOptionPane.showMessageDialog(null, "Ēdienkarte:\n"+str, "Ēdienkarte", JOptionPane.INFORMATION_MESSAGE);
						break;
					case "Pasūtījums": //pasutit
						summa = izveidotPasutijumu(false);				
						JOptionPane.showMessageDialog(null, "Summa = "+summa);
						do {
							izvele = JOptionPane.showInputDialog("Turpināt? (y/n)");					
							if(izvele.equalsIgnoreCase("y")) {
								summa += izveidotPasutijumu(true);
							}
						}while(!izvele.equalsIgnoreCase("n"));
						writeFile("Summa: "+summa+"\n");
						JOptionPane.showMessageDialog(null, "Summa = "+summa);
						
						break;
					case "Informācija":
						readFile();
						break;
					case "stop":
						JOptionPane.showMessageDialog(null, "Programma ir apturēta!", "Message",
								JOptionPane.INFORMATION_MESSAGE);
						break;
						default:JOptionPane.showMessageDialog(null, "Programma tādās darbības nepsatāv!", "Message",
								JOptionPane.WARNING_MESSAGE);
					}
					
				}while(!izvele.equals("stop"));

			}
			
			public static void readFile() {
				try {
					FileReader fr = new FileReader("fails.txt");
					BufferedReader read = new BufferedReader(fr);
					String str = "", line;
					while( (line = read.readLine()) !=null ) {
						str += line + "\n";
					}
					JOptionPane.showMessageDialog(null, "Informācija par pasūtījumu un piegāde:\n "+str,"Informācija", JOptionPane.INFORMATION_MESSAGE);
					read.close();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Kļūda lasot failu", "Kļūda", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}

	 	}
	 	
