package ba.beslic.controllers.login;

import ba.beslic.presentation.data.user.AccountData;
import ba.beslic.presentation.data.user.CredentialsData;
import ba.beslic.presentation.data.user.UserData;
import ba.beslic.presentation.data.user.UserSessionData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<UserSessionData> login(@RequestBody CredentialsData credentials) {
		UserSessionData session = new UserSessionData();
		UserData unknownUser = new UserData();
		unknownUser.setAccount(new AccountData());
		session.setUser(unknownUser);
		return new ResponseEntity<>(session, HttpStatus.OK);
	}
}
