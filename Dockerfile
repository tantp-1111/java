# ビルド用イメージ
FROM gradle:8.7.0-jdk17 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . .
RUN ./gradlew bootJar --no-daemon

# 実行用イメージ
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
