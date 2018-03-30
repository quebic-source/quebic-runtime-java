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

import com.quebic.faas.runtime.exception.MessengerException;
import com.quebic.faas.runtime.handler.ErrorHandler;
import com.quebic.faas.runtime.handler.MessageHandler;

public interface Messenger {
	
	/**
	 * 
	 * @param eventID
	 * @param requestHandler
	 * @return
	 * @throws MessengerException
	 */
	void subscribe(
			String eventID, 
			MessageHandler requestHandler) throws MessengerException;
	
	/**
	 * 
	 * @param eventID
	 * @param requestHandler
	 * @param releaseAfter MILLISECONDS
	 * @return
	 * @throws MessengerException
	 */
	void subscribe(
			String eventID, 
			MessageHandler requestHandler,
			int releaseAfter) throws MessengerException;
	
	/**
	 * 
	 * @param eventID
	 * @param eventPayload
	 * @throws MessengerException
	 */
	void publish(
			String eventID, 
			Object eventPayload) throws MessengerException;
	
	/**
	 * 
	 * @param eventID
	 * @param eventPayload
	 * @param successHandler
	 * @param errorHandler
	 * @throws MessengerException
	 */
	void publish(
			String eventID, 
			Object eventPayload, 
			MessageHandler successHandler,
			ErrorHandler errorHandler) throws MessengerException;
	
	/**
	 * 
	 * @param eventID
	 * @param eventPayload
	 * @param successHandler
	 * @param errorHandler
	 * @param timeout MILLISECONDS
	 * @throws MessengerException
	 */
	void publish(
			String eventID, 
			Object eventPayload, 
			MessageHandler successHandler,
			ErrorHandler errorHandler,
			int timeout) throws MessengerException;
	
	/**
	 * 
	 * @param requestBaseEvent request baseEvent
	 * @param eventPayload reply payload
	 * @param statuscode reply statuscode
	 * @throws MessengerException
	 */
	void replySuccess(
			BaseEvent requestBaseEvent, 
			Object eventPayload,
			int statuscode) throws MessengerException;
	
	/**
	 * 
	 * @param requestBaseEvent request baseEvent
	 * @param error error message
	 * @param statuscode reply statuscode
	 * @throws MessengerException
	 */
	void replyError(
			BaseEvent requestBaseEvent, 
			String error,
			int statuscode) throws MessengerException;
	
}
