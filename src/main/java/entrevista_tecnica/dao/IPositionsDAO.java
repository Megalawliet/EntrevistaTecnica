package entrevista_tecnica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entrevista_tecnica.dto.Positions;

public interface IPositionsDAO extends JpaRepository<Positions, Integer>{

}
