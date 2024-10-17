#################
# Build the  JAVA APP #

FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/todo-management-for-mavenrepo-1.0.1-SNAPSHOT.jar todo-management.jar
ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /todo-management.jar" ]