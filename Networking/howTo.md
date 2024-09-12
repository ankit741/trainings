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

Note: An alternative way to generate the private key and CSR in one command:

``` Openssl req -new -newkey rsa:3072 -nodes -out code_signing_csr.txt -keyout code_signing_key.key -subj “/C=US/ST=California/L=San Jose/O=GPI Holding LLC/CN=GPI Holding LLC1```

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



Creating a Self-Signed Certificate
A self-signed certificate is a certificate that’s signed with its own private key. It can be used to encrypt data just as well as CA-signed certificates, but our users will be shown a warning that says the certificate isn’t trusted.

Let’s create a self-signed certificate (domain.crt) with our existing private key and CSR:


ADVERTISING


openssl x509 -signkey domain.key -in domain.csr -req -days 365 -out domain.crt
Copy
The -days option specifies the number of days that the certificate will be valid.

We can create a self-signed certificate with just a private key:

openssl req -key domain.key -new -x509 -days 365 -out domain.crt
Copy
This command will create a temporary CSR. We still have the CSR information prompt, of course.

We can even create a private key and a self-signed certificate with just a single command:

openssl req -newkey rsa:2048 -keyout domain.key -x509 -days 365 -out domain.crt
Copy
5. Creating a CA-Signed Certificate With Our Own CA
We can be our own certificate authority (CA) by creating a self-signed root CA certificate, and then installing it as a trusted certificate in the local browser.

5.1. Create a Self-Signed Root CA
Let’s create a private key (rootCA.key) and a self-signed root CA certificate (rootCA.crt) from the command line:

openssl req -x509 -sha256 -days 1825 -newkey rsa:2048 -keyout rootCA.key -out rootCA.crt
Copy
5.2. Sign Our CSR With Root CA
We can sign our CSR (domain.csr) with the root CA certificate and its private key:

openssl x509 -req -CA rootCA.crt -CAkey rootCA.key -in domain.csr -out domain.crt -days 365 -CAcreateserial
Copy
As a result, the CA-signed certificate will be in the domain.crt file. This would result in a working certificate, but browsers would still flag them. This happens because of the changes to the X.509 certificates and the addition of the SAN extension.


5.3. SAN Extension
X.509 certificates need information about the domain for which this particular certificate is issued. For example, the certificate can be valid but used in a different domain than it was issued for.  Previously, we could do this with the CommonName of the certificate request. However, after the global adoption of the SAN extension, all domain names should be included in the subjectAltName.

If we create a certificate without a correctly configured subjectAltName, we can still use it. However, browsers will flag it as insecure. This approach might be fine for development. However, using this approach at an organizational level could desensitize employees to security notifications.

To align with SAN extension standards, we need to create a configuration text file (domain.ext) with the following content:

authorityKeyIdentifier=keyid,issuer
basicConstraints=CA:FALSE
subjectAltName = @alt_names
[alt_names]
DNS.1 = domain
Copy
The “DNS.1” field should be the domain of our website.

Then, we can slightly modify our previous command and add the information about the extension file:

openssl x509 -req -CA rootCA.crt -CAkey rootCA.key -in domain.csr -out domain.crt -days 365 -CAcreateserial -extfile domain.ext
Copy
Now, our certificate meets all the SAN requirements and works correctly. This process requires an additional step, and openssl doesn’t provide a prompt for this information, so we must create a separate extension file. However, SAN makes the certificates more secure. Also, it allows the definition of several domains or IP addresses and we can use a single certificate across multiple domains.

6. View Certificates
We can use the openssl command to view the contents of our certificate in plain text:

openssl x509 -text -noout -in domain.crt
