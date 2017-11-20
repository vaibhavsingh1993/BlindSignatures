/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaicoin.server;

import com.vaicoin.client.Client;
import com.vaicoin.client.ClientRequest;
import org.bouncycastle.crypto.params.RSAKeyParameters;

/**
 *
 * @author vaibhav
 */

// Entity representing server and its behavior
public interface Server {
    
	// The client's RSA public key
	RSAKeyParameters getPublic();

	// Server signs request
	byte[] sign(ClientRequest clientRequest);

	// Server verifies request
	boolean verify(Client client);
    
}
