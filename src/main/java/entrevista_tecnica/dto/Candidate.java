package entrevista_tecnica.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="candidate")//en caso que la tabala sea diferente
public class Candidate {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	private String username;
	private String pwd;
	private String namecandidate;
	private String surname;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<CandidatePosition> candidatePositions;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<CandidateSkill> candidateSkill;
	
	
	//CONSTRUCTORES
	public Candidate() {
		super();
	}

	
	public Candidate(int id, String username, String pwd, String namecandidate, String surname,
			List<CandidatePosition> candidatePositions, List<CandidateSkill> candidateSkill) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.namecandidate = namecandidate;
		this.surname = surname;
		this.candidatePositions = candidatePositions;
		this.candidateSkill = candidateSkill;
	}



	//GETTERS Y SETTERS
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

	public String getNamecandidate() {
		return namecandidate;
	}

	public void setNamecandidate(String name) {
		this.namecandidate = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "CandidatePosition", orphanRemoval=true)
	public List<CandidatePosition> getCandidatePositions() {
		return candidatePositions;
	}

	public void setCandidatePositions(List<CandidatePosition> candidatePositions) {
		this.candidatePositions = candidatePositions;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "CandidateSkill", orphanRemoval=true)
	public List<CandidateSkill> getCandidateSkill() {
		return candidateSkill;
	}


	public void setCandidateSkill(List<CandidateSkill> candidateSkill) {
		this.candidateSkill = candidateSkill;
	}


	@Override
	public String toString() {
		return "Candidate [id=" + id + ", username=" + username + ", pwd=" + pwd + ", namecandidate=" + namecandidate + ", surname="
				+ surname + "]";
	}
	
}
