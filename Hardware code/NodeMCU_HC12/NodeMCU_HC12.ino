 #include<SoftwareSerial.h>
 #include <ESP8266WiFi.h>
#include <Firebase_ESP_Client.h>

//Provide the token generation process info.
#include "addons/TokenHelper.h"
//Provide the RTDB payload printing info and other helper functions.
#include "addons/RTDBHelper.h"

// Insert your network credentials
#define WIFI_SSID "ca"
#define WIFI_PASSWORD "12345678"

// Insert Firebase project API Key
#define API_KEY "AIzaSyA9Oetn1prns8CSvTueDcsoH1oSt2hxC5c"

// Insert RTDB URLefine the RTDB URL */
#define DATABASE_URL "https://lora-b60ea-default-rtdb.firebaseio.com/" 

SoftwareSerial arduino(5,4);

//Define Firebase Data object
FirebaseData fbdo;

FirebaseAuth auth;
FirebaseConfig config;
String x,y;
bool signupOK = false;

void setup(){
  Serial.begin(115200);
  arduino.begin(115200);
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to Wi-Fi");
  while (WiFi.status() != WL_CONNECTED)
  {
    Serial.print(".");
    delay(700);
  }
  Serial.println();
  Serial.print("Connected with IP: ");
  Serial.println(WiFi.localIP());
  Serial.println();
while(!arduino)
  {
    Serial.println("USB not coonected");
  }
  /* Assign the api key (required) */
  config.api_key = API_KEY;

  /* Assign the RTDB URL (required) */
  config.database_url = DATABASE_URL;

  /* Sign up */
  if (Firebase.signUp(&config, &auth, "", ""))
  {
    Serial.println("ok");
    signupOK = true;
  }
  else{
    Serial.printf("%s\n", config.signer.signupError.message.c_str());
  }

  /* Assign the callback function for the long running token generation task */
  config.token_status_callback = tokenStatusCallback; //see addons/TokenHelper.h
  
  Firebase.begin(&config, &auth);
  Firebase.reconnectWiFi(true);
}

void loop(){
  if (Firebase.ready() && signupOK  )
   {  x=arduino.readStringUntil('\n');
      y="Data AA gya Bhai";
     // Write an Float number on the database path test/float
    if (Firebase.RTDB.setInt(&fbdo, "test/",x ))
    {
      Serial.println("PASSED");
      Serial.println(x);
    }
    else {
      Serial.println("FAILED");
      Serial.println("REASON: " + fbdo.errorReason());
    }
  }
   
}
