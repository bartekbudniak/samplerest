package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import domain.Film;
import domain.Komentarz;
import domain.Ocena;
import domain.services.FilmService;

@Path("/films")
public class FilmResources {

	private FilmService db = new FilmService();
	
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Film> getAll(){
		return db.getAll();
	}*/
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response test(){
		return Response.ok("praca").build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id){
		Film result = db.get(id);
		if(result == null){
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Film film){
		db.add(film);
		return Response.ok(film.getId()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Film film){
		Film result = db.get(id);
		if(result == null){
			return Response.status(404).build();
		}
		film.setId(id);
		db.update(film);
		return Response.ok(film.getId()).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		Film result = db.get(id);
		if(result == null){
			return Response.status(404).build();
		}
		db.update(result);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{filmId}/komentarze")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Komentarz> getKomentarze(@PathParam("filmId") int filmId){
		Film result = db.get(filmId);
		if(result == null){
			return null;
		}
		if(result.getKomentarze() == null){
			result.setKomentarze(new ArrayList<Komentarz>());
		}
		return result.getKomentarze();
	}
	
	@POST
	@Path("/{filId}/komentarze")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addKomentarz(@PathParam("filId") int filmId, Komentarz komentarz){
		Film result = db.get(filmId);
		if(result == null){
			return Response.status(404).build();
		}
		if(result.getKomentarze() == null){
			result.setKomentarze(new ArrayList<Komentarz>());
		}
		result.getKomentarze().add(komentarz);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{filmId}/oceny")
	@Produces(MediaType.APPLICATION_JSON)
	public double getOceny(@PathParam("filmId") int filmId){
		Film result = db.get(filmId);
		if(result == null){
			return 0;
		}
		if(result.getOceny() == null){
			result.setOceny(new ArrayList<Ocena>());
		}
		return result.getSredniaOcen();
	}
	
	@POST
	@Path("/{filId}/oceny")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addOcena(@PathParam("filId") int filmId, Ocena ocena){
		Film result = db.get(filmId);
		if(result == null){
			return Response.status(404).build();
		}
		if(result.getOceny() == null){
			result.setOceny(new ArrayList<Ocena>());
		}
		result.getOceny().add(ocena);
		return Response.ok().build();
	}
	
	
}
