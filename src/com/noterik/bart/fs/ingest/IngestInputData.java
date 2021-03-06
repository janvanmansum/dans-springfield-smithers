/* 
* IngestInputData.java
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
package com.noterik.bart.fs.ingest;

public class IngestInputData {
	
	/*
	 * whether the calling client is smart or not. Smart clients 
	 */ 
	private boolean smart;
	/*
	 *  user and profile need to be set when smart == false
	 */
	private String profile;
	private String user;
	/*
	 * destinationUri is only for smart clients who now where the file will be put.
	 * (because they set the properties in the file system themselves) 
	 */
	private String destinationUri;
	/*
	 * the source and collection id are always needed. The source has to be the full path to 
	 * the file in the ingest directory
	 */
	private String source;	
	private String collectionId;
	/*
	 * Optional parameter for dumb clients (if supplied this video will be updated)
	 */
	private String videoId;
	
	/*
	 * Optional parameter preferred. Lets client determine the mount
	 */
	private String preferred;
	
	
	/*
	 *  Optional, specifies the use or not of momar
	 */
	private boolean momar;

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}

	public String getDestinationUri() {
		return destinationUri;
	}

	public void setDestinationUri(String destinationUri) {
		this.destinationUri = destinationUri;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public boolean isSmart() {
		return smart;
	}

	public void setSmart(boolean smart) {
		this.smart = smart;
	}

	public String getPreferred() {
		return preferred;
	}
	public void setPrefferredMount(String preferred) {
		this.preferred = preferred;
	}
	
	public boolean getMomar() {
		return momar;
	}

	public void setMomar(boolean momar) {
		this.momar = momar;
	}

}