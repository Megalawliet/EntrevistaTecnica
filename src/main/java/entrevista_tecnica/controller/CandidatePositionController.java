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

import entrevista_tecnica.dto.CandidatePosition;
import entrevista_tecnica.service.CandidatePositionServiceImpl;


@RestController
@RequestMapping("/api")
public class CandidatePositionController {
	@Autowired
	CandidatePositionServiceImpl candidatePositionServiceImpl;
	
	@GetMapping("/candidatePosition")
	public List<CandidatePosition> listarCandidatePosition(){
		return candidatePositionServiceImpl.listarCandidatePosition();
	}
	
	
	@PostMapping("/candidatePosition")
	public CandidatePosition guardarCandidatePosition(@RequestBody CandidatePosition candidatePosition) {
		
		return candidatePositionServiceImpl.guardarCandidatePosition(candidatePosition);
	}
	
	
	@GetMapping("/candidatePosition/{id}")
	public CandidatePosition CandidatePositionXID(@PathVariable(name="id") int id) {
		
		CandidatePosition CandidatePosition_xid= new CandidatePosition();
		
		CandidatePosition_xid=candidatePositionServiceImpl.candidatePositionXID(id);
		
		System.out.println("CandidatePosition XID: "+CandidatePosition_xid);
		
		return CandidatePosition_xid;
	}
	
	@PutMapping("/candidatePosition/{id}")
	public CandidatePosition actualizarCandidatePosition(@PathVariable(name="id")int id,@RequestBody CandidatePosition candidatePosition) {
		
		CandidatePosition CandidatePosition_seleccionado= new CandidatePosition();
		CandidatePosition CandidatePosition_actualizado= new CandidatePosition();
		
		CandidatePosition_seleccionado= candidatePositionServiceImpl.candidatePositionXID(id);
		
		CandidatePosition_seleccionado.setCandidate(candidatePosition.getCandidate());
		CandidatePosition_seleccionado.setPosition(candidatePosition.getPosition());
		CandidatePosition_seleccionado.setRegistryDate(candidatePosition.getRegistryDate());
		CandidatePosition_seleccionado.setTestDate(candidatePosition.getTestDate());
		CandidatePosition_seleccionado.setCompletionDate(candidatePosition.getCompletionDate());
		CandidatePosition_seleccionado.setResult(candidatePosition.getResult());
		
		CandidatePosition_actualizado = candidatePositionServiceImpl.actualizarCandidatePosition(CandidatePosition_seleccionado);
		
		System.out.println("El Candidate Position actualizado es: "+ CandidatePosition_actualizado);
		
		return CandidatePosition_actualizado;
	}
	
	@DeleteMapping("/candidatePosition/{id}")
	public void eliminarCandidatePosition(@PathVariable(name="id")int id) {
		candidatePositionServiceImpl.eliminarCandidatePosition(id);
	}
}
