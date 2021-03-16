package entrevista_tecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrevista_tecnica.dao.IPositionsDAO;
import entrevista_tecnica.dto.Positions;


@Service
public class PositionsServiceImpl implements IPositionsService {
	@Autowired
	IPositionsDAO iPositionsDAO;

	@Override
	public List<Positions> listarPositions() {
		return iPositionsDAO.findAll();
	}

	@Override
	public Positions guardarPosition(Positions positions) {
		return iPositionsDAO.save(positions);
	}

	@Override
	public Positions positionsXID(int id) {
		return iPositionsDAO.findById(id).get();
	}

	@Override
	public Positions actualizarPositions(Positions positions) {
		return iPositionsDAO.save(positions);
	}

	@Override
	public void eliminarPositions(int id) {
		iPositionsDAO.deleteById(id);
	}
}
