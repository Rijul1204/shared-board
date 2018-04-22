# shared-board
Shared drawing board

# How to run 

You need to run rabbit mq message broker first. Run following commands first 

`docker run -d --name rabbitmq -p 61613:61613 -p 5672:5672 -p 15672:15672 itzg/rabbitmq-stomp`

After that, please follow next steps : 

Run `docker pull rijul1204/shared-board`

Run `docker container run -p 8080:8080 rijul1204/shared-board`

Go to `http://localhost:8086/shared-board`



# Memo 

This project is just started. Currently it supports only basic drawing and broadcast to all. I have some plans 
for this project to proceed further. If anyone is interested to contribute, feel free to knock me or create an issue. 

