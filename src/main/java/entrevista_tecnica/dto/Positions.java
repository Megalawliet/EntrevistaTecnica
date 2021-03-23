package entrevista_tecnica.dto;

import java.sql.Timestamp;
import java.util.Date;
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

import org.apache.commons.lang3.time.DateUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="positions")//en caso que la tabala sea diferente
public class Positions {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	private String title;
	
	@Column(name = "datecreation")//no hace falta si se llama igual
	private Timestamp dateCreation = fecha();
	
	@Column(name = "descriptionposition")//no hace falta si se llama igual
	private String description;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<CandidatePosition> candidatePositions;
	
	//CONSTRUCTORES
	public Positions() {
		super();
	}

	public Positions(int id, String title, String description,
			List<CandidatePosition> candidatePositions) {
		super();
		this.id = id;
		this.title = title;
		this.dateCreation = fecha();
		this.description = description;
		this.candidatePositions = candidatePositions;
	}
	
	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = fecha();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "CandidatePosition", orphanRemoval=true)
	public List<CandidatePosition> getCandidatePositions() {
		return candidatePositions;
	}

	public void setCandidatePositions(List<CandidatePosition> candidatePositions) {
		this.candidatePositions = candidatePositions;
	}
	
	public static Timestamp fecha() {
		java.util.Date date = new Date();
		//añadimos una hora a GMT
		Date newDate = DateUtils.addHours(date, 1);
		
		Timestamp param = new java.sql.Timestamp(newDate.getTime());
		return param;
	}

	@Override
	public String toString() {
		return "Positions [id=" + id + ", title=" + title + ", dateCreation=" + dateCreation + ", description="
				+ description + "]";
	}
	
}
