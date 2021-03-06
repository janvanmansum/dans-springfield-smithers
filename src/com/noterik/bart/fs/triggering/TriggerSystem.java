/* 
* TriggerSystem.java
* 
* Copyright (c) 2012 Noterik B.V.
* 
* This file is part of smithers, related to the Noterik Springfield project.
*
* Smithers is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* Smithers is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with Smithers.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.noterik.bart.fs.triggering;

import java.util.Observable;

import org.apache.log4j.Logger;

/**
 * Triggering System
 *
 * @author Derk Crezee <d.crezee@noterik.nl>
 * @author Jaap Blom <j.blom@noterik.nl>
 * @author Pedro <pedro@noterik.nl>
 * @copyright Copyright: Noterik B.V. 2008
 * @package com.noterik.bart.fs.triggering
 * @access private
 * @version $Id: TriggerSystem.java,v 1.18 2011-10-19 13:24:49 derk Exp $
 *
 */
public class TriggerSystem extends Observable {

	/**
	 * logger class
	 */
	private static Logger logger = Logger.getLogger(TriggerSystem.class);
	
	/**
	 * get queue
	 */
	private TriggerSystemQueue getQueue;
	
	/**
	 * put queue
	 */
	private TriggerSystemQueue putQueue;
	
	/**
	 * post queue
	 */
	private TriggerSystemQueue postQueue;
	
	/**
	 * delete queue
	 */
	private TriggerSystemQueue deleteQueue;
	
	public TriggerSystem(){
		super();
		
		// create new GET, PUT, POST and DELETE Queue's
		getQueue = new TriggerSystemQueue("GET",100000);
		new Thread(getQueue).start();
		
		putQueue = new TriggerSystemQueue("PUT",100000);
		new Thread(putQueue).start();
		
		postQueue = new TriggerSystemQueue("POST",100000);
		new Thread(postQueue).start();
		
		deleteQueue = new TriggerSystemQueue("DELETE",100000);
		new Thread(deleteQueue).start();
		
		// add to trigger system as observer
		this.addObserver(getQueue);
		this.addObserver(putQueue);
		this.addObserver(postQueue);
		this.addObserver(deleteQueue);
	}
	
	/** Getters	**/
	
	public TriggerSystemQueue getGetQueue() {
		return getQueue;
	}
	
	public TriggerSystemQueue getPutQueue() {
		return putQueue;
	}
	
	public TriggerSystemQueue getPostQueue() {
		return postQueue;
	}
	
	public TriggerSystemQueue getDeleteQueue() {
		return deleteQueue;
	}

	/**
	 * Triggers an event
	 *
	 * @param uri
	 * @param method
	 * @param mimeType
	 * @param requestData
	 */
	public void eventHappened(String uri, String method, String mimeType, String requestData){
		// debug info
		logger.debug("TRIGGER -- uri: " + uri + ", method: " + method);
		
		// create event and notify observers
		TriggerEvent tEvent = new TriggerEvent(uri, method, mimeType, requestData);
		notifyObservers(tEvent);
	}

	/**
	 * Notifies observers
	 */
	public void notifyObservers(){
		setChanged();
		super.notifyObservers();
	}

	/**
	 * Notifies observers
	 */
	public void notifyObservers(Object arg){
		setChanged();
		super.notifyObservers(arg);
	}
}