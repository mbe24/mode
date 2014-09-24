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
package org.beyene.mode.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.beyene.mode.service.Service;

public class ServiceImpl implements Service {

	@Override
	public Date getDate() {
		Date date = Calendar.getInstance().getTime();
		return date;
	}

	@Override
	public int add(int a, int b) {
		int result = a + b;
		return result;
	}
	
}