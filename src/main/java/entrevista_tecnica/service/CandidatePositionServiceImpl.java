package entrevista_tecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrevista_tecnica.dao.ICandidatePositionDAO;
import entrevista_tecnica.dto.CandidatePosition;

@Service
public class CandidatePositionServiceImpl implements ICandidatePositionService{
	@Autowired
	ICandidatePositionDAO iCandidatePositionDAO;

	@Override
	public List<CandidatePosition> listarCandidatePosition() {
		return iCandidatePositionDAO.findAll();
	}

	@Override
	public CandidatePosition guardarCandidatePosition(CandidatePosition candidatePosition) {
		return iCandidatePositionDAO.save(candidatePosition);
	}

	@Override
	public CandidatePosition candidatePositionXID(int id) {
		return iCandidatePositionDAO.findById(id).get();
	}

	@Override
	public CandidatePosition actualizarCandidatePosition(CandidatePosition candidatePosition) {
		return iCandidatePositionDAO.save(candidatePosition);
	}

	@Override
	public void eliminarCandidatePosition(int id) {
		iCandidatePositionDAO.deleteById(id);
	}
}
