/* 
* CacheMulticastSender.java
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
package com.noterik.bart.fs.fscommand.dynamic.presentation.playout;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import com.noterik.bart.fs.LazyHomer;
import org.apache.log4j.Logger;

public class CacheMulticastSender {
	private static final Logger log = Logger.getLogger(CacheMulticastSender.class);
	
	static String group = "224.0.0.0";
	static int ttl = 1;
	
	public static synchronized void send(String adr,String method, String imsg) {
		try {
			MulticastSocket s = new MulticastSocket();
			String msg = adr+" "+method+" "+imsg+" "+LazyHomer.getPort();
			//log.debug("SENDING=> "+msg);
			byte[] buf = msg.getBytes();
			DatagramPacket pack = new DatagramPacket(buf, buf.length,InetAddress.getByName(group), LazyHomer.getPort());
			s.send(pack,(byte)ttl);
			s.close();
		} catch(Exception e) {
			log.debug("Smithers : multicast sender error");
		}
	}

}
