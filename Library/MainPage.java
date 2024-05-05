package Library;

import java.util.Scanner;

public class MainPage {

	public static String vstupniZnak(Scanner sc) 
	{
		String znak;
		znak = sc.next();
		return znak;
	}
	
	public static int celeCislo(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("Zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = celeCislo(sc);
		}
		return cislo;
	}
	
	public static void main(String[] args) {	

		Scanner sc = new Scanner(System.in);

		String prikaz;
		boolean run = true;
		
		Knihovna mojeKnihovna = new Knihovna(500);
		
		while(run)
		{
			System.out.println("\nVitame vas v systemu on-line knihovny!:\n");
			System.out.println("1 -- Vypis vsech knih v knihovne");
			System.out.println("2 -- Vyhledavani knihy");
			System.out.println("3 -- Vypis vsech knih jednoho autora");
			System.out.println("4 -- Vypis vsech knih jednoho zanru");
			System.out.println("5 -- Oznaceni knihy jako vypujcene/vracene");
			System.out.println("6 -- Vypis pujcenych knih");
			System.out.println("7 -- Pridani nove knihy");
			System.out.println("8 -- Uprava informaci o knize");
			System.out.println("9 -- Smazani knihy");
			System.out.println("A -- Pridani nove knihy ze souboru");
			System.out.println("B -- Nacteni informaci o knize do souboru");
			System.out.println("E -- Ukoncit aplikaci\n");
			
			prikaz = vstupniZnak(sc);
			
			boolean druhKnihy;
			boolean stavPujceni;
			String nazev;
			String autor;
			String zanr;
			int vhodnyRocnik;
			int rokVydani;
			
			switch(prikaz)
			{
				case "1":
					System.out.println("Vypis vsech knih v knihovne");
					System.out.println("###########################");
					mojeKnihovna.vypisKnihovny();
					System.out.println("###########################");
					break;
				case "2":
					System.out.println("Vyhledavani knihy");
					System.out.println("Napiste nazev knihy, kterou hledate:");
					sc.nextLine();
					nazev = sc.nextLine();
					try{
						mojeKnihovna.vypisKnihyNazev(nazev);
					}
					catch(Exception e) {
						System.out.println("\nKnihovna je uplne prazdna, zadne knihy tady nejsou");
					}
					break;
				case "3":
					System.out.println("Napiste jmeno autora");
					sc.nextLine();
					autor = sc.nextLine();
					try{
						mojeKnihovna.trideniROKEM();
						mojeKnihovna.vypisKnihyAutor(autor);
					}
					catch(Exception e) {
						System.out.println("\nKnihovna je uplne prazdna, zadne knihy tady nejsou");
					}					
					break;
				case "4":
					System.out.println("Vypis vsech knih jednoho zanru - test");
					System.out.println("Napiste zanr, ktery je pro vas zajimavy");
					sc.nextLine();
					zanr = sc.nextLine();
					try{
						mojeKnihovna.vypisKnihyZanr(zanr);
					}
					catch(Exception e) {
						System.out.println("\nKnihovna je uplne prazdna, zadne knihy tady nejsou");
					}										
					break;
				case "5":
					System.out.println("Napiste nazev knihy, kterou chcete pujcit nebo vratit");
					sc.nextLine();
					nazev = sc.nextLine();
					try{
						mojeKnihovna.zmenaStavuPujceni(nazev);
					}
					catch(Exception e) {
						System.out.println("!!!Knihovna je uplne prazdna, zadne knihy tady nejsou!!!");
					}
					break;
				case "6":
					System.out.println("Vypis pujcenych knih - test");
					break;
				case "7":
					System.out.println("Pridani nove knihy - test");
					try
					{
						mojeKnihovna.novaKniha();
					}
					catch (ArrayIndexOutOfBoundsException e)
					{
						System.out.println("!!!Nebylo mozno vytvorit novou polozku, databaze je plna!!!");
					}
					break;
				case "8":
					System.out.println("Napiste nazev knihy, kterou chcete zmenit");
					sc.nextLine();
					nazev = sc.nextLine();
					try{
						mojeKnihovna.zmenaInformaceKnihy(nazev);
					}
					catch(Exception e) {
						System.out.println("!!!Knihovna je uplne prazdna, zadne knihy tady nejsou!!!");
					}
					break;
				case "9":
					System.out.println("Napiste nazev knihy, kterou chcete smazat");
					sc.nextLine();
					nazev = sc.nextLine();
					try{
						mojeKnihovna.smazaniKnihy(nazev);
					}
					catch(Exception e) {
						System.out.println("!!!Knihovna je uplne prazdna, zadne knihy tady nejsou!!!");
					}
					break;				
				case "A":
					sc.nextLine();
					System.out.println("Zadejte nazev knihy");
					nazev = sc.nextLine();
					try {
					if (mojeKnihovna.ulozeniKnihy(nazev))
						System.out.println("Kniha ulozena");
					else
						System.out.println("Knihu nepodarilo ulozit");
					}
					catch(Exception e) {
						System.out.println("!!!Takova kniha neexistuje!!!");
					}
					break;
				case "B":
					System.out.println("Zadejte nazev knihy");
					sc.nextLine();
					if (mojeKnihovna.stazeniKnihy(sc.nextLine()))
						System.out.println("Kniha stazena");
					else
						System.out.println("Nepodarilo pridat novou knihu");
					break;				
				case "E":
					run=false;
					break;
				default:
					System.out.println("Tato volba neni spravna, zkuste znovu");
			}	
			mojeKnihovna.trideniABECEDOU();
		}
	}
	
	
}
