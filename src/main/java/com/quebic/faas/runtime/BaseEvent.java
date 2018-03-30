/*******************************************************************************
 * Copyright 2018 Tharanga Nilupul Thennakoon
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.quebic.faas.runtime;

import java.util.Map;
import java.util.Optional;

public interface BaseEvent {
	
	String eventID();
	
	String requestID();
	
	String created();
	
	String requestHTTPMethod();
	
	String requestPath();
	
	int statuscode();
	
	String error();
	
	Map<String, Object> headers();
	
	Optional<Object> headerValue(String key);
	
	byte[] payload();

	String payloadAsString();

	<T> T payloadAsObject(Class<T> type);

}