package entrevista_tecnica.service;

import java.util.List;

import entrevista_tecnica.dto.Candidate;

public interface ICandidateService {
	//Metodos del CRUD
	public List<Candidate> listarCandidate(); //Listar All 
	
	public Candidate guardarCandidate(Candidate candidate);	//Guarda un Candidate CREATE
	
	public Candidate candidateXID(int id); //Leer datos de un Candidate READ
	
	public Candidate actualizarCandidate(Candidate candidate); //Actualiza datos del Candidate UPDATE
	
	public void eliminarCandidate(int id);// Elimina el Candidate DELETE
}
