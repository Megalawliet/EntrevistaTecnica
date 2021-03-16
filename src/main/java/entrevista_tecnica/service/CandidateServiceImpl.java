package entrevista_tecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrevista_tecnica.dao.ICandidateDAO;
import entrevista_tecnica.dto.Candidate;

@Service
public class CandidateServiceImpl implements ICandidateService{
	@Autowired
	ICandidateDAO iCandidateDAO;

	@Override
	public List<Candidate> listarCandidate() {
		return iCandidateDAO.findAll();
	}

	@Override
	public Candidate guardarCandidate(Candidate candidate) {
		return iCandidateDAO.save(candidate);
	}

	@Override
	public Candidate candidateXID(int id) {
		return iCandidateDAO.findById(id).get();
	}

	@Override
	public Candidate actualizarCandidate(Candidate candidate) {
		return iCandidateDAO.save(candidate);
	}

	@Override
	public void eliminarCandidate(int id) {
		iCandidateDAO.deleteById(id);
	}
}
