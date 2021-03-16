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

import entrevista_tecnica.dto.CompanyUser;
import entrevista_tecnica.service.CompanyUserServiceImpl;

@RestController
@RequestMapping("/api")
public class CompanyUserController {
	
	@Autowired
	CompanyUserServiceImpl companyUserServiceImpl;
	
	@GetMapping("/companyUser")
	public List<CompanyUser> listarCompanyUser(){
		return companyUserServiceImpl.listarCompanyUser();
	}
	
	
	@PostMapping("/companyUser")
	public CompanyUser guardarCompanyUser(@RequestBody CompanyUser companyUser) {
		
		return companyUserServiceImpl.guardarCompanyUser(companyUser);
	}
	
	
	@GetMapping("/companyUser/{id}")
	public CompanyUser companyUserXID(@PathVariable(name="id") int id) {
		
		CompanyUser CompanyUser_xid= new CompanyUser();
		
		CompanyUser_xid=companyUserServiceImpl.companyUserXID(id);
		
		System.out.println("CompanyUser XID: "+CompanyUser_xid);
		
		return CompanyUser_xid;
	}
	
	@PutMapping("/companyUser/{id}")
	public CompanyUser actualizarCompanyUser(@PathVariable(name="id")int id,@RequestBody CompanyUser companyUser) {
		
		CompanyUser CompanyUser_seleccionado= new CompanyUser();
		CompanyUser CompanyUser_actualizado= new CompanyUser();
		
		CompanyUser_seleccionado= companyUserServiceImpl.companyUserXID(id);
		
		CompanyUser_seleccionado.setUsername(companyUser.getUsername());
		CompanyUser_seleccionado.setPwd(companyUser.getPwd());
		CompanyUser_seleccionado.setUserRole(companyUser.getUserRole());
		
		CompanyUser_actualizado = companyUserServiceImpl.actualizarCompanyUser(CompanyUser_seleccionado);
		
		System.out.println("El Usuario de la compañia actualizado es: "+ CompanyUser_actualizado);
		
		return CompanyUser_actualizado;
	}
	
	@DeleteMapping("/companyUser/{id}")
	public void eliminarCompanyUser(@PathVariable(name="id")int id) {
		companyUserServiceImpl.eliminarCompanyUser(id);
	}
}
