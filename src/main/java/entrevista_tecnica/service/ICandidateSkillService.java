package entrevista_tecnica.service;

import java.util.List;

import entrevista_tecnica.dto.CandidateSkill;

public interface ICandidateSkillService {
	//Metodos del CRUD
	public List<CandidateSkill> listarCandidateSkill(); //Listar All 
	
	public CandidateSkill guardarCandidateSkill(CandidateSkill candidateSkill);	//Guarda un CandidateSkill CREATE
	
	public CandidateSkill candidateSkillXID(int id); //Leer datos de un CandidateSkill READ
	
	public CandidateSkill actualizarCandidateSkill(CandidateSkill candidateSkill); //Actualiza datos del CandidateSkill UPDATE
	
	public void eliminarCandidateSkill(int id);// Elimina el CandidateSkill DELETE
}
