package com.in28minutes.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {
	
	@Mock
	private DataService dataServiceMock;
	
	@InjectMocks
	private SomeBusinessImpl someBusinessImpl;

	@Test
	void findTheGreatestOfAllData_basicScenari() {
//		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
//		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
		assertEquals(25, someBusinessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void findTheGreatestOfAllData_oneValueTest() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
		assertEquals(35, someBusinessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void findTheGreatestOfAllData_emptyArray() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, someBusinessImpl.findTheGreatestFromAllData());
	}
	
	
}
