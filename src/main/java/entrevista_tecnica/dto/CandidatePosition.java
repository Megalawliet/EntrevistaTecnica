package entrevista_tecnica.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="candidateposition")//en caso que la tabala sea diferente
public class CandidatePosition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "idcandidate")
	Candidate candidate;
	
	@ManyToOne
    @JoinColumn(name = "idposition")
	Positions position;
	
	@Column(name = "registrydate")//no hace falta si se llama igual
	private Timestamp registryDate;
	
	@Column(name = "testdate")//no hace falta si se llama igual
	private Timestamp testDate;
	
	@Column(name = "completiondate")//no hace falta si se llama igual
	private Timestamp completionDate;
	
	private float result;
	
	//CONSTRUCTORES
	public CandidatePosition() {
		super();
	}


	public CandidatePosition(int id, Candidate candidate, Positions position, Timestamp registryDate,
			Timestamp testDate, Timestamp completionDate, float result) {
		super();
		this.id = id;
		this.candidate = candidate;
		this.position = position;
		this.registryDate = registryDate;
		this.testDate = testDate;
		this.completionDate = completionDate;
		this.result = result;
	}

	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Candidate getCandidate() {
		return candidate;
	}


	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}


	public Positions getPosition() {
		return position;
	}


	public void setPosition(Positions position) {
		this.position = position;
	}


	public Timestamp getRegistryDate() {
		return registryDate;
	}


	public void setRegistryDate(Timestamp registryDate) {
		this.registryDate = registryDate;
	}


	public Timestamp getTestDate() {
		return testDate;
	}


	public void setTestDate(Timestamp testDate) {
		this.testDate = testDate;
	}


	public Timestamp getCompletionDate() {
		return completionDate;
	}


	public void setCompletionDate(Timestamp completionDate) {
		this.completionDate = completionDate;
	}


	public float getResult() {
		return result;
	}


	public void setResult(float result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "CandidatePosition [id=" + id + ", candidate=" + candidate + ", position=" + position + ", registryDate="
				+ registryDate + ", testDate=" + testDate + ", completionDate=" + completionDate + ", result=" + result
				+ "]";
	}
}
