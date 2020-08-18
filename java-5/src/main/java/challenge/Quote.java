package challenge;

import javax.persistence.*;

@Entity(name = "scripts")
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String actor;

	@Column(name = "detail")
	public String quote;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

}
