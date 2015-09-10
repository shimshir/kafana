package ba.beslic.controllers;

import ba.beslic.models.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
		List<Person> developers = new ArrayList<>();
		developers.add(new Person("Admir", "Memic"));
		developers.add(new Person("Merry", "Fizzlebomb"));
		developers.add(new Person("Whimsy", "Scribbler"));
		developers.add(new Person("Dippery", "Gollywock"));
		developers.add(new Person("Breaddystack", "Spleggings"));
		return developers;
	}

	@RequestMapping("/{developerId}")
	public Person getDeveloper(@PathVariable String developerId)
	{
		return new Person("Larry", "Wall");
	}
}
