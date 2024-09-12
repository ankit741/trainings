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

