/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.hellochat.hellochat;

import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.Extension;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author macbookpro
 */
public class FormSession implements Session{
    private FormUser user;
    private FormRoom room;
    private Date date;

    
    FormSession(){}
    
    FormSession(FormUser user, FormRoom room, Date date){
        this.date = date;
        this.room = room;
        this.user = user;
    }
    /**
     * @return the user
     */
    public FormUser getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(FormUser user) {
        this.user = user;
    }

    /**
     * @return the room
     */
    public FormRoom getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(FormRoom room) {
        this.room = room;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

	@Override
	public void addMessageHandler(MessageHandler arg0) throws IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close(CloseReason arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Async getAsyncRemote() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Basic getBasicRemote() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebSocketContainer getContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxBinaryMessageBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getMaxIdleTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxTextMessageBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<MessageHandler> getMessageHandlers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Extension> getNegotiatedExtensions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNegotiatedSubprotocol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Session> getOpenSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getPathParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProtocolVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<String>> getRequestParameterMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI getRequestURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getUserProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeMessageHandler(MessageHandler arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaxBinaryMessageBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaxIdleTimeout(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaxTextMessageBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}
    
    
}
