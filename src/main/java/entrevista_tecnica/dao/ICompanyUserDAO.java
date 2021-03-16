package entrevista_tecnica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entrevista_tecnica.dto.CompanyUser;

public interface ICompanyUserDAO extends JpaRepository<CompanyUser, Integer>{

}
