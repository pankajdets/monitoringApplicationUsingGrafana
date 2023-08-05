FROM openjdk:17

ENV JAR_FILE employee-management-system-*.jar
ENV LANG C.UTF-8
ENV TZ=Asia/Kolkata
ENV CONFIG config

#Create Work Directory
RUN mkdir  /usr/share/projectEmployeeManagementSystem
#Set location of Project
ENV PROJECT_HOME /usr/share/projectEmployeeManagementSystem
RUN mkdir -p /opt/mount/config


EXPOSE 8080

#COPY your jar to container
COPY /monitoringApplicationUsingGrafana/target/$JAR_FILE $PROJECT_HOME/

#Copy Springboot application config to home directory
COPY $CONFIG $PROJECT_HOME/
COPY $CONFIG/application.yml /opt/mount/config/


#Launch the application
WORKDIR $PROJECT_HOME

ENTRYPOINT ["sh", "-c"]

CMD ["java ${JVM} -jar $PROJECT_HOME/$JAR_FILE --spring.config.location=/opt/mount/config/application.yml"]
