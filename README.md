Requirements for this service 
===============================

is to build a Restful endpoint that takes a URL and provides a shorter URL.
When resolved, that URL should redirect the user to the original URL.



Endpoints Used for this service
================================
note : service run at local host:4949
apikey :abc 

#POST /create
to create short url from long url 
curl request :
 curl --location --request POST 'localhost:4949/create' \
--header 'Content-Type: application/json' \
--data-raw '{
  "longUrl": "http://mina.caisdf.com/dafsadasdas/asfdaasfasdfas",
  "apiKey": "abc"
}'

# GET/{shortenURL}

to get the long url given the shorturl generated from the service 

curl request :
curl --location --request GET 'localhost:4949/kDZj6nT' \
--header 'Content-Type: application/json' \
--data-raw '{
  "longUrl": "Hello World",
  "apiKey": "abc"
}'

improvements
================================
Junit test can be added
user table to be linked with the apikey to track changes and deactivate and activate users from using the service
caching layer  can be added and another technical improvements and design changes 
