FROM ubuntu:latest

# Install Java 17
RUN apt-get update \
    && apt-get install -y openjdk-17-jdk \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Set JAVA_HOME environment variable
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

# Set environment variables for Maven installation
ENV MAVEN_VERSION=3.8.4
ENV MAVEN_HOME=/usr/share/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}

# Install Maven and other required tools
RUN apt-get update \
    && apt-get install -y maven \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

ENV JAR_FILE monitoringApplicationUsingGrafana-*.jar
ENV LANG C.UTF-8
ENV TZ=Asia/Kolkata
ENV CONFIG config

EXPOSE 8080

RUN mkdir /monitoringApplicationUsingGrafana
COPY . /monitoringApplicationUsingGrafana
WORKDIR /monitoringApplicationUsingGrafana

RUN mvn clean install

CMD ["java -jar /target/monitoringApplicationUsingGrafana-*.jar"]
