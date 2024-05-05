package Library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Knihovna {

	public Knihovna(int pocetKnih)
	{
		knihyKnihovny = new Kniha[pocetKnih];
		sc = new Scanner(System.in);
	}
	
	public void novaKniha()
	{
		boolean run = true;
		
		while(run) {
			System.out.println("Bude to ucebnice nebo roman?:\n");
			System.out.println("	U -- Ucebnice\n");
			System.out.println("	R -- Roman\n");
			String vyber=sc.next();
			
			boolean druhKnihy;
			String nazev;
			String autor;
			int rokVydani;
			int vhodnyRocnik;
			String zanr;
			boolean stavPujceni;
			
			switch(vyber)
			{
				case "U":
					druhKnihy = true;
					System.out.println("Napiste nazev knihy:");
					sc.nextLine();
					nazev = sc.nextLine();
					System.out.println("Napiste autora knihy:");
					autor = sc.nextLine();
					System.out.println("Napiste rok vydani:");
					rokVydani = MainPage.celeCislo(sc);
					System.out.println("Napiste vhodny rocnik:");
					vhodnyRocnik = MainPage.celeCislo(sc);
					if(vhodnyRocnik > 14 && vhodnyRocnik < 1) {
						System.out.println("Spatny format rocniku");
						break;
					}
					zanr = "Zadny";
					stavPujceni = false;
					knihyKnihovny[posledniKniha++] = new Kniha(druhKnihy, nazev, autor, rokVydani, vhodnyRocnik, zanr, stavPujceni);
					run = false;
					break;
				case "R":
					druhKnihy = false;
					System.out.println("Napiste nazev knihy:");
					sc.nextLine();
					nazev = sc.nextLine();
					System.out.println("Napiste autora knihy:");
					autor = sc.nextLine();
					System.out.println("Napiste rok vydani:");
					rokVydani = MainPage.celeCislo(sc);
					vhodnyRocnik = -1;
					sc.nextLine();
					System.out.println("Napiste zanr teto knihy:");
					zanr = sc.nextLine();
					stavPujceni = false;
					knihyKnihovny[posledniKniha++] = new Kniha(druhKnihy, nazev, autor, rokVydani, vhodnyRocnik, zanr, stavPujceni);
					run = false;
					break;
				default:
					System.out.println("Spatna volba, zkuste znovu");
			}
		}
	}
	
	public void trideniABECEDOU(){
		String nazev1, nazev2;
		for (int i = 0; i < knihyKnihovny.length; i++) {
			for(int j = i+1; j < knihyKnihovny.length; j++) {
				if(knihyKnihovny[i]!=null && knihyKnihovny[j]!=null) {
					nazev1 = knihyKnihovny[i].getNazev();
					nazev2 = knihyKnihovny[j].getNazev();
					if(nazev1.compareTo(nazev2)>0) {
						temp = new Kniha[1];
						temp[0] = knihyKnihovny[i];
						knihyKnihovny[i] = knihyKnihovny[j];
						knihyKnihovny[j] = temp[0];
					}
				}
			}
		}
	}
	
	public void trideniROKEM(){
		int rok1, rok2;
		for (int i = 0; i < knihyKnihovny.length; i++) {
			for(int j = i+1; j < knihyKnihovny.length; j++) {
				if(knihyKnihovny[i]!=null && knihyKnihovny[j]!=null) {
					rok1 = knihyKnihovny[i].getRokVydani();
					rok2 = knihyKnihovny[j].getRokVydani();
					if(rok1 > rok2) {
						temp = new Kniha[1];
						temp[0] = knihyKnihovny[i];
						knihyKnihovny[i] = knihyKnihovny[j];
						knihyKnihovny[j] = temp[0];
					}
				}
			}
		}
	}
	
	public void vypisKnihovny()
	{
		String stav;
		for (int i = 0; i < knihyKnihovny.length; i++){
			if (knihyKnihovny[i]!=null) {
				if(knihyKnihovny[i].getDruhKnihy()) {
					if(knihyKnihovny[i].getStavPujceni())
						{stav = "pujcena";}
					else
						{stav = "v knihovne";}
					System.out.println("Ucebnice '" + knihyKnihovny[i].getNazev() + "' pro " + knihyKnihovny[i].getVhodnyRocnik() + " rocnik" +  ", autor " + knihyKnihovny[i].getAutor() + ", vydani " + knihyKnihovny[i].getRokVydani() + " roku. Stav knihy: " + stav);
				}
				else {
					if(knihyKnihovny[i].getStavPujceni())
						{stav = "pujcena";}
					else
						{stav = "v knihovne";}
					System.out.println("Roman '" + knihyKnihovny[i].getNazev() + "' zanru " + knihyKnihovny[i].getZanr() +  ", autor " + knihyKnihovny[i].getAutor() + ", vydani " + knihyKnihovny[i].getRokVydani() + " roku. Stav knihy: " + stav);
				}
			}
		}
	}
	
	public void vypisKnihyNazev(String nazev)
	{
		int i = 0;
		int x = 0;
		String stav, druh;
		while(knihyKnihovny[i]!=null) {
			if (knihyKnihovny[i].getNazev().equalsIgnoreCase(nazev)) {
				
				if(knihyKnihovny[i].getStavPujceni()) 
					{stav = "pujcena";}
				else 
					{stav = "v knihovne";}
				
				if(knihyKnihovny[i].getDruhKnihy()) 
				{
					druh = "Ucebnice";
					System.out.println(" " + druh + " " + knihyKnihovny[i].getNazev() + " pro " + knihyKnihovny[i].getVhodnyRocnik() + " rocnik, autor " + knihyKnihovny[i].getAutor() + ", vydani " + knihyKnihovny[i].getRokVydani() + " roku. Stav knihy: " + stav);
				}
				else 
				{
					druh = "Roman";
					System.out.println(" " + druh + " " + knihyKnihovny[i].getNazev() + " zanru " + knihyKnihovny[i].getZanr() + ", autor " + knihyKnihovny[i].getAutor() + ", vydani " + knihyKnihovny[i].getRokVydani() + " roku. Stav knihy: " + stav);
				}
				
				x++;
			}
			i++;
		}
		if(x == 0) {
			System.out.println("Kniha nebyla nalezena");
		}
	}
	
	public void vypisKnihyAutor(String autor)
	{
		int i = 0;
		int x = 0;
		while(knihyKnihovny[i]!=null) {
			if (knihyKnihovny[i].getAutor().equalsIgnoreCase(autor)) {
				System.out.println(" " + knihyKnihovny[i].getNazev() +", " + knihyKnihovny[i].getRokVydani());
				x++;
			}
			i++;
		}
		if(x == 0) {
			System.out.println("Knihy tohoto autora v knihovne nejsou");
		}
	}
	
	public void vypisKnihyZanr(String zanr)
	{
		int i = 0;
		int x = 0;
		String stav;
		while(knihyKnihovny[i]!=null) {
			if (knihyKnihovny[i].getZanr().equalsIgnoreCase(zanr)) {
				if(knihyKnihovny[i].getStavPujceni()) 
					{stav = "pujcena";}
				else
					{stav = "v knihovne";}
				System.out.println(" " + knihyKnihovny[i].getNazev() +", autor" + knihyKnihovny[i].getAutor() + ", " + knihyKnihovny[i].getRokVydani() + ". Stav knihy: " + stav);
				x++;
			}
			i++;
		}
		if(x == 0) {
			System.out.println("Takovy zanr knih v knihovne neni");
		}
	}
	
	public void zmenaStavuPujceni(String nazev)
	{
		int i = 0;
		int x = 0;
		while(knihyKnihovny[i]!=null) {
			if (knihyKnihovny[i].getNazev().equalsIgnoreCase(nazev)) {
				x++;
				String volba;
				if(knihyKnihovny[i].getStavPujceni()) {
					System.out.println("Kniha ted je pujcena. Chcete ji vratit?  ANO/NE");
					volba = sc.nextLine();
					switch(volba)
					{
					case "ANO":
						knihyKnihovny[i].setStavPujceni(false);
						break;
					case "NE":
						knihyKnihovny[i].setStavPujceni(true);
						break;
					default:
						System.out.println("Spatna volba. Zkuste znovu, dajte pozor na velke pismeno");
					}
				}
				else {
					System.out.println("Kniha ted je v knihovne a neni pujcena. Chcete ji pujcit?  ANO/NE");
					volba = sc.nextLine();
					switch(volba)
					{
					case "ANO":
						knihyKnihovny[i].setStavPujceni(true);
						break;
					case "NE":
						knihyKnihovny[i].setStavPujceni(false);
						break;
					default:
						System.out.println("Spatna volba. Zkuste znovu, dajte pozor na velke pismeno");
					}
				}
			}
			i++;
		}
		if(x == 0) {
			System.out.println("Kniha nebyla nalezena");
		}
	}
	
	public void zmenaInformaceKnihy(String nazev) {
		int i = 0;
		while(knihyKnihovny[i]!=null) {
			if(knihyKnihovny[i].getNazev().equalsIgnoreCase(nazev)) {
				boolean run = true;
				String stav;
				while(run) {
					if(knihyKnihovny[i].getStavPujceni()) {
						stav = "pujcena";
					}
					else {
						stav = "v knihovne";
					}
					System.out.println(" Mate zvolenou knihu " + nazev + ". Vyberte jednou z voleb");
					System.out.println(" Zmena autora : " + knihyKnihovny[i].getAutor() + " [A]");
					System.out.println(" Zmena roku vydani : " + knihyKnihovny[i].getRokVydani() + " [B]");
					System.out.println(" Zmena stavu knihy : " + stav + " [C]");
					System.out.println(" Ukoncit zmenu knihy [E]");
					
					String volba = sc.nextLine();
					String jmeno;
					int rokVydani;
					String pujcka;
					
					switch(volba) 
					{
						case "A":
							System.out.println(" Zmena autora. Napiste nove jmeno: ");
							jmeno = sc.nextLine();
							knihyKnihovny[i].setAutor(jmeno);
							break;
						case "B":
							System.out.println(" Zmena roku vydani. Napiste novou hodnotu: ");
							rokVydani = MainPage.celeCislo(sc);
							sc.nextLine();
							knihyKnihovny[i].setRokVydani(rokVydani);
							break;
						case "C":
							System.out.println(" Zmena stavu knihy. Zvolte znak: ");
							System.out.println(" Zmenit na stav 'v knihovne' [K]");
							System.out.println(" Zmenit na stav 'pujcena' [P]");
							pujcka = sc.nextLine();
							if(pujcka.equals("K")) {
								knihyKnihovny[i].setStavPujceni(false);
							}
							else if(pujcka.equals("P")) {
								knihyKnihovny[i].setStavPujceni(true);
							}
							else {
								System.out.println(" Spatna volba, zkuste znovu");
							}
							break;
						case "E":
							run = false;
							break;
						default:
							System.out.println(" Spatna volba, zkuste znovu");
					}
				}
			}
			i++;
		}
	}

	public void smazaniKnihy(String nazev) {
		int i = 0;
		while(knihyKnihovny[i]!=null) {
			if (knihyKnihovny[i].getNazev().equalsIgnoreCase(nazev)) {
				for(int j = i; j < knihyKnihovny.length - 1; j++) {
					knihyKnihovny[j] = knihyKnihovny[j+1];
				}
				knihyKnihovny[knihyKnihovny.length - 1] = null;
				break;
			}
		}

	}
	
	public boolean ulozeniKnihy(String nazev)
	{
		for(int i = 0; i < knihyKnihovny.length; i++) {
			temp = new Kniha[1];
			if(knihyKnihovny[i].getNazev().equalsIgnoreCase(nazev)) {
				temp[0] = knihyKnihovny[i];
				break;
			}
		}
		String druh;
		String stav;
		if(temp[0].getDruhKnihy()) {
			druh = "Ucebnice";
		}
		else {
			druh = "Roman";
		}
		if(temp[0].getStavPujceni()) {
			stav = "Pujcena";
		}
		else {
			stav = "V_knihovne";
		}
		try {
			FileWriter fw = new FileWriter(nazev+".txt");
			BufferedWriter out = new BufferedWriter(fw);
			
			out.write(druh);
			out.newLine();
			out.write(temp[0].getNazev());
			out.newLine();
			out.write(temp[0].getZanr());
			out.newLine();
			out.write(String.valueOf(temp[0].getVhodnyRocnik()));
			out.newLine();
			out.write(temp[0].getAutor());
			out.newLine();
			out.write(String.valueOf(temp[0].getRokVydani()));
			out.newLine();
			out.write(stav);
			out.newLine();

			out.close();
			fw.close();
		}
		catch (IOException e) {
			System.out.println("Soubor nelze vytvorit");
			return false;
		}
		return true;
	}
	
	public boolean stazeniKnihy(String nazev) {
		temp = new Kniha[1];
		temp[0] = new Kniha(false, null, null, -1, -1, null, false);
		FileReader fr=null;
		BufferedReader in=null;
		try {
			fr = new FileReader(nazev + ".txt");
			in = new BufferedReader(fr);
			String radek = in.readLine();
			if(radek.equalsIgnoreCase("Ucebnice")){
				temp[0].setDruhKnihy(true);
			}
			else if(radek.equalsIgnoreCase("Roman")) {
				temp[0].setDruhKnihy(false);
			}
			else {
				System.out.println("Spatny druh knihy");
				return false;
			}
			radek = in.readLine();
			temp[0].setNazev(radek);
			radek = in.readLine();
			temp[0].setZanr(radek);
			radek = in.readLine();
			temp[0].setVhodnyRocnik(Integer.valueOf(radek));
			radek = in.readLine();
			temp[0].setAutor(radek);
			radek = in.readLine();
			temp[0].setRokVydani(Integer.valueOf(radek));
			radek = in.readLine();
			if(radek.equalsIgnoreCase("Pujcena")){
				temp[0].setStavPujceni(true);
			}
			else if(radek.equalsIgnoreCase("V_knihovne")) {
				temp[0].setStavPujceni(false);
			}
			else {
				System.out.println("Spatny stav knihy");
				return false;
			}

		}
		catch (IOException e) {
			System.out.println("Soubor  nelze otevrit");
			return false;
		} 
		catch (NumberFormatException e) {
			System.out.println("Chyba integrity dat v souboru");
			return false;
		}
		catch (NullPointerException e) {
			System.out.println("Chyba null pointeru");
			return false;
		}
		finally
		{
			try
			{	if (in!=null)
				{
					in.close();
					fr.close();
				}
			}
			catch (IOException e) {
				System.out.println("Soubor  nelze zavrit");
				return false;
			} 
		}
		
		knihyKnihovny[posledniKniha++] = new Kniha(temp[0].getDruhKnihy(), temp[0].getNazev(), temp[0].getAutor(), temp[0].getRokVydani(), temp[0].getVhodnyRocnik(), temp[0].getZanr(), temp[0].getStavPujceni());
		
		return true;		
	}
	
	private Scanner sc;
	private Kniha [] knihyKnihovny;
	private Kniha [] temp;
	private int posledniKniha;

	
}
