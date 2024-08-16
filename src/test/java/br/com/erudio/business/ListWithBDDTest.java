package br.com.erudio.business;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.Test;

// Using Hamcrest for BDD, but it's not really needed unless the company demands that.
public class ListWithBDDTest {

	@Test
	void testMockingList_When_SizeIsCalled_ShouldReturn10() {
		// Given / Arrange
		List<?> list = mock(List.class);
		// When / Act
		given(list.size()).willReturn(10);
		// Then / Assert
		assertThat(list.size(), is(10));
	}

	@Test
	void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
		// Given / Arrange
		List<?> list = mock(List.class);
		// When / Act
		given(list.size()).willReturn(10).willReturn(20);
		// Then / Assert
		assertThat(list.size(), is(10));
		assertThat(list.size(), is(20));
		assertThat(list.size(), is(20));
	}

	@Test
	void testMockingList_When_GetIsCalled_ShouldReturnErudio() {
		// Given / Arrange
		var list = mock(List.class);

		// When / Act
		given(list.get(0)).willReturn("Erudio");

		// Then / Assert
		assertThat(list.get(0), is("Erudio"));
		assertThat(list.get(1), is(nullValue()));
	}

	@Test
	void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnErudio() {
		// Given / Arrange
		var list = mock(List.class);

		// When / Act
		given(list.get(anyInt())).willReturn("Erudio");

		// Then / Assert
		assertThat(list.get(0), is("Erudio"));
		assertThat(list.get(1), is("Erudio"));
	}

	@Test
	void testMockingList_When_ThrowsAnException() {
		// Given / Arrange
		var list = mock(List.class);

		// When / Act
		given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar!"));

		// Then / Assert
		assertThrows(RuntimeException.class, () -> list.get(anyInt()), () -> "Should have thrown a RuntimeException");
	}
}
