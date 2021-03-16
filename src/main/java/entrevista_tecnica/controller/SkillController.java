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

import entrevista_tecnica.dto.Skill;
import entrevista_tecnica.service.SkillServiceImpl;

@RestController
@RequestMapping("/api")
public class SkillController {
	@Autowired
	SkillServiceImpl skillServiceImpl;
	
	@GetMapping("/skill")
	public List<Skill> listarSkill(){
		return skillServiceImpl.listarSkill();
	}
	
	
	@PostMapping("/skill")
	public Skill guardarSkill(@RequestBody Skill skill) {
		
		return skillServiceImpl.guardarSkill(skill);
	}
	
	
	@GetMapping("/skill/{id}")
	public Skill skillXID(@PathVariable(name="id") int id) {
		
		Skill Skill_xid= new Skill();
		
		Skill_xid=skillServiceImpl.skillXID(id);
		
		System.out.println("Skill XID: "+Skill_xid);
		
		return Skill_xid;
	}
	
	@PutMapping("/skill/{id}")
	public Skill actualizarSkill(@PathVariable(name="id")int id,@RequestBody Skill skill) {
		
		Skill Skill_seleccionado= new Skill();
		Skill Skill_actualizado= new Skill();
		
		Skill_seleccionado= skillServiceImpl.skillXID(id);
		
		Skill_seleccionado.setSkillName(skill.getSkillName());
		
		Skill_actualizado = skillServiceImpl.actualizarSkill(Skill_seleccionado);
		
		System.out.println("Skill actualizado es: "+ Skill_actualizado);
		
		return Skill_actualizado;
	}
	
	@DeleteMapping("/skill/{id}")
	public void eliminarSkill(@PathVariable(name="id")int id) {
		skillServiceImpl.eliminarSkill(id);
	}
}
