/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.hellochat.hellochat;

/**
 *
 * @author macbookpro
 */
public enum Status {
    ACTIVE, NOT_ACTIVE;
    
    public String toString(){
        return this.name();
    }
}
