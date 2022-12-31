FROM gcr.io/distroless/java17-debian11
COPY build/libs/harness-1.0-SNAPSHOT-all.jar /app/app.jar
COPY config.yml /app/config.yml
COPY privateKey /app/priavteKey
WORKDIR /app
CMD ["app.jar","server","config.yml"]
