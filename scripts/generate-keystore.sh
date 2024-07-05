#!/bin/sh

generateKeystore() {
  echo "Please provide below information"
  read -p "File Name : " -e FILE_NAME
  read -p "CN Name : " -e CN
  read -p "Organizational Unit : " -e OU
  read -p "Organization : " -e O
  read -p "City Name : " -e CT
  read -p "State or Province :" -e S
  read -p "Country Code : " -e C
  read -p "Keystore Password (min 6 char): " -e keyPass
  
keytool -genkey -noprompt \
 -alias $CN \
 -dname "CN=$CN, OU=$OU, O=$O, L=$CT, S=$S, C=$C" \
 -keystore ${FILE_NAME}.jks \
 -storepass $keyPass \
 -keyPass $keyPass \
 -keyalg RSA \
 -sigalg SHA256withRSA \
 -validity 365 \
 -keysize 2048

 echo "" 
 echo "KeyStore ${CN}.jks has been generated"
 echo "JKS Validity : 365 days"
}


echo ""
echo "#############################################################"
echo "####         Welcome to generate-keystore.sh            #####"
echo "#############################################################"

echo "Today is " `date`
echo "#############################################################"
java -version  
which keytool                                              
which openssl                                          
echo "#############################################################"
#read -p "Enter the name of JKS file? " file_name


echo "Choose one of the following options (Enter number) - "
echo "1 - Generate JKS file"
echo "2 - Check validity of keystore"
echo "3 - a"
echo "4 - a"
echo "5 - Ia"
echo "6 - t"
echo "7 - t"
echo "99 - Exit"

while true; do 
  read -p "Option: " -e opt
    case $opt in
      "") echo "You did not choose any option, please try again"; break;;
      1) generateKeystore; break;;
      2) getValidity; break;;
      3) a; break;;
      4) a; break;;
      5) a; break;;
      6) a; break;;
      7) a; break;;
      99) echo "Exiting from scripts"; exit 0;;
      *)  echo "Invalid Option, Please choose above listed options &amp; hit Enter";;
    esac
done
