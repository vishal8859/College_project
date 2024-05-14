#include<SoftwareSerial.h>
#define echo 5
#define trig 6
SoftwareSerial HC12 (8,9);
String data ="";
int t;
int d;
void setup() {
 Serial.begin(9600);
 HC12.begin(9600);
 pinMode(echo, INPUT);
 pinMode(trig, OUTPUT);

}

void loop() {
  d=distance();
  if(d<10)
  {
    data = 3;
  }
  else
  {
    data =2;
  }
  HC12.println(data);
  delay(100);
}
int distance()
{
  digitalWrite(trig,LOW);
  delayMicroseconds(10);
  digitalWrite(trig,HIGH);
  delayMicroseconds(5);
  t=pulseIn(echo,HIGH);
  Serial.println(t*0.017);
  return (t*0.017);
}
