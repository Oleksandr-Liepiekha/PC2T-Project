package Library;

public class Kniha {
	public Kniha(boolean druhKnihy, String nazev, String autor, int rokVydani, int vhodnyRocnik, String zanr, boolean stavPujceni)
	{
		this.druhKnihy = druhKnihy;
		this.nazev = nazev;
		this.autor = autor;
		this.rokVydani = rokVydani;
		this.zanr = zanr;
		this.vhodnyRocnik = vhodnyRocnik;
		this.stavPujceni = stavPujceni;
	}
	
	public boolean getDruhKnihy()
	{
		return druhKnihy;
	}
	
	public void setDruhKnihy(boolean druhKnihy)
	{
		this.druhKnihy = druhKnihy;
	}
	
	public String getNazev()
	{
		return nazev;
	}
	
	public void setNazev(String nazev)
	{
		this.nazev = nazev;
	}
	
	public String getAutor()
	{
		return autor;
	}
	
	public void setAutor(String autor)
	{
		this.autor = autor;
	}
	
	public int getRokVydani() {
		return rokVydani;
	}
	
	public void setRokVydani(int rokVydani)
	{
		this.rokVydani = rokVydani;
	}

	public int getVhodnyRocnik() {
		return vhodnyRocnik;
	}
	
	public void setVhodnyRocnik(int vhodnyRocnik)
	{
		this.vhodnyRocnik = vhodnyRocnik;
	}
	
	public String getZanr() {
		return zanr;
	}
	
	public void setZanr(String zanr)
	{
		this.zanr = zanr;
	}
	
	public boolean getStavPujceni() {
		return stavPujceni;
	}
	
	public void setStavPujceni(boolean stavPujceni)
	{
		this.stavPujceni = stavPujceni;
	}
	
	private boolean druhKnihy;
	private String nazev;
	private String autor;
	private int rokVydani;
	private int vhodnyRocnik;
	private String zanr;
	private boolean stavPujceni;
}
