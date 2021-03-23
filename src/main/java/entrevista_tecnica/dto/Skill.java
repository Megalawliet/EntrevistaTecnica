package entrevista_tecnica.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="skill")//en caso que la tabala sea diferente
public class Skill {
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "skillname")//no hace falta si se llama igual
	private String skillName;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<CandidateSkill> candidateSkill;
	
	//CONSTRUCTORES
	public Skill() {
		super();
	}

	public Skill(int id, String skillName, List<CandidateSkill> candidateSkill) {
		super();
		this.id = id;
		this.skillName = skillName;
		this.candidateSkill = candidateSkill;
	}
	
	
	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
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
		return "Skill [id=" + id + ", skillName=" + skillName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidateSkill == null) ? 0 : candidateSkill.hashCode());
		result = prime * result + id;
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		if (candidateSkill == null) {
			if (other.candidateSkill != null)
				return false;
		} else if (!candidateSkill.equals(other.candidateSkill))
			return false;
		if (id != other.id)
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		return true;
	}
	
	
}
