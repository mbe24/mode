package org.beyene.mode.service.test;

import javax.inject.Inject;

import org.beyene.mode.service.Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationAdmin;

@RunWith(JUnit4TestRunner.class)
public class ServiceTestCase {

	@Inject
    private BundleContext bundleContext;
 
    @Inject
    private ConfigurationAdmin configurationAdmin;

    private Service service;
    
	@Configuration
	public Option[] config() {
		
		return CoreOptions.options(
				CoreOptions.mavenBundle("org.apache.felix", "org.apache.felix.scr", "1.6.2"),
				CoreOptions.junitBundles());
	}

	@Test
	public void getService() {
		Assert.assertEquals("This service implementation should add the numbers", 25, service.add(15, 10));
	}
	
	public void setService(Service service) {
		this.service = service;
	}
}