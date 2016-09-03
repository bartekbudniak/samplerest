package domain.services;

import java.util.ArrayList;
import java.util.List;

import domain.Film;

public class FilmService {
	
	private static List<Film> db = new ArrayList<Film>();
	private static int currentId = 1;
	
	public List<Film> getAll(){
		return db;
	}
	
	public Film get(int id){
		for(Film film : db){
			if(film.getId() == id)
				return film;
		}
		return null;
	}
	
	public void add(Film film){
		film.setId(++currentId);
		db.add(film);
	}
	
	public void update(Film film){
		for(Film filmy : db){
			if(filmy.getId() == film.getId()){
				filmy.setTytul(film.getTytul());
				//komentarze + oceny gdzie indziej
			}
		}
	}
	
	public void delete(Film film){
		db.remove(film);
	}
}
