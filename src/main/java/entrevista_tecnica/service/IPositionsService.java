package entrevista_tecnica.service;

import java.util.List;

import entrevista_tecnica.dto.Positions;


public interface IPositionsService {
	//Metodos del CRUD
	public List<Positions> listarPositions(); //Listar All 
	
	public Positions guardarPosition(Positions positions);	//Guarda un Positions CREATE
	
	public Positions positionsXID(int id); //Leer datos de un Positions READ
	
	public Positions actualizarPositions(Positions positions); //Actualiza datos del Positions UPDATE
	
	public void eliminarPositions(int id);// Elimina el Positions DELETE
}
