package ba.beslic.controllers.login;

import ba.beslic.persistence.entities.user.AccountEntity;
import ba.beslic.presentation.data.user.CredentialsData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Admir Memić
 * Date:   19.10.2015
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@RequestMapping
	public AccountEntity login(@RequestBody CredentialsData credentialsData) {
		return new AccountEntity();
	}
}
