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

import entrevista_tecnica.dto.Candidate;
import entrevista_tecnica.service.CandidateServiceImpl;


@RestController
@RequestMapping("/api")
public class CandidateController {
	@Autowired
	CandidateServiceImpl candidateServiceImpl;
	
	@GetMapping("/candidate")
	public List<Candidate> listarCandidate(){
		return candidateServiceImpl.listarCandidate();
	}
	
	
	@PostMapping("/candidate")
	public Candidate guardarCandidate(@RequestBody Candidate candidate) {
		
		return candidateServiceImpl.guardarCandidate(candidate);
	}
	
	
	@GetMapping("/candidate/{id}")
	public Candidate CandidateXID(@PathVariable(name="id") int id) {
		
		Candidate Candidate_xid= new Candidate();
		
		Candidate_xid=candidateServiceImpl.candidateXID(id);
		
		System.out.println("Candidate XID: "+Candidate_xid);
		
		return Candidate_xid;
	}
	
	@PutMapping("/candidate/{id}")
	public Candidate actualizarCandidate(@PathVariable(name="id")int id,@RequestBody Candidate candidate) {
		
		Candidate Candidate_seleccionado= new Candidate();
		Candidate Candidate_actualizado= new Candidate();
		
		Candidate_seleccionado= candidateServiceImpl.candidateXID(id);
		
		Candidate_seleccionado.setUsername(candidate.getUsername());
		Candidate_seleccionado.setPwd(candidate.getPwd());
		Candidate_seleccionado.setNamecandidate(candidate.getNamecandidate());
		Candidate_seleccionado.setSurname(candidate.getSurname());
		
		Candidate_actualizado = candidateServiceImpl.actualizarCandidate(Candidate_seleccionado);
		
		System.out.println("El Candidato actualizado es: "+ Candidate_actualizado);
		
		return Candidate_actualizado;
	}
	
	@DeleteMapping("/candidate/{id}")
	public void eliminarCandidate(@PathVariable(name="id")int id) {
		candidateServiceImpl.eliminarCandidate(id);
	}
}
