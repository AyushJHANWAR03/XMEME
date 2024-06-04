This file can be used as a template for initializing and running spring projects.

What's included: 
1. Gradle file created from start.spring.io
2. Plugins for Spotbugs, Checkstyle and Jacoco included
3. Other dependencies like Mongo, MySql and redis.
4. Dockerfile to start mongo server and run the spring boot application within.

About the Project :
XMeme is a simple backend web application where users can post and see memes.

- Created a Backend Server using Spring template with the REST API handlers.
- Implemented support for POST API that can be used to post Memes.
- Implemented support for GET API that can be used to fetch the 100 newest memes posted, including these fields - name, caption and image URLs.
- Implemented support for GET API to fetch individual Memes using Meme Id.
- Used MongoDB to store the Meme related fields and extract them.
- Handled incorrect requests and used appropriate HTTP Response codes for error scenarios.
- Tested the functionality and wrote code with clear comments and documentation.
- Wrote modular code following MVCS layering architecture.

Usage - 

1. To build the repository - 

From the repository root, 

1. run `./gradlew build test`run the build
2. run `./gradlew bootjar` to create executable jar. The jar will be located inside build directories.

To run inside docker container, use below commands

To build docker image, use the command below - `docker build -t your_tag_name  .`

To run the generated container, use this command - `docker run -p8080:8080 your_tag_name`. This will run the server on 8080 port.. You can change the ports as per your needs. 

