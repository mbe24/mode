/*
 * Copyright 2014 Mikael Beyene
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.beyene.mode.service.test;

import java.util.Calendar;

import javax.inject.Inject;

import org.beyene.mode.service.Service;
import org.junit.Assert;
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
				/* needed for ds annotations */
				CoreOptions.mavenBundle("org.apache.felix", "org.apache.felix.scr", "1.8.2"),
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
}