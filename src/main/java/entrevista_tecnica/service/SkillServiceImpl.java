package entrevista_tecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrevista_tecnica.dao.ISkillDAO;
import entrevista_tecnica.dto.Skill;

@Service
public class SkillServiceImpl implements ISkillService{
	@Autowired
	ISkillDAO iSkillDAO;

	@Override
	public List<Skill> listarSkill() {
		return iSkillDAO.findAll();
	}

	@Override
	public Skill guardarSkill(Skill skill) {
		return iSkillDAO.save(skill);
	}

	@Override
	public Skill skillXID(int id) {
		return iSkillDAO.findById(id).get();
	}

	@Override
	public Skill actualizarSkill(Skill skill) {
		return iSkillDAO.save(skill);
	}

	@Override
	public void eliminarSkill(int id) {
		iSkillDAO.deleteById(id);
	}
}
