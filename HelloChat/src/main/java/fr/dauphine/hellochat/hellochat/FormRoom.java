/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.hellochat.hellochat;
import java.util.HashSet;
import java.util.Set;
import javax.json.JsonObject;
import javax.json.spi.JsonProvider;
/**
 *
 * @author macbookpro
 */
public class FormRoom {
    private String name;
    private Set<FormUser> users = new HashSet<>();
    private Set<FormMessage> messages = new HashSet<>();
    
    public void removeUser(int id){
        FormUser user = getUserById(id);
        if (user != null) {
            users.remove(user);
            JsonProvider provider = JsonProvider.provider();
            JsonObject removeMessage = provider.createObjectBuilder()
                    .add("action", "remove")
                    .add("id", id)
                    .build();
            sendToAllConnectedSessions(removeMessage);
        }
    }
    
    public void addUser(FormUser user){
        users.add(user);
        JsonObject addMessage = createAddMessage(user);
        sendToAllConnectedSessions(addMessage);
    }
    
    public void addMessage(FormMessage message){
        messages.add(message);
        for (FormUser user : users) {
            JsonObject addMessage = createAddMessage(user);
            //sendToSession(message, addMessage);
        }
    }
    
    public void toggleDevice(int id) {
        JsonProvider provider = JsonProvider.provider();
        FormUser user = getUserById(id);
        if (user != null) {
            if (user.getStatus() == Status.ACTIVE) {
                user.setStatus(Status.NOT_ACTIVE);
            } else {
                user.setStatus(Status.ACTIVE);
            }
            JsonObject updateDevMessage = provider.createObjectBuilder()
                    .add("action", "toggle")
                    .add("id", user.getId())
                    .add("firstName", user.getFirstName())
                    .add("lastName", user.getLastName())
                    .add("status", user.getStatus().toString())
                    .build();
            sendToAllConnectedSessions(updateDevMessage);
        }
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the users
     */
    public Set<FormUser> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Set<FormUser> users) {
        this.users = users;
    }

    /**
     * @return the messages
     */
    public Set<FormMessage> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(Set<FormMessage> messages) {
        this.messages = messages;
    }
    
    public void toggleUser(int id) {
    }

    private FormUser getUserById(int id) {
        for (FormUser user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    private JsonObject createAddMessage(FormUser user) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject addMessage = provider.createObjectBuilder()
                .add("action", "add")
                .add("id", user.getId())
                .add("firstName", user.getFirstName())
                .add("lastName", user.getLastName())
                .add("status", user.getStatus().toString())
                .build();
        return addMessage;
    }

    private void sendToAllConnectedSessions(JsonObject message) {

    }

}
