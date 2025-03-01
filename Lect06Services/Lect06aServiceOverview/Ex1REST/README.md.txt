./gradlew clean bootJar

jar tf build/libs/your-app.jar | grep MANIFEST.MF

docker-compose build app

docker-compose up

docker run --rm -it --entrypoint sh app
java -jar /app.jar