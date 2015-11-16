package ba.beslic.models.persistence.user;

import ba.beslic.models.persistence.IdentifiableEntity;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.Date;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Entity(name = "UserSession")
@Table(name = "user_session")
public class UserSessionEntity extends IdentifiableEntity {
	@OneToOne(cascade = CascadeType.ALL)
	private UserEntity user;
	@Column(name = "active")
	private boolean active;
	@Column(name = "created", nullable = false)
	private Date created;

	// TODO: Implement proper create timestamp
	public UserSessionEntity() {
		this.created = new Date();
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreated() {
		return created;
	}
}
