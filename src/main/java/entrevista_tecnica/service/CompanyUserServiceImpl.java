package entrevista_tecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrevista_tecnica.dao.ICompanyUserDAO;
import entrevista_tecnica.dto.CompanyUser;

@Service
public class CompanyUserServiceImpl implements ICompanyUserService{
	@Autowired
	ICompanyUserDAO iCompanyUserDAO;

	@Override
	public List<CompanyUser> listarCompanyUser() {
		return iCompanyUserDAO.findAll();
	}

	@Override
	public CompanyUser guardarCompanyUser(CompanyUser companyUser) {
		return iCompanyUserDAO.save(companyUser);
	}

	@Override
	public CompanyUser companyUserXID(int id) {
		return iCompanyUserDAO.findById(id).get();
	}

	@Override
	public CompanyUser actualizarCompanyUser(CompanyUser companyUser) {
		return iCompanyUserDAO.save(companyUser);
	}

	@Override
	public void eliminarCompanyUser(int id) {
		iCompanyUserDAO.deleteById(id);
	}
}
