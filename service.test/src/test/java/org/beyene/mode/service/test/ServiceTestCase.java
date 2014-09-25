package org.beyene.mode.service.test;

import javax.inject.Inject;

import org.beyene.mode.service.Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.ExamReactorStrategy;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.ops4j.pax.exam.spi.reactors.AllConfinedStagedReactorFactory;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationAdmin;

@RunWith(JUnit4TestRunner.class)
@ExamReactorStrategy(AllConfinedStagedReactorFactory.class)
public class ServiceTestCase {

	@Inject
    private BundleContext bundleContext;
 
//    @Inject
//    private ConfigurationAdmin configurationAdmin;

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
		Assert.assertNotNull(bundleContext);
//		Assert.assertNotNull(configurationAdmin);
		Assert.assertNotNull(service);
	}
	
//	@Test
//	public void getService() {
//		Assert.assertEquals("This service implementation should add the numbers", 25, service.add(15, 10));
//	}
	
	public void setService(Service service) {
		this.service = service;
	}
}