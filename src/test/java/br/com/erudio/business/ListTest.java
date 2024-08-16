package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

	@Test
	void testMockingList_When_SizeIsCalled_ShouldReturn10() {
		// Given / Arrange
		List<?> list = mock(List.class);
		// When / Act
		when(list.size()).thenReturn(10);
		// Then / Assert
		assertEquals(10, list.size());
	}

	@Test
	void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
		// Given / Arrange
		List<?> list = mock(List.class);
		// When / Act
		when(list.size()).thenReturn(10).thenReturn(20);
		// Then / Assert
		assertEquals(10, list.size());
		assertEquals(20, list.size());
	}

	@Test
	void testMockingList_When_GetIsCalled_ShouldReturnErudio() {
		// Given / Arrange
		var list = mock(List.class);

		// When / Act
		when(list.get(0)).thenReturn("Erudio");

		// Then / Assert
		assertEquals("Erudio", list.get(0));
		assertNull(list.get(1));
	}

	@Test
	void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnErudio() {
		// Given / Arrange
		var list = mock(List.class);

		// When / Act
		when(list.get(anyInt())).thenReturn("Erudio");

		// Then / Assert
		assertEquals("Erudio", list.get(0));
		assertEquals("Erudio", list.get(1));
	}

	@Test
	void testMockingList_When_ThrowsAnException() {
		// Given / Arrange
		var list = mock(List.class);

		// When / Act
		when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar!"));

		// Then / Assert
		assertThrows(RuntimeException.class, () -> list.get(anyInt()), () -> "Should have thrown a RuntimeException");
	}
}
