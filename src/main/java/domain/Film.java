package domain;

import java.util.List;

public class Film {

	private int id;
	private String tytul;
	private List<Komentarz> komentarze;
	private List<Ocena> oceny;
	
	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public List<Komentarz> getKomentarze() {
		return komentarze;
	}

	public void setKomentarze(List<Komentarz> komentarze) {
		this.komentarze = komentarze;
	}

	public double getSredniaOcen() {
		double suma = 0;
		int i = 1;
		for(Ocena o : oceny){
			suma += o.getOcena();
			i++;
		}
		return suma/i;
	}

	public void setOceny(List<Ocena> oceny) {
		this.oceny = oceny;
	}
	
	public List<Ocena> getOceny() {
		return oceny;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
