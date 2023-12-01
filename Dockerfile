# Base image with Maven and JDK 17
FROM --platform=linux/amd64 maven:3.9.0-eclipse-temurin-17

# Google Chrome installation
#ARG CHROME_VERSION
RUN apt-get update -qqy \
    && apt-get -qqy install gpg unzip curl \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update -qqy \
    && if [ -z "$CHROME_VERSION" ]; then \
         apt-get -qqy install google-chrome-stable; \
       else \
         apt-get -qqy install google-chrome-stable=$CHROME_VERSION; \
       fi \
    && rm /etc/apt/sources.list.d/google-chrome.list \
    && rm -rf /var/lib/apt/lists/* /var/cache/apt/* \
    && sed -i 's/"$HERE\/chrome"/"$HERE\/chrome" --no-sandbox/g' /opt/google/chrome/google-chrome


# ChromeDriver installation
RUN CHROME_DRIVER_VERSION=$(curl -sS https://chromedriver.storage.googleapis.com/LATEST_RELEASE) \
    && wget -q -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip \
    && unzip /tmp/chromedriver.zip -d /opt \
    && rm /tmp/chromedriver.zip \
    && mv /opt/chromedriver /opt/chromedriver-$CHROME_DRIVER_VERSION \
    && chmod 755 /opt/chromedriver-$CHROME_DRIVER_VERSION \
    && ln -s /opt/chromedriver-$CHROME_DRIVER_VERSION /usr/bin/chromedriver


# Expose port for the application
EXPOSE 8080

COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]