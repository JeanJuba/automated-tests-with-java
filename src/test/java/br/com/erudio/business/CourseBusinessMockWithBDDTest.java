package br.com.erudio.business;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import br.com.erudio.service.CourseService;

class CourseBusinessMockWithBDDTest {

	CourseService mockService;
	CourseBusiness business;
	List<String> courses;

	@BeforeEach
	void setup() {
		// Given / Arrange
		mockService = mock(CourseService.class);
		business = new CourseBusiness(mockService);
		courses = Arrays.asList("REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
				"Agile Desmistificado com Scrum, XP, Kanban e Trello", "Spotify Engineering Culture Desmistificado",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
				"Docker do Zero à Maestria - Contêinerização Desmistificada",
				"Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
				"Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
				"Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
				"Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
				"Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
	}

	@Test
	void testCoursesRelatedToSpring_When_UsingAMock() {

		// Given / Arrange
		given(mockService.retrieveCourses("Leandro")).willReturn(courses);

		// When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

		// Then / Assert
		assertThat(filteredCourses.size(), is(4));
	}

	@Test
	void testCoursesRelatedToSpring_When_UsingAFoobarStudent() {

		// When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Foo Bar");

		// Then / Assert
		assertThat(filteredCourses.size(), is(0));
	}
	
	@DisplayName("Delete courses not related to Spring Using Mockito should call Method")
	@Test
	void testDeletedCorusesNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethod_deleteCourse() {
		// Given / Arrange
		given(mockService.retrieveCourses("Leandro")).willReturn(courses);
		
		// When / Act
		business.deleteCoursesNotRelatedToSpring("Leandro");
		
		// Then / Assert
//		verify(mockService).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
//		verify(mockService, times(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
//		verify(mockService, atLeast(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		verify(mockService, atLeastOnce()).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		
		verify(mockService).deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");
		verify(mockService, never()).deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
	}
	
	@DisplayName("Delete courses not related to Spring Using Mockito should call Method V2")
	@Test
	void testDeletedCorusesNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethod_deleteCourseV2() {
		// Given / Arrange
		given(mockService.retrieveCourses("Leandro")).willReturn(courses);
		
		String architectureCourse = "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#";
		String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";
		String restSpringCourse = "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker";

		// When / Act
		business.deleteCoursesNotRelatedToSpring("Leandro");
		
		// Then / Assert
		then(mockService).should().deleteCourse(agileCourse);
		then(mockService).should().deleteCourse(architectureCourse);
		then(mockService).should(never()).deleteCourse(restSpringCourse);
	}
	
	// Argument Captor captures the arguments inside the method that is being tested and can't be accessed outside of the method.
	@DisplayName("Delete courses not related to Spring Capturing Arguments should call Method V2")
	@Test
	void testDeletedCorusesNotRelatedToSpring_CapturingArguments_ShouldCallMethod_deleteCourseV2() {
		// Given / Arrange
		
//		courses = Arrays.asList(
//				"Agile Desmistificado com Scrum, XP, Kanban e Trello", "Spotify Engineering Culture Desmistificado",
//				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker"
//				);
		
		given(mockService.retrieveCourses("Leandro")).willReturn(courses);
		
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		
//		String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

		// When / Act
		business.deleteCoursesNotRelatedToSpring("Leandro");
		
		// Then / Assert
		then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues().size(), is(7));
	}


}
