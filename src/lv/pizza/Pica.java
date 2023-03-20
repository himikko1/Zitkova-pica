
package lv.pizza;

import javax.swing.JOptionPane;

public class Pica {
	 double price;
	 private String produkts;
	private String adrese;
	   private String talrunis = null;
	   private String vards;
	   private int picasDaudzums;
	   
	   private static double getPrice(double price){
		   return price*picasDaudzums;
	   }
	   
	   
	   
	   public Pica(double price, int picasDaudzums){
		   this.price = price;
	        this.picasDaudzums=picasDaudzums;
	   }
	  
	

	public static void main(String[] args) {
		String izvele;
		String pica[]= {"Margarita-9,00 eiro", "Peperoni-13,00 eiro", "Studentu piza-12,00 eiro", "Chilli pizza-11,00 eiro"};
		String izmers [] = {"Maza-20 cm(+1,00 eiro)", "Vidēja-30 cm(+3,00 eiro)", "Liela-50 cm(+3,50 eiro)"};
		String merce [] = {"Kečups", "Hot chilli", "Majonēze"};
		String izveletaisPasutijums;
		String pasutijums;
		String piedavajums;
		double picasCenas[]={9,00 , 13,00 ,12,00 , 11,00};
		do{
			izvele = JOptionPane.showInputDialog("Izvēle-Apskatīt picas| "+
					"Pasūtījums-Izveidot pasūtījumu | "+ "Informācija-Paskatīties informāciju par pasūtījumu |"
					+" Piedāvājums - Īpašie piedāvājumi"+" stop-Apturēt programmu ");
			switch(izvele){
			case "Izvēle":
				JOptionPane.showInputDialog(null, "Izvēlies picu", "Izvēle", 
						JOptionPane.QUESTION_MESSAGE, null, pica, pica[0]);
				break;
			case "Pasūtījums":
				boolean parbaudeVardu = false;
				boolean parbaudeNumuru = false;
				boolean parbaudeAdrese = false;
				boolean parbaudeDaudzumu = false;
				
				do{
				String vards  =  JOptionPane.showInputDialog("Ievadiet savu vārdu: ");
				if( vards.length()>=3 && vards.length()<=11){
					 JOptionPane.showMessageDialog(null, "Jūsu vards : " + vards + "korrekti ievadīts ."
							, null, JOptionPane.INFORMATION_MESSAGE );
					 parbaudeVardu=true;
				}else {
					JOptionPane.showMessageDialog(null, "Nepareizi ievadīji vārdu!", "Kļūda",
							JOptionPane.ERROR_MESSAGE);
				}
				}while(!parbaudeVardu);
				do{
				String adrese  = JOptionPane.showInputDialog("Ievadiet adrese: ");
				if( adrese.length()>=4 && adrese.length()<=15){
					 JOptionPane.showMessageDialog(null, "Jūsu adrese : " + adrese + "korrekti ievadīts ."
							, null, JOptionPane.INFORMATION_MESSAGE );
					 parbaudeAdrese=true;
				}else {
					JOptionPane.showMessageDialog(null, "Nepareizi ievadīji vārdu!", "Kļūda",
							JOptionPane.ERROR_MESSAGE);
				}
				}while(!parbaudeAdrese);
				do{
				String talrunis  =  JOptionPane.showInputDialog("Ievadiet savu numuru: ");
				if( talrunis.length()==8){
					 JOptionPane.showMessageDialog(null, "Jūsu numurs : " + talrunis + "korrekti ievadīts ."
							, null, JOptionPane.INFORMATION_MESSAGE );
					 parbaudeNumuru=true;
				}else {
					JOptionPane.showMessageDialog(null, "Nepareizi ievadīji numuru!", "Kļūda",
							JOptionPane.ERROR_MESSAGE);
				}
				}while(!parbaudeNumuru);
				JOptionPane.showInputDialog(null, "Izvēlies picu", "Izvēle", 
						JOptionPane.QUESTION_MESSAGE, null, pica, pica[0]);
				JOptionPane.showInputDialog(null, "Izvēlies izmēru", "Izmērs",
						JOptionPane.QUESTION_MESSAGE, null, izmers, izmers[0]);
				do{
					String picasDaudzums = JOptionPane.showInputDialog
							("Cik picas jūs gribat iegādāties?");
					if(picasDaudzums.length()<6 || picasDaudzums.length()>0){
						JOptionPane.showMessageDialog(null,"Jūsu daudzums: "+picasDaudzums
								,null,JOptionPane.INFORMATION_MESSAGE );
						parbaudeDaudzumu = true;
					}else{
						JOptionPane.showMessageDialog(null, "Tik izvediot picas nedrīkst!",null,
		        				JOptionPane.ERROR_MESSAGE);
					}
				}while(!parbaudeDaudzumu);
				break;
			case "Informācija":
				//double beigasCena = getPrice(price);
				JOptionPane.showMessageDialog(null, "Informācija par pasūtījumu un piegāde: ", 
						"Informācija", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "Piedāvājums":
				JOptionPane.showInputDialog(null, "Izvēlies mērce", "Izvēle",
						JOptionPane.QUESTION_MESSAGE, null, merce, merce[0]);
				break;
				
			case "stop":
				JOptionPane.showMessageDialog(null, "Programma ir apturēta!", "Message",
						JOptionPane.INFORMATION_MESSAGE);
				break;
				default:JOptionPane.showMessageDialog(null, "Programma tādās darbības nepsatāv!", "Message",
						JOptionPane.WARNING_MESSAGE);
			}
			
		}while(!izvele.equals("Pabeigt"));

	}

}
