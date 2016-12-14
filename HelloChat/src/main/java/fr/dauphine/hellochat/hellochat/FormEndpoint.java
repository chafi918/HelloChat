package fr.dauphine.hellochat.hellochat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author macbookpro
 */
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/form", encoders = FormEncoder.class, decoders = FormDecoder.class)
public class FormEndpoint {

    private final Logger log = Logger.getLogger(getClass().getName());
    private Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    
    @OnOpen
    public void onOpen(Session session, @PathParam("room") final String room) {
        //log.info("session openend and bound to room: " + room);
        sessions.add(session);
        
        Iterator<Session> iterator = sessions.iterator();
        while (iterator.hasNext()) {
        	System.out.println("Established session old: " + iterator.next().getId());
        	System.out.println("Number of sessions : " + sessions.size());
        }
        
        System.out.println("Established session now: " + session.getId());
        //session.getUserProperties().put("room", room);
    }

    @OnMessage
    public void onMessage(final Session session, FormMessage chatMessage) throws IOException, EncodeException {
        System.out.println("test received Message: " + chatMessage.getMessage() + " . From: " + session.getId() );
        //session.getBasicRemote().sendObject(chatMessage);
        /*Iterator<Session> iterator = sessions.iterator();
        while (iterator.hasNext()) {
            iterator.next().getBasicRemote().sendObject(chatMessage);
        }*/
        
        for (Session sess : session.getOpenSessions()) {
            if (sess.isOpen())
               sess.getBasicRemote().sendObject(chatMessage);
         }
        
        //System.out.println("Received message: " + session.getUserProperties().get("message") + " .from session :  " + session);
        /*FormMessage outMsg = new FormMessage();
        outMsg.setMessage(chatMessage.getMessage());
        outMsg.setSender("Server");
        outMsg.setReceived(new Date());
        Iterator<Session> iterator = sessions.iterator();
        while (iterator.hasNext()) {
            iterator.next().getBasicRemote().sendObject(outMsg);
        }*/
    	
        /*String room = (String) session.getUserProperties().get("room");
         try {
         for (Session s : session.getOpenSessions()) {
         if (s.isOpen() && room.equals(s.getUserProperties().get("room"))) {
         s.getBasicRemote().sendObject(chatMessage);
         }
         }
         } catch (IOException | EncodeException e) {
         log.log(Level.WARNING, "onMessage failed", e);
         }*/

        /*
         String username = (String) session.getUserProperties().get("sender");
         FormMessage outMsg = new FormMessage();
		
         if(username == null){
         session.getUserProperties().put("username", chatMessage.getMessage());
         outMsg.setMessage("Tu es connecté comme" + chatMessage.getMessage());
         outMsg.setSender("Server");
         outMsg.setReceived(new Date());
         session.getBasicRemote().sendObject(outMsg);
         } else {
         outMsg.setMessage(chatMessage.getMessage());
         outMsg.setSender(username);
         outMsg.setReceived(new Date());
         Iterator<Session> iterator = sessions.iterator();
         while (iterator.hasNext()) {
         iterator.next().getBasicRemote().sendObject(outMsg);
         }
         }
         */
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println(session + ", DisConnected client...");
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}
