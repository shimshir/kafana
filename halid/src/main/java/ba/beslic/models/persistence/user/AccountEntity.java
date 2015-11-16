package ba.beslic.models.persistence.user;

import ba.beslic.models.persistence.IdentifiableEntity;

import javax.persistence.*;
import java.util.Collection;


/**
 * Author:  Admir Memic
 * Date:    19.10.15
 * E-Mail:  admir.memic@dmc.de
 */
@Entity(name = "Account")
@Table(name = "account")
public class AccountEntity extends IdentifiableEntity {
	@Column(name = "username")
	private String username;
	@Column(name = "hashed_password")
	private String hashedPassword;
	@ElementCollection(targetClass = RoleEnum.class)
	@JoinTable(name = "account_2_role", joinColumns = @JoinColumn(name = "account_id"),
			uniqueConstraints = @UniqueConstraint(columnNames = {"account_id", "role"}))
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Collection<RoleEnum> roles;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "account", optional = false)
	private UserEntity user;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public Collection<RoleEnum> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RoleEnum> roles) {
		this.roles = roles;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}
