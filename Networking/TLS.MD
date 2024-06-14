# Introduction

This sample project demonstrates a basic setup of a server and a client. The communication between the server and client happens through HTTP, so there is no encryption at all yet. The goal is to ensure that all communication will be encrypted.

**Definition**

* Identity: A KeyStore which holds the key pair also known as private and public key
* TrustStore: A KeyStore containing one or more certificates also known as public key. This KeyStore contains a list of trusted certificates
* One way authentication (also known as one way tls, one way ssl): Https connection where the client validates the certificate of the counter party
* Two way authentication (also known as two way tls, two way ssl, mutual authentication): Https connection where the client as well as the counter party validates the certificate, also known as mutual authentication


# Websites already use TLS, so why is mTLS not
used on the entire Internet?


For everyday purposes, one-way authentication provides
sufficient protection. The goals of TLS on the public Internet are

1) to ensure that people do not visit [spoofed websites](https://www.cloudflare.com/learning/ssl/what-is-domain-spoofing/),
2) to keep [privatedata](https://www.cloudflare.com/learning/privacy/what-is-data-privacy/) secure and encrypted as it crossesthe various networks that [comprisethe Internet](https://www.cloudflare.com/learning/network-layer/how-does-the-internet-work/), and
3) to make sure that data is not altered in transit.

 One-way TLS, in which the client verifies the server's identity only, accomplishes these goals.

Additionally, distributing TLS certificates to all end user devices would be extremely difficult. Generating, managing, and verifying the billions of certificates necessary for this is a near-impossible task.

But on a smaller scale, mTLS is highly useful and quite practical for individual organizations, especially when those organizations employ a Zero Trust approach to network security. Since a Zero Trust approach does not trust any user, device, or request by default, organizations must be able to authenticate every user, device, and request every time they try to access any point in the network. mTLS helps make this possible by authenticating users and verifying devices.

Two-way SSL begins with a “hello” from the client to the server. The server replies with a “hello” paired with its public certificate. The client verifies the received certificate using certificates stored in the client’s TrustStores. If the server certificate validation is successful, the client will present certificate stores in their KeyStores. The server validates the received certificate using the server’s TrustStores. The server decrypts session keys using the server’s private key to establish a secure connection.


# Keytools

## Creation and importing

Generate a Java keystore and key pair

```
keytool -genkeypair -keyalg RSA -keysize 2048 -keystore keystore.jks -alias server -validity 3650
```

Generate a Java keystore and key pair and include Distinguished Name as one-liner and the Extensions

```
keytool -genkeypair -keyalg RSA -keysize 2048 -keystore keystore.jks -alias server -dname "CN=Hakan,OU=Amsterdam,O=Thunderberry,C=NL" -storepass secret -keypass secret -validity 3650 -ext KeyUsage=digitalSignature,dataEncipherment,keyEncipherment,keyAgreement -ext ExtendedKeyUsage=serverAuth,clientAuth -ext SubjectAlternativeName:c=DNS:localhost,DNS:IP:127.0.0.1
```

Generate a Java keystore and import a certificate

```
keytool -importcert -file server.crt -keystore truststore.jks -alias server
```

Generate a Root CA with signing capability

```
keytool -v -genkeypair -dname "CN=Root-CA,OU=Certificate Authority,O=Thunderberry,C=NL" -keystore root-ca.jks -storepass secret -keypass secret -keyalg RSA -keysize 2048 -alias root-ca -validity 3650 -ext KeyUsage=digitalSignature,keyCertSign -ext BasicConstraints=ca:true,PathLen:3
```

Generate a certificate signing request (CSR) for an existing Java keystore

```
keytool -certreq -keyalg rsa -keystore keystore.jks -alias server -file server.csr
```

Import a root or intermediate CA certificate to an existing Java keystore

```
keytool -import -trustcacerts -file root-ca.crt -alias my-newly-trusted-ca -keystore keystore.jks
```

Import the content of a keystore into another keystore

```
keytool -v -importkeystore -srckeystore source.p12 -srcstoretype PKCS12 -srcstorepass changeit -destkeystore target.p12 -deststoretype PKCS12 -deststorepass changeit
```

## Checking

Check a stand-alone certificate

```
keytool -v -printcert -file server.crt
```

Check a stand-alone certificate in PEM format

```
keytool -v -printcert -file server.crt -rfc
```

Check which certificates are in a Java keystore

```
keytool -v -list -keystore keystore.jks
```

Check a particular keystore entry using an alias

```
keytool -v -list -keystore keystore.jks -alias server
```

## Other commands

Delete a certificate from a Java keystore

```
keytool -delete -alias server -keystore keystore.jks
```

Change a Java keystore password

```
keytool -storepasswd -keystore keystore.jks
```

Signing a certificate with a certificate signing request (CSR)

```
keytool -v -gencert -infile server.csr -outfile server-signed.cer -keystore root-ca.jks -storepass secret -alias root-ca -validity 3650 -ext KeyUsage=digitalSignature,dataEncipherment,keyEncipherment,keyAgreement -ext ExtendedKeyUsage=serverAuth,clientAuth
```

Converting JKS to PKCS12

```
keytool -importkeystore -srckeystore keystore.jks -srcstoretype JKS -srcstorepass -destkeystore keystore.p12 -deststoretype PKCS12 password -deststorepass password
```

Converting PKCS12 to JKS

```
keytool -importkeystore -srckeystore keystore.p12 -srcstoretype PKCS12 -srcstorepass -destkeystore keystore.jks -deststoretype JKS password -deststorepass password
```

### Exporting

Export a certificate to a .crt file in a binary format

```
keytool -exportcert -keystore keystore.jks -alias server -file server.crt
```

Export a certificate to a .crt file in a pem format

```
keytool -exportcert -keystore keystore.jks -alias server -rfc -file server.crt
```

Export Java keystore to a .p12 file

```
keytool -importkeystore -srckeystore keystore.jks -destkeystore keystore.p12 -srcstoretype jks -deststoretype pkcs12
```


# OpenSSL


## Install

Install the OpenSSL on Debian based systems

```shell
sudo apt-get install openssl
```

## Commands

### Creation

Create a private key

```shell
openssl genrsa -out server.key 4096
```

Generate a new private key and certificate signing request

```shell
openssl req -out server.csr -new -newkey rsa:4096 -nodes -keyout server.key
```

Generate a self-signed certificate

```shell
openssl req -x509 -sha256 -nodes -days 365 -newkey rsa:4096 -keyout server.key -out server.crt
```

Generate a certificate signing request (CSR) for an existing private key

```shell
openssl req -out server.csr -key server.key -new
```

Generate a certificate signing request based on an existing certificate

```shell
openssl x509 -x509toreq -in server.crt -out server.csr -signkey server.key
```

Generate a Diffie Hellman key

```shell
openssl dhparam -out dhparam.pem 2048
```

Generate a v3 certificate by signing CSR

```shell
openssl x509 -days 365 -in myCSR.csr -extfile v3.ext -CA myCA.crt -CAkey myCA.key -CAcreateserial -out userCertificate.crt
```

See below for an example `v3.ext` file

```
authorityKeyIdentifier=keyid,issuer
basicConstraints=CA:FALSE
keyUsage = digitalSignature, nonRepudiation, keyEncipherment, dataEncipherment
```

### Checking


Check a certificate signing request (CSR)

```shell
openssl req -text -noout -verify -in server.csr
```

Check a private key

```shell
openssl rsa -in server.key -check
```

Check a public key

```shell
openssl rsa -inform PEM -pubin -in pub.key -text -noout
openssl pkey -inform PEM -pubin -in pub.key -text -noout
```

Check a certificate

```shell
openssl x509 -in server.crt -text -noout
openssl x509 -in server.cer -text -noout
```

Check a PKCS#12 file (.pfx or .p12)

```shell
openssl pkcs12 -info -in server.p12
```

Verify a private key matches an certificate

```shell
openssl x509 -noout -modulus -in server.crt | openssl md5
openssl rsa -noout -modulus -in server.key | openssl md5
openssl req -noout -modulus -in server.csr | openssl md5
```

Display all certificates including intermediates

```shell
openssl s_client -connect www.paypal.com:443
```

### Converting

Convert a DER file (.crt .cer .der) to PEM

```shell
openssl x509 -inform der -in server.cer -out server.pem
```

Convert a PEM file to DER

```shell
openssl x509 -outform der -in server.pem -out server.der
```

Convert a PKCS#12 file (.pfx .p12) containing a private key and certificates to PEM

```shell
openssl pkcs12 -in server.pfx -out server.pem -nodes
```

Convert a PEM certificate file and a private key to PKCS#12 (.pfx .p12)

```shell
openssl pkcs12 -export -out server.pfx -inkey server.key -in server.crt -certfile CACert.crt
```

### Other commands

Remove a passphrase from a private key

```shell
openssl rsa -in server.pem -out newserver.pem
```

Parse a list of revoked serial numbers

```shell
openssl crl -inform DER -text -noout -in list.crl
```

Encrypt files with rsautl

```shell
openssl rsautl -encrypt -in plaintext.txt -out encrypted.txt -pubin -inkey pubkey.pem
```

Decrypt files with rsautl

```shell
openssl rsautl -decrypt -in encrypted.txt -out plaintext.txt -inkey privkey.pem
```

### Exporting

Extracting Public Key from Private Key

```
openssl rsa -in privkey.pem -pubout > key.pub
```

Extracting Public Key from Certificate

```
openssl x509 -pubkey -noout -in cert.pem  > pubkey.pem
```


# Curl with Java KeyStore

Curl doesn't have support for java keystore file, so therefor the file should be converted to a PEM format. It consists of the following multiple steps:

1. Convert keystore to p12 file
2. Convert p12 file to pem file
3. Run curl command with pem files

## One way TLS/SSL/Authentication


### Convert keystore to p12 file


```
keytool -importkeystore -srckeystore truststore.jks -destkeystore truststore.p12 -srcstoretype JKS -deststoretype PKCS12
```

### Convert p12 file to pem file


```
openssl pkcs12 -in truststore.p12 -out trusted-certs.pem
```

### Run curl command with pem files

Example curl request with loading trusted certificates:

```
curl secret --cacert trusted-certs.pem https://localhost:8443/api/hello
```

## Two way TLS/SSL/Authentication also known as Mutual Authentication


### Convert keystore to p12 file


```
keytool -importkeystore -srckeystore identity.jks -destkeystore identity.p12 -srcstoretype JKS -deststoretype PKCS12
```

### Convert p12 file to pem file


```
openssl pkcs12 -in identity.p12 -nokeys -out client-cert.pem
openssl pkcs12 -in identity.p12 -nocerts -out client-key.pem
```

### Run curl command with pem files


```
curl --key client-key.pem --cert client-cert.pem --cacert trusted-certs.pem https://localhost:8443/api/hello
```

## Additional options

Have paswordless private key pem file with `-nodes` options, see example below

```
openssl pkcs12 -in identity.p12 -nocerts -nodes -out client-key.pem
```

Inline password instead of prompting with `-password pass:secret` options, see example below

```
openssl pkcs12 -in identity.jks -nocerts -password pass:secret -out client-key.pem -nodes
```
