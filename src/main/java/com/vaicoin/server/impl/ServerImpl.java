/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaicoin.server.impl;

import com.vaicoin.client.Client;
import com.vaicoin.client.ClientRequest;
import com.vaicoin.server.Server;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.signers.PSSSigner;

/**
 *
 * @author vaibhav
 */
public class ServerImpl implements Server {

    private final AsymmetricCipherKeyPair keys;

    public ServerImpl(AsymmetricCipherKeyPair keys) {
        this.keys = keys;
    }

    @Override
    public RSAKeyParameters getPublic() {
        return (RSAKeyParameters) keys.getPublic();
    }

    @Override
    public byte[] sign(ClientRequest clientRequest) {
        // Sign the client request using server's private key.
        byte[] message = clientRequest.getMessage();

        RSAEngine engine = new RSAEngine();
        engine.init(true, keys.getPrivate());

        return engine.processBlock(message, 0, message.length);
    }

    @Override
    public boolean verify(Client client) {
        // Verify that the client has a valid signature using server's public key.
        byte[] id = client.getID();
        byte[] signature = client.getSignature();

        PSSSigner signer = new PSSSigner(new RSAEngine(), new SHA1Digest(), 20);
        signer.init(false, keys.getPublic());

        signer.update(id, 0, id.length);

        return signer.verifySignature(signature);
    }

}
