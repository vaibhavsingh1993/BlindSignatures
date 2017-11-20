/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaicoin.client.impl;

import com.vaicoin.client.Client;

/**
 *
 * @author vaibhav
 */
public class ClientImpl implements Client {

    private final byte[] id;
    private final byte[] signature;

    public ClientImpl(byte[] id, byte[] signature) {
        this.id = id;
        this.signature = signature;
    }

    @Override
    public byte[] getID() {
        return id;
    }

    @Override
    public byte[] getSignature() {
        return signature;
    }

}
