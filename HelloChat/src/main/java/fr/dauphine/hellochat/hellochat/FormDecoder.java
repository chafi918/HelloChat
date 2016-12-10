/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.hellochat.hellochat;

import java.io.StringReader;
import java.util.Date;
 
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
/**
 *
 * @author macbookpro
 */
public class FormDecoder implements Decoder.Text<FormMessage> {
	@Override
	public void init(final EndpointConfig config) {
	}
 
	@Override
	public void destroy() {
	}
 
	@Override
	public FormMessage decode(final String textMessage) throws DecodeException {
		FormMessage formMessage = new FormMessage();
		JsonObject obj = Json.createReader(new StringReader(textMessage))
				.readObject();
		formMessage.setMessage(obj.getString("message"));
		formMessage.setSender(obj.getString("sender"));
		formMessage.setReceived(new Date());
		return formMessage;
	}
 
	@Override
	public boolean willDecode(final String s) {
		return true;
	}
    
}
