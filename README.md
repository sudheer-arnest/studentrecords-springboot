## Docker Setup

You can mention the port you wnat to run your application inside the container  on the docker-compose.yml `- PORT=3000`

Mention which ports to map in docker-compose.yml. The left side is the port on your local machine,and the right side is the port inside the container
ports: - "3000:3000"

ALL the environment variables inside you canmanage through the yml file

Added the health checks to start the backend only after database is connected 

To Build the image and run the container `sudo docker compose up --build`

To Check the images   `sudo docker images` to check the containers `sudo docker ps`

To Stop the containers  `sudo docker stop containerId` or `sudo docker rm -f $(sudo docker ps -aq)`