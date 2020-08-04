package br.com.israelferreira.agenda.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.israelferreira.agenda.model.Contato;

@Stateless
@Local
@Path("contato")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContatoService {
	
	@PersistenceContext
	EntityManager manager;
	
	@GET
	public List<Contato> buscarTodos() {
		return manager.createQuery("select c from contato c", Contato.class).getResultList();
	}
	
	@GET
	@Path("/{id}")
	public Contato buscar(@PathParam("id") Long id) {		
		Contato contato = manager.find(Contato.class, id);		
		return contato;
	}
	
	@POST
	public Contato criar(Contato contato) {
		manager.persist(contato);
		return contato;
	}
	
	@PUT
	@Path("/{id}")
	public Contato atualizar(@PathParam("id") Long id, Contato contato) {				
		return manager.merge(contato);		
	}
	
	@DELETE
	@Path("/{id}")
	public void apagar(@PathParam("id") Long id) {
		Contato contato = manager.find(Contato.class, id);		
		if (contato != null) {
			manager.remove(contato);
		}
	}
	
	
}
