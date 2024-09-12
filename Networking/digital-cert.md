# Digital signature and verification
A digital signature is a mathematical scheme for presenting the authenticity of digital messages or documents.
Message / file to be sent is signed with private key.
Message received by the recipient is authenticated using public key.

RSA signature generation : Behind the scene
![image](https://github.com/user-attachments/assets/ad5f4405-5b00-4e82-954a-e8e2e09397f6)

RSA Signature verification : Behind the scene
![image](https://github.com/user-attachments/assets/ccba1c9b-9f30-498c-91dd-e11a5062e66b)


To use RSA for encryption, Alice encrypts the message using Bob's public key. The only way to read this message is with Bob's private key, which only he has. Thus Eve can't read the message because he does not have this key. On the other hand, this provides no authentication of the source of the message. Eve can also get Bob's public key (since it's public) and send messages to Bob, pretending to be Alice.

To use RSA for signing, Alice takes a hash of the message, encrypts the hash using her own private key, and appends the result (this is the signature) to the message. Eve can of course still decrypt this using Alice's public key. However, Bob can decrypt the signature using Alice's public key and see if it matches. If it does, it must have been encrypted using Alice's private key, which only she has, so it must have come from Alice.

# How CA Works ?
To request an SSL certificate from a CA like Verisign or GoDaddy, you send them a Certificate Signing Request (CSR), and they give you an SSL certificate in return that they have signed using their root certificate and private key. All browsers have a copy (or access to a copy from the operating system) of the root certificate from the various CAs, so the browser can verify that your certificate was signed by a trusted CA.

That’s why when you generate a self-signed certificate the browser doesn’t trust it. It hasn’t been signed by a CA. The way to get around this is to generate our own root certificate and private key. We then add the root certificate to all the devices we own just once, and then all the self-signed certificates we generate will be inherently trusted.

# The keys work inversely:

## Public key encrypts, private key decrypts (encrypting):

openssl rsautl -encrypt -inkey public.pem -pubin -in message.txt -out message.ssl
openssl rsautl -decrypt -inkey private.pem       -in message.ssl -out message.txt

## Private key encrypts, public key decrypts (signing):

openssl rsautl -sign -inkey private.pem       -in message.txt -out message.ssl
openssl rsautl       -inkey public.pem -pubin -in message.ssl -out message.txt

# Question:
If public key cryptography ensures that a public key can be derived from a private key, but a private key cannot be derived from a public key, then you might wonder, how can a public key decrypt a message signed with a private key without the sender exposing the private key within the signed message to the recipient?

# Answer :
 - Asymmetric cryptography means that you can either: Encrypt with public key, decrypt with matching private key
 - Encrypt with private key, decrypt with matching public key (how this works?)
We know that both example #1 and #2 work. Example #1 makes intuitive sense, while example #2 begs the original question.

Turns out, elliptic curve cryptography (also called "elliptic curve multiplication") is the answer to the original question. Elliptic curve cryptography is the mathematical relationship that makes the following conditions possible:

A public key can be mathematically generated from a private key
A private key cannot be mathematically generated from a public key (i.e. "trapdoor function")
A private key can be verified by a public key
To most, conditions #1 and #2 make sense, but what about #3?

You have two choices here:

You can go down a rabbit-hole and spend hours upon hours learning how elliptic curve cryptography works (here is a great starting point)... OR...
You can accept the properties above--just like you accept Newton's 3 laws of motion without needing to derive them yourself.

In conclusion, a public/private keypair is created using elliptic curve cryptography, which by nature, creates a public and private key that are mathematically linked in both directions, but not mathematically derived in both directions. This is what makes it possible for you to use someone's public key to verify that they signed a specific message, without them exposing their private key to you.

# RSA sign and verify using OpenSSL

# Create a file containing all lower case alphabets
$ echo abcdefghijklmnopqrstuvwxyz > myfile.txt
# Generate 512 bit Private key
$ openssl genrsa -out myprivate.pem 512
# Separate the public part from the Private key file.
$ openssl rsa -in myprivate.pem -pubout > mypublic.pem
# Cat the contents of private key
$ cat myprivate.pem
-----BEGIN RSA PRIVATE KEY-----
MIIBOwIBAAJBAMv7Reawnxr0DfYN3IZbb5ih/XJGeLWDv7WuhTlie//c2TDXw/mW
914VFyoBfxQxAezSj8YpuADiTwqDZl13wKMCAwEAAQJAYaTrFT8/KpvhgwOnqPlk
NmB0/psVdW6X+tSMGag3S4cFid3nLkN384N6tZ+na1VWNkLy32Ndpxo6pQq4NSAb
YQIhAPNlJsV+Snpg+JftgviV5+jOKY03bx29GsZF+umN6hD/AiEA1ouXAO2mVGRk
BuoGXe3o/d5AOXj41vTB8D6IUGu8bF0CIQC6zah7LRmGYYSKPk0l8w+hmxFDBAex
IGE7SZxwwm2iCwIhAInnDbe2CbyjDrx2/oKvopxTmDqY7HHWvzX6K8pthZ6tAiAw
w+DJoSx81QQpD8gY/BXjovadVtVROALaFFvdmN64sw==
-----END RSA PRIVATE KEY-----

# Sign using Openssl
Message digest algorithm : SHA1
Padding scheme : PCKS#1 v1.5
# Sign the file using sha1 digest and PKCS1 padding scheme
$ openssl dgst -sha1 -sign myprivate.pem -out sha1.sign myfile.txt
# Dump the signature file
$ hexdump sha1.sign
0000000 91 39 be 98 f1 6c f5 3d 22 da 63 cb 55 9b b0 6a
0000010 93 33 8d a6 a3 44 e2 8a 42 85 c2 da 33 fa cb 70
0000020 80 d2 6e 7a 09 48 37 79 a0 16 ee bc 20 76 02 fc
0000030 3f 90 49 2c 2f 2f b8 14 3f 0f e3 0f d8 55 59 3d
0000040

# Verify sign using Openssl
Openssl decrypts the signature to generate hash and compares it to the hash of the input file.
# Verify the signature of file
$ openssl dgst -sha1 -verify mypublic.pem -signature sha1.sign myfile.txt
Verified OK


