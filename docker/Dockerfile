FROM tomcat:7-jre8

RUN keytool -genkey -noprompt \
     -alias alias1 \
     -dname "CN=propellerads.net, OU=ID, O=IBM, L=Andrey, S=Afrikanov, C=RU" \
     -keyalg RSA \
     -keystore /usr/local/tomcat/conf/keystore.jks \
     -storepass password \
     -keypass password

COPY server.xml /usr/local/tomcat/conf
COPY tomcat-users.xml /usr/local/tomcat/conf
COPY teamcity-api-router.war /usr/local/tomcat/webapps

EXPOSE 8080 8443
WORKDIR $CATALINA_HOME
CMD ["catalina.sh", "run"]

