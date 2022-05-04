package com.worthen.cody.springnotes.cdi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * UNIT TEST USING MOCKITO
 * 
 * We don't need a Spring context when writing tests with Mockito. Mockito unit
 * tests are much faster than Spring unit tests.
 */
@ExtendWith(MockitoExtension.class)
public class SomeCdiBusinessTest {

	@Mock // use this because DataService doesn't have any dependencies
	private SomeCdiDao daoMock;

	@InjectMocks // use this because SomeBusinessImpl has dependencies that need injected
	private SomeCdiBusiness businessMock;

	@Test
	public void testBasicScenario() {
		when(daoMock.getData()).thenReturn(new int[] { 5, 89, 100 });

		// max should be 100
		assertEquals(100, businessMock.findMax());
	}

	@Test
	public void testBasicScenario_noElements() {
		when(daoMock.getData()).thenReturn(new int[] {});

		// max should be 100
		assertEquals(Integer.MIN_VALUE, businessMock.findMax());
	}

	@Test
	public void testBasicScenario_equalElements() {
		when(daoMock.getData()).thenReturn(new int[] { 5, 5 });

		// max should be 100
		assertEquals(5, businessMock.findMax());
	}

}
