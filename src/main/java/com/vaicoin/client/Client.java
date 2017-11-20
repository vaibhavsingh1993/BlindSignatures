/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaicoin.client;

/**
 *
 * @author vaibhav
 */

// Entity representing a client
public interface Client {
    
	// The client's globally unique ID
	byte[] getID();

	// The server's signature for the client
	byte[] getSignature();    
}
