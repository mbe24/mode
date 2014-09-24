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
package org.beyene.mode.service.consumer.impl;

import org.beyene.mode.service.Service;

public class Consumer {
	
	private Service service;
	
	public void setService(Service s) {
		this.service = s;
	}
	
	public void start() {
		System.out.println("service.consumer started!");
		
		int a = 10, b = 15;
		int c = service.add(a, b);
		
		System.out.printf("org.beyene.mode.service.Service.add(int, int): %d + %d = %d%n", a, b, c);
		System.out.printf("org.beyene.mode.service.Service.getDate()    : %s%n", service.getDate().toString());
	}
	
	public void stop() {
		System.out.println("service.consumer stopped!");
	}

}