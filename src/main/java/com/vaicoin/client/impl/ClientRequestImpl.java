/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaicoin.client.impl;

import com.vaicoin.client.ClientRequest;

/**
 *
 * @author vaibhav
 */

// Request entity is defined by a blind message.
public class ClientRequestImpl implements ClientRequest {

    private final byte[] message;

    public ClientRequestImpl(byte[] message) {
        this.message = message;
    }

    public byte[] getMessage() {
        return message;
    }
}
