package org.beyene.mode.service.impl.internal;

import java.util.Calendar;

import org.beyene.mode.service.Service;
import org.junit.Assert;
import org.junit.Test;

public class ServiceImplTest {

	private final Service service = new ServiceImpl();

	@Test
	public void testGetDate() throws Exception {
		Calendar a = Calendar.getInstance();
		a.setTime(service.getDate());

		Calendar b = Calendar.getInstance();

		Assert.assertEquals(a.get(Calendar.YEAR), b.get(Calendar.YEAR));
	}

	@Test
	public void testAdd() throws Exception {
		Assert.assertEquals("This service implementation should add the numbers", 25, service.add(15, 10));
	}
}