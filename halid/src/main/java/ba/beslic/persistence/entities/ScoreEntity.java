package ba.beslic.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author:  Admir Memic
 * Date:    27.09.15
 * E-Mail:  admir.memic@dmc.de
 */
@Entity(name = "Score")
@Table(name = "score")
public class ScoreEntity extends IdentifiableEntity {
	@Column(name = "name")
	private String name;
	@Column(name = "value")
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
