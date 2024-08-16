package br.com.erudio.business;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.service.CourseService;

// System (Method) under test
public class CourseBusiness {

	// CourseService is a dependency
	private CourseService service;

	public CourseBusiness(CourseService service) {
		super();
		this.service = service;
	}

	public List<String> retrieveCoursesRelatedToSpring(String student) {
		var filteredCourses = new ArrayList<String>();
		if ("Foo Bar".equals(student)) {
			return filteredCourses;
		}

		var allCourses = service.retrieveCourses(student);

		for (String course : allCourses) {
			if (course.contains("Spring")) {
				filteredCourses.add(course);
			}
		}

		return filteredCourses;
	}

	public void deleteCoursesNotRelatedToSpring(String student) {

		var allCourses = service.retrieveCourses(student);

		for (String course : allCourses) {
			if (!course.contains("Spring")) {
				service.deleteCourse(course);
			}
		}
	}

}
