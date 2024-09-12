# How to generate RSA and EC keys with OpenSSL
How to generate keys in PEM format using the OpenSSL command line tools?

# RSA keys
The JOSE standard recommends a minimum RSA key size of 2048 bits.

To generate a 2048-bit RSA private + public key pair for use in RSxxx and PSxxx signatures:

```openssl genrsa 2048 -out rsa-2048bit-key-pair.pem ```

# Elliptic Curve keys
To generate an EC key pair the curve designation must be specified. Note that JOSE ESxxx signatures require P-256, P-384 and P-521 curves (see their corresponding OpenSSL identifiers below).

Elliptic Curve private + public key pair for use with ES256 signatures:

```openssl ecparam -genkey -name prime256v1 -noout -out ec256-key-pair.pem```

Elliptic Curve private + public key pair for use with ES384 signatures:

```openssl ecparam -genkey -name secp384r1 -noout -out ec384-key-pair.pem```

Elliptic Curve private + public key pair for use with ES512 signatures:

```openssl ecparam -genkey -name secp521r1 -noout -out ec512-key-pair.pem```

# PEM key parsing in Java
The BouncyCastle library provides a simple utility to parse PEM-encoded keys in Java, to use them for JWS or JWE later.
For Maven you should include the following BouncyCastle dependencies:
```
 <dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcprov-jdk15on</artifactId>
    <version>1.52</version>
</dependency>
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcpkix-jdk15on</artifactId>
    <version>1.52</version>
</dependency>
```

# OpenSSL
is a powerful tool for generating RSA key pairs for various cryptographic purposes including signing JSON Web Tokens (JWT).
Below are the steps to generate RSA key pairs using OpenSSL, along with some commonly used options and commands.

## Generate a Private Key

```
openssl genrsa -out private_key.pem 2048

```

- -out private_key.pem: Specifies the output file path for the private key.

- 2048 (bits): The private key length. It is recommended that you use a minimum of 2048 when using RSA 256. If you can, prefer using longer key length. The longer the key is, the more robust the encryption is.

## Generate a Public Key from the Private Key
```
openssl rsa -pubout -in private_key.pem -out public_key.pem
```

- -pubout: Instructs OpenSSL to generate the public key.

- -in private_key.pem: Specifies the input private key file.

- -out public_key.pem: Specifies the output file for the public key.

## View Key Details (Optional)
```
openssl rsa -text -in private_key.pem

```
## View Public Key Details

```
openssl rsa -pubin -text -in public_key.pem
```


# Becoming a (Tiny) Certificate Authority
It’s kind of ridiculous how easy it is to generate the files needed to become a certificate authority. It really only takes two commands. Let’s dive into how we can do this on macOS and Linux, and then look at how it works in the Windows operating system.

- Generating the Private Key and Root Certificate:
  ```openssl genrsa -des3 -out myCA.key 2048```
OpenSSL will ask for a passphrase, which we recommend not skipping and keeping safe. The passphrase will prevent anyone who gets your private key from generating a root certificate of their own

- generate a root certificate:
  ```openssl req -x509 -new -nodes -key myCA.key -sha256 -days 1825 -out myCA.pem```
  You will be prompted for the passphrase of the private key you just chose and a bunch of questions. The answers to those questions aren’t that important. They show up when looking at the certificate, which you will almost never do. I suggest making the Common Name something that you’ll recognize as your root certificate in a list of other certificates. That’s really the only thing that matters.You should now have two files: myCA.key (your private key) and myCA.pem (your root certificate).

- Installing Your Root Certificate:
  To become a real CA, you need to get your root certificate on all the devices in the world.
  But we don’t need to become a real CA. We just need to be a CA for the devices you own. We need to add the root certificate to any laptops, desktops, tablets, and phones that access your HTTPS sites. This can be a bit of a pain, but the good new

Adding the Root Certificate to Windows 10

- Open the “Microsoft Management Console” by using the Windows + R keyboard combination, typing mmc and clicking Open
- Go to File > Add/Remove Snap-in
- Click Certificates and Add
- Select Computer Account and click Next
- Select Local Computer then click Finish
- Click OK to go back to the MMC window
- Double-click Certificates (local computer) to expand the view
- Select Trusted Root Certification Authorities, right-click on Certificates in the middle column under “Object Type” and select All Tasks then Import
- Click Next then Browse. Change the certificate extension dropdown next to the filename field to All Files (*.*) and locate the myCA.pem file, click Open, then Next
- Select Place all certificates in the following store. “Trusted Root Certification Authorities store” is the default. Click Next then click - Finish to complete the wizard.
If everything went according to plan, you should see your CA certificate listed under Trusted Root Certification Authorities > Certificates.

# Creating CA-Signed Certificates for Your Dev Sites
Now we’re a CA on all our devices and we can sign certificates for any new dev sites that need HTTPS. First, we create a private key for the dev site. Note that we name the private key using the domain name URL of the dev site. This is not required, but it makes it easier to manage if you have multiple sites
- ```openssl genrsa -out hellfish.test.key 2048```
-  create a CSR: ```openssl req -new -key hellfish.test.key -out hellfish.test.csr```
 You’ll get all the same questions as you did above and, again, your answers don’t matter. In fact, they matter even less because you won’t be looking at this certificate in a list next to others.

Finally, we’ll create an X509 V3 certificate extension config file, which is used to define the Subject Alternative Name (SAN) for the certificate. In our case, we’ll create a configuration file called hellfish.test.ext containing the following text:

```
authorityKeyIdentifier=keyid,issuer
basicConstraints=CA:FALSE
keyUsage = digitalSignature, nonRepudiation, keyEncipherment, dataEncipherment
subjectAltName = @alt_names

[alt_names]
DNS.1 = hellfish.test
```
We’ll be running openssl x509 because the x509 command allows us to edit certificate trust settings. In this case we’re using it to sign the certificate in conjunction with the config file, which allows us to set the Subject Alternative Name. I originally found this answer on Stack Overflow.

Now we run the command to create the certificate: using our CSR, the CA private key, the CA certificate, and the config file:

```
openssl x509 -req -in hellfish.test.csr -CA myCA.pem -CAkey myCA.key \
-CAcreateserial -out hellfish.test.crt -days 825 -sha256 -extfile hellfish.test.ext
```
We now have three files: hellfish.test.key (the private key), hellfish.test.csr (the certificate signing request, or csr file), and hellfish.test.crt (the signed certificate). We can configure local web servers to use HTTPS with the private key and the signed certificate.

If you’re on Linux or Windows using Apache, you’ll need to enable the Apache SSL mod, and configure an Apache virtual host for port 443 for the local site. It will require you to add the SSLEngine, SSLCertificateFile, and SSLCertificateKeyFile directives, and point the last two to the certificate and key file you just created.
```
<VirtualHost *:443>
   ServerName hellfish.test
   DocumentRoot /var/www/hellfish-test

   SSLEngine on
   SSLCertificateFile /path/to/certs/hellfish.test.crt
   SSLCertificateKeyFile /path/to/certs/hellfish.test.key
</VirtualHost>

```
