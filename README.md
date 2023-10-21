# Http proxy tool

This project is intended to be a student version of the burp sutie tool.


## Configuration
- Java 17 Temurin SDK
- Spring Boot version 3.1.4

Download this repository and run the application.
Next you need to set up this server as a proxy for your browser. To do this you need to
set the following values in the browser proxy configuration
- Host: 127.0.0.1
- Port: 8080

At this point, the server should redirect your connection to the example website and print the data from this website to the console.
Note that for now it will only work with a website without SSL, for example
http://www.columbia.edu/~fdc/sample.html