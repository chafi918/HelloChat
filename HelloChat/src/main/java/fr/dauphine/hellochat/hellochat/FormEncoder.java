/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.hellochat.hellochat;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author macbookpro
 */
public class FormEncoder implements Encoder.Text<FormMessage> {
	@Override
	public void init(final EndpointConfig config) {
	}
 
	@Override
	public void destroy() {
	}
 
	@Override
	public String encode(final FormMessage formMessage) throws EncodeException {
		return Json.createObjectBuilder()
				.add("message", formMessage.getMessage())
				.add("sender", formMessage.getSender())
				.add("received", formMessage.getReceived().toString()).build()
				.toString();
	}
}
