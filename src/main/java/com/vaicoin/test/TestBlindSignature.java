/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaicoin.test;

import com.vaicoin.client.Client;
import com.vaicoin.client.ClientRequest;
import com.vaicoin.server.ProtoClientRequest;
import com.vaicoin.server.Server;
import com.vaicoin.server.impl.ServerImpl;
import com.vaicoin.utils.Utils;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author vaibhav
 */
public class TestBlindSignature {
    
	


	public static void main(String[] args) throws CryptoException {
            Server server =  new ServerImpl(Utils.generateKeyPair());
            // Create Client using Server's public key.
		ProtoClientRequest clientRequest = new ProtoClientRequest(server.getPublic());

		// Generate a client request.
		ClientRequest clientnRequest = clientRequest.generateClientRequest();

		printClientRequest(clientnRequest);

		// Ask the server to sign the client request.

		// Note: In practice the server will be on a remote server and this will
		// be an asynchronous operation. The server will verify Alice's
		// credentials before signing the request.
		// Needless to say, the connection to the server would have to be over a
		// secure channel.

		byte[] signature = server.sign(clientnRequest);

		printServerSignature(signature);

		// Create a new client using the bank's signature.
		Client client = clientRequest.createClient(signature);

		printClient(client);

		// The signature on the client is different from the one the server
		// returned earlier. However the server should still be able to validate the client
		boolean valid = server.verify(client);
		if (valid) {
			System.out.println("client validated");
		} else {
			System.out.println("you are either not registered, or an intruder");
		}
	}

	private static void printClientRequest(ClientRequest clientRequest) {
		System.out.println("message signed by server:");
		System.out.println("");
		System.out.println(Base64.toBase64String(clientRequest.getMessage()));
		System.out.println("");
	}

	private static void printServerSignature(byte[] signature) {
		System.out.println("server's signature:");
		System.out.println("");
		System.out.println(Base64.toBase64String(signature));
		System.out.println("");
	}

	private static void printClient(Client client) {
		System.out.println("client:");
		System.out.println("");
		System.out.println(Base64.toBase64String(client.getID()));
		System.out.println("");
		System.out.println(Base64.toBase64String(client.getSignature()));
		System.out.println("");
	}
}
