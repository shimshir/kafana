package ba.beslic.models.persistence.user;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Author:  Admir Memic
 * Date:    20.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Entity(name = "UUIDTokenEntity")
@Table(name = "uuid_token")
public class UUIDTokenEntity {
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id")
	@Id
	public String id;

	public String getId() {
		return id;
	}
}
