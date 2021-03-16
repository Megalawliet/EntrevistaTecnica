package entrevista_tecnica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entrevista_tecnica.dto.CandidateSkill;

public interface ICandidateSkillDAO extends JpaRepository<CandidateSkill, Integer> {

}
