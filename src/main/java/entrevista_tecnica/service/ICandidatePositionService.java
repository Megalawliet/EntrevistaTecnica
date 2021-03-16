package entrevista_tecnica.service;

import java.util.List;

import entrevista_tecnica.dto.CandidatePosition;

public interface ICandidatePositionService {
	//Metodos del CRUD
	public List<CandidatePosition> listarCandidatePosition(); //Listar All 
	
	public CandidatePosition guardarCandidatePosition(CandidatePosition candidatePosition);	//Guarda un CandidatePosition CREATE
	
	public CandidatePosition candidatePositionXID(int id); //Leer datos de un CandidatePosition READ
	
	public CandidatePosition actualizarCandidatePosition(CandidatePosition candidatePosition); //Actualiza datos del CandidatePosition UPDATE
	
	public void eliminarCandidatePosition(int id);// Elimina el CandidatePosition DELETE
}
