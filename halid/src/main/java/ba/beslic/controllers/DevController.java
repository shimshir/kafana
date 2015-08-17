package ba.beslic.controllers;

import ba.beslic.models.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Admir Memić
 * Date:   16.08.2015
 */

@RestController
@RequestMapping("/developers")
public class DevController {

	@RequestMapping
	public List<Person> getDevelopers() {
		Person admir = new Person("Admir", "Memic");
		Person azer = new Person("Azer", "Aljovic");
		return Arrays.asList(admir, azer);
	}
}
