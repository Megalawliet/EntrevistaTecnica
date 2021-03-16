package entrevista_tecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entrevista_tecnica.dto.CandidateSkill;
import entrevista_tecnica.service.CandidateSkillServiceImpl;

@RestController
@RequestMapping("/api")
public class CandidateSkillController {
	
	@Autowired
	CandidateSkillServiceImpl candidateSkillServiceImpl;
	
	@GetMapping("/candidateSkill")
	public List<CandidateSkill> listarCandidateSkill(){
		return candidateSkillServiceImpl.listarCandidateSkill();
	}
	
	
	@PostMapping("/candidateSkill")
	public CandidateSkill guardarCandidateSkill(@RequestBody CandidateSkill candidateSkill) {
		
		return candidateSkillServiceImpl.guardarCandidateSkill(candidateSkill);
	}
	
	
	@GetMapping("/candidateSkill/{id}")
	public CandidateSkill candidateSkillXID(@PathVariable(name="id") int id) {
		
		CandidateSkill CandidateSkill_xid= new CandidateSkill();
		
		CandidateSkill_xid=candidateSkillServiceImpl.candidateSkillXID(id);
		
		System.out.println("CandidateSkill XID: "+CandidateSkill_xid);
		
		return CandidateSkill_xid;
	}
	
	@PutMapping("/candidateSkill/{id}")
	public CandidateSkill actualizarCandidateSkill(@PathVariable(name="id")int id,@RequestBody CandidateSkill candidateSkill) {
		
		CandidateSkill CandidateSkill_seleccionado= new CandidateSkill();
		CandidateSkill CandidateSkill_actualizado= new CandidateSkill();
		
		CandidateSkill_seleccionado= candidateSkillServiceImpl.candidateSkillXID(id);
		
		CandidateSkill_seleccionado.setCandidate(candidateSkill.getCandidate());
		CandidateSkill_seleccionado.setSkill(candidateSkill.getSkill());
		CandidateSkill_seleccionado.setNotes(candidateSkill.getNotes());
		CandidateSkill_seleccionado.setSkillValue(candidateSkill.getSkillValue());
		
		CandidateSkill_actualizado = candidateSkillServiceImpl.actualizarCandidateSkill(CandidateSkill_seleccionado);
		
		System.out.println("El Candidato Skill actualizado es: "+ CandidateSkill_actualizado);
		
		return CandidateSkill_actualizado;
	}
	
	@DeleteMapping("/candidateSkill/{id}")
	public void eliminarCandidateSkill(@PathVariable(name="id")int id) {
		candidateSkillServiceImpl.eliminarCandidateSkill(id);
	}
}
