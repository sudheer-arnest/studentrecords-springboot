FROM eclipse-temurin:21-jdk

WORKDIR /app

RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

COPY target/studentrecords-0.0.1-SNAPSHOT.jar app.jar

ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

EXPOSE ${APP_PORT:-8080}

ENTRYPOINT ["/wait-for-it.sh", "mysql:3306", "--timeout=40", "--", "java", "-jar", "app.jar", "--server.port=${APP_PORT:-8080}"]
