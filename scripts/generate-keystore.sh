#!/bin/sh

# The script will generate Certificate Authority keys and sign certificate and will import it to JKS without any prompts

echo ""
echo "#############################################################"
echo "####         Welcome to generate-keystore.sh            #####"
echo "#############################################################"

echo "Today is " `date`
echo "#############################################################"
java -version                                                "#####"
which openssl                                                "#####"
echo "#############################################################"
read -p "Enter the name of app? " file_name

keytool -genkey -v -keystore $file_name.jks -keyalg RSA -sigalg SHA256withRSA -validity 365 -keysize 2048  -alias $file_name

echo "Keystore file generated"

echo "Generating : $file_name"

echo "done."