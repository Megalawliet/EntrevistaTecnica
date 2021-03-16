package entrevista_tecnica.service;

import java.util.List;

import entrevista_tecnica.dto.CompanyUser;

public interface ICompanyUserService {
	//Metodos del CRUD
	public List<CompanyUser> listarCompanyUser(); //Listar All 
	
	public CompanyUser guardarCompanyUser(CompanyUser companyUser);	//Guarda un CompanyUser CREATE
	
	public CompanyUser companyUserXID(int id); //Leer datos de un CompanyUser READ
	
	public CompanyUser actualizarCompanyUser(CompanyUser companyUser); //Actualiza datos del CompanyUser UPDATE
	
	public void eliminarCompanyUser(int id);// Elimina el CompanyUser DELETE
}
