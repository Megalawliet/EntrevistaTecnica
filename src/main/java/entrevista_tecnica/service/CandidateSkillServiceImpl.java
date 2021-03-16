package entrevista_tecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrevista_tecnica.dao.ICandidateSkillDAO;
import entrevista_tecnica.dto.CandidateSkill;

@Service
public class CandidateSkillServiceImpl implements ICandidateSkillService{
	@Autowired
	ICandidateSkillDAO iCandidateSkillDAO;

	@Override
	public List<CandidateSkill> listarCandidateSkill() {
		return iCandidateSkillDAO.findAll();
	}

	@Override
	public CandidateSkill guardarCandidateSkill(CandidateSkill candidateSkill) {
		return iCandidateSkillDAO.save(candidateSkill);
	}

	@Override
	public CandidateSkill candidateSkillXID(int id) {
		return iCandidateSkillDAO.findById(id).get();
	}

	@Override
	public CandidateSkill actualizarCandidateSkill(CandidateSkill candidateSkill) {
		return iCandidateSkillDAO.save(candidateSkill);
	}

	@Override
	public void eliminarCandidateSkill(int id) {
		iCandidateSkillDAO.deleteById(id);
	}
}
