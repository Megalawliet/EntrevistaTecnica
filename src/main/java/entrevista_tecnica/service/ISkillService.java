package entrevista_tecnica.service;

import java.util.List;

import entrevista_tecnica.dto.Skill;

public interface ISkillService {
	//Metodos del CRUD
	public List<Skill> listarSkill(); //Listar All 
	
	public Skill guardarSkill(Skill skill);	//Guarda un Skill CREATE
	
	public Skill skillXID(int id); //Leer datos de un Skill READ
	
	public Skill actualizarSkill(Skill skill); //Actualiza datos del Skill UPDATE
	
	public void eliminarSkill(int id);// Elimina el Skill DELETE
}
