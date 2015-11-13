package ba.beslic.persistence.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
@MappedSuperclass
public class IdentifiableEntity
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public IdentifiableEntity() {
	}

	public int getId() {
		return id;
	}
}
