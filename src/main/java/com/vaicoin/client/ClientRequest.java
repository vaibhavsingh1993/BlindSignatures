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
public interface ClientRequest {   
	// The message (blind) to be signed by the server
	byte[] getMessage();
}
