
package lv.pizza;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;


public class Pica {
	//Izveidoju picas sarakstu 
	static ArrayList<pica1>PicuSaraksts = new ArrayList<pica1>();
	 	static void writeFile(String line) {
	 		try {
	 			FileWriter fw = new FileWriter("fails.txt", true);
	 			PrintWriter wr =  new PrintWriter(fw);
	 			wr.println(line);
	 			wr.close();
	 		}catch(Exception e) {
	 			JOptionPane.showMessageDialog(null, "Kļūda ierakstot datus failā", "Kļūda", JOptionPane.ERROR_MESSAGE);
	 		}
	 	}
	 		 static double izveidotPasutijumu(boolean otraReize) {
	 		   	double summa = 0;
	 		   	boolean parbaudeVardu = false;
	 			boolean parbaudeNumuru = false;
	 			boolean parbaudeAdrese = false;
	 			boolean parbaudeDaudzumu = false;
	 			/*
	 			 * Vards
	 			 */
	 			if(!otraReize) {
					String vards;
					do{
						 vards =  JOptionPane.showInputDialog("Ievadiet savu vārdu: ");
						if( vards.length()>=3 && vards.length()<=11){
							 JOptionPane.showMessageDialog(null, "Jūsu vards : " + vards + " korrekti ievadīts .", null, JOptionPane.INFORMATION_MESSAGE );
							 parbaudeVardu=true;
						}else {
							JOptionPane.showMessageDialog(null, "Nepareizi ievadīji vārdu!", "Kļūda",JOptionPane.ERROR_MESSAGE);
						}
					}while(!parbaudeVardu);
					
					writeFile("Vārds: "+vards);
					
	 			/*
				 * Adrese
				 */
				String adrese;
				do{
					  adrese = JOptionPane.showInputDialog("Ievadiet adrese: ");
					if( adrese.length()>=4 && adrese.length()<=15){
						 JOptionPane.showMessageDialog(null, "Jūsu adrese : " + adrese + " korrekti ievadīts .", null, JOptionPane.INFORMATION_MESSAGE );
						 parbaudeAdrese=true;
					}else {
						JOptionPane.showMessageDialog(null, "Nepareizi ievadīji vārdu!", "Kļūda",JOptionPane.ERROR_MESSAGE);
					}
				}while(!parbaudeAdrese);
				
				writeFile("Adrese: "+adrese);
				
				/*
				 * numurs
				 */
				String talrunis;
				do{
					talrunis = JOptionPane.showInputDialog("Ievadiet savu numuru: ");
					if( talrunis.length()==8){
						 JOptionPane.showMessageDialog(null, "Jūsu numurs : " + talrunis + " korrekti ievadīts .", null, JOptionPane.INFORMATION_MESSAGE );
						 parbaudeNumuru=true;
					}else {
						JOptionPane.showMessageDialog(null, "Nepareizi ievadīji numuru!", "Kļūda",JOptionPane.ERROR_MESSAGE);
					}
				}while(!parbaudeNumuru);
				
				writeFile("Talr. numurs: "+talrunis+"\n\nPasūtījums:");
				
			}
			
			/*
			 * Izvelies picu
			 */
			String izveletaPica = (String) JOptionPane.showInputDialog(null, "Izvēlies picu", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, pica, pica[0]);
			int Index = Arrays.asList(pica).indexOf(izveletaPica);
			
			summa += picasCenas[Index];
			
			writeFile(izveletaPica);
			/*
			 * izvelies izmeru
			 */
			String izveletaisIzmers = (String) JOptionPane.showInputDialog(null, "Izvēlies izmēru", "Izmērs",JOptionPane.QUESTION_MESSAGE, null, izmers, izmers[0]);
			Index = Arrays.asList(izmers).indexOf(izveletaisIzmers);
			summa += izmeraCenas[Index];
			
			writeFile("izmērs: "+izveletaisIzmers);
			/*
			 * daudzums
			 */
			String picasDaudzums;
			do{
				 picasDaudzums = JOptionPane.showInputDialog
						("Cik picas jūs gribat iegādāties?");
				if(picasDaudzums.length()<6 && picasDaudzums.length()>0){
					JOptionPane.showMessageDialog(null,"Jūsu daudzums: "+picasDaudzums
							,null,JOptionPane.INFORMATION_MESSAGE );
					parbaudeDaudzumu = true;
				}else{
					JOptionPane.showMessageDialog(null, "Tik izvediot picas nedrīkst!",null,
	        				JOptionPane.ERROR_MESSAGE);
				}
			}while(!parbaudeDaudzumu);
			writeFile("Daudzums: "+picasDaudzums);
			
			/*
			 * merces
			 */
			String izveletaMerce, izvele;
			writeFile("Mērces:");
			do {
				izveletaMerce = (String)JOptionPane.showInputDialog(null,"Izvēlies mērci:", "Mērces", JOptionPane.QUESTION_MESSAGE, null, merce, merce[0]);
				Index = Arrays.asList(merce).indexOf(izveletaMerce);
				summa += merceCenas[Index];
				writeFile(izveletaMerce +" "+ merceCenas );
				do {
					izvele = JOptionPane.showInputDialog("Pievienot vēl kaut kadu mērci? (y/n)");					
				}while(!izvele.equalsIgnoreCase("y") && !izvele.equalsIgnoreCase("n"));
			}while(!izvele.equalsIgnoreCase("n"));
			PicuSaraksts.add(new pica1(izveletaPica, Integer.parseInt(izveletaisIzmers),summa));			
			return summa *= Integer.parseInt(picasDaudzums);
	   }
	 		static String izmers [] = {"Maza-20 cm(+1,00 eiro)", "Vidēja-30 cm(+3,00 eiro)", "Liela-50 cm(+3,50 eiro)"};
		   	static String pica[]= {"Margarita-9,00 eiro", "Peperoni-13,00 eiro", "Studentu piza-12,00 eiro", "Chilli pizza-11,00 eiro"};
		   	static String merce [] = {"Kečups-0,85", "Hot chilli-1,00", "Majonēze-0,60"};
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
					izvele = JOptionPane.showInputDialog("1-Apskatīt picas| "+
							"2-Izveidot pasūtījumu | "+ "3-Paskatīties informāciju par pasūtījumu |"+" 4-Apturēt programmu ");
					/*
					 * Darbibas
					 */
					switch(izvele){
					case "1":
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
					case "2": //pasutit
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
					case "3":
						readFile();
						break;
					case "4":
						JOptionPane.showMessageDialog(null, "Programma ir apturēta!", "Message",
								JOptionPane.INFORMATION_MESSAGE);
						break;
						default:JOptionPane.showMessageDialog(null, "Programma tādās darbības nepsatāv!", "Message",
								JOptionPane.WARNING_MESSAGE);
					}
					
				}while(!izvele.equals("4"));

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
	 	
