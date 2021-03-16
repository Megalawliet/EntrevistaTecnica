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

import entrevista_tecnica.dto.Positions;
import entrevista_tecnica.service.PositionsServiceImpl;


@RestController
@RequestMapping("/api")
public class PositionsController {
	@Autowired
	PositionsServiceImpl positionsServiceImpl;
	
	@GetMapping("/positions")
	public List<Positions> listarPositions(){
		return positionsServiceImpl.listarPositions();
	}
	
	
	@PostMapping("/positions")
	public Positions guardarPositions(@RequestBody Positions positions) {
		
		return positionsServiceImpl.guardarPosition(positions);
	}
	
	
	@GetMapping("/positions/{id}")
	public Positions positionsXID(@PathVariable(name="id") int id) {
		
		Positions Positions_xid= new Positions();
		
		Positions_xid=positionsServiceImpl.positionsXID(id);
		
		System.out.println("Positions XID: "+Positions_xid);
		
		return Positions_xid;
	}
	
	@PutMapping("/positions/{id}")
	public Positions actualizarPositions(@PathVariable(name="id")int id,@RequestBody Positions positions) {
		
		Positions Positions_seleccionado= new Positions();
		Positions Positions_actualizado= new Positions();
		
		Positions_seleccionado= positionsServiceImpl.positionsXID(id);
		
		Positions_seleccionado.setTitle(positions.getTitle());
		Positions_seleccionado.setDateCreation(positions.getDateCreation());
		Positions_seleccionado.setDescription(positions.getDescription());
		
		Positions_actualizado = positionsServiceImpl.actualizarPositions(Positions_seleccionado);
		
		System.out.println("Positions actualizado es: "+ Positions_actualizado);
		
		return Positions_actualizado;
	}
	
	@DeleteMapping("/positions/{id}")
	public void eliminarPositions(@PathVariable(name="id")int id) {
		positionsServiceImpl.eliminarPositions(id);
	}
}
