package org.beyene.mode.service.test;

import java.util.Calendar;

import javax.inject.Inject;

import org.beyene.mode.service.Service;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;

@RunWith(JUnit4TestRunner.class)
public class ServiceTestCase {

    @Inject
    private Service service;
    
	@Configuration
	public Option[] config() {
		return CoreOptions.options(
				CoreOptions.mavenBundle("org.apache.felix", "org.apache.felix.scr", "1.8.2"),
				CoreOptions.mavenBundle("org.eclipse.osgi", "org.eclipse.osgi.services", "3.2.100.v20100503"),
				CoreOptions.bundle("reference:file:../service/target/service-0.0.1-SNAPSHOT.jar"),
				CoreOptions.bundle("reference:file:../service.impl/target/service.impl-0.0.1-SNAPSHOT.jar"),
				CoreOptions.junitBundles());
	}
	
	@Test
	public void testInjections() {
		Assert.assertNotNull(service);
	}
	
	@Test
	public void testAdd() {
		Assert.assertEquals("This service implementation should add the numbers", 25, service.add(15, 10));
	}
	
	@Test
	public void testGetDate() {
		Calendar a = Calendar.getInstance();
		a.setTime(service.getDate());
		
		Calendar b = Calendar.getInstance();
		
		Assert.assertEquals(a.get(Calendar.YEAR), b.get(Calendar.YEAR));
	}
	
	// needed by eclipse, current setup does not support dc annotations
	@Ignore
	public void setService(Service service) {
		this.service = service;
	}
}