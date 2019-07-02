### BlindSignatures
Java implementation of Blind Signatures using BouncyCastle.

[![Build Status](https://travis-ci.com/vaibhavsingh1993/BlindSignatures.svg?branch=master)](https://travis-ci.com/vaibhavsingh1993/BlindSignatures)

Two entities client and server are defined. Client wants to send a message for the server to sign, without the server having any knowledge of the message.

1. Client picks a random number or blinding factor (relatively random to server's private key), and obfuscates the message by creating a digest of the random number, server's public key and the message.

2. The server then signs the digest (trust of client is assumed) and sends the signed digest back to the client. the client gets back his signed original message * random number, and he divides the digest with random number to get signed message.
