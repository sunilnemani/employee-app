# Use an official Tomcat 10 base image
FROM tomcat:10.1-jdk17

# Set the location of the Tomcat webapps directory
ARG CATALINA_HOME=/usr/local/tomcat

# Copy the WAR file from the target directory to the Tomcat webapps directory
COPY target/address-1.0.war $CATALINA_HOME/webapps/

# Expose the default Tomcat port
EXPOSE 8081

# Run Tomcat
CMD ["catalina.sh", "run"]
