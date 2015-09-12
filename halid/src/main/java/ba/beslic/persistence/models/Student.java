package ba.beslic.persistence.models;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    10.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class Student extends Person
{
	private List<Course> listeningCourses;
	private List<Course> passedCourses;

	public Student(String firstName, String lastName)
	{
		super(firstName, lastName);
	}

	public List<Course> getListeningCourses()
	{
		return listeningCourses;
	}

	public void setListeningCourses(List<Course> listeningCourses)
	{
		this.listeningCourses = listeningCourses;
	}

	public List<Course> getPassedCourses()
	{
		return passedCourses;
	}

	public void setPassedCourses(List<Course> passedCourses)
	{
		this.passedCourses = passedCourses;
	}
}
