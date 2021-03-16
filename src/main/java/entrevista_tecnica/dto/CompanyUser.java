package entrevista_tecnica.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="companyUser")//en caso que la tabala sea diferente
public class CompanyUser {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	private String username;
	private String pwd;
	private String userRole;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Positions> position;

	public CompanyUser() {
		super();
	}

	public CompanyUser(int id, String username, String pwd, String userRole, List<Positions> position) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.userRole = userRole;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Positions")
	public List<Positions> getPosition() {
		return position;
	}

	public void setPosition(List<Positions> position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "CompanyUser [id=" + id + ", username=" + username + ", pwd=" + pwd + ", userRole=" + userRole
				+ "]";
	}
		
}
