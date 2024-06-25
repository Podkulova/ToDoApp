# Použijte Maven image s JDK 21 jako základní image pro fázi build
FROM maven:3.8.8-eclipse-temurin-21-alpine AS build

# Nastavte pracovní adresář v image
WORKDIR /app

# Zkopírujte pom.xml a stažení závislostí
COPY pom.xml ./
RUN mvn dependency:go-offline

# Zkopírujte všechny zdrojové soubory do image
COPY pom.xml .

# Spusťte Maven build
RUN mvn clean package -DskipTests

# Použijte Amazon Corretto JDK 21 jako základní image pro výslednou aplikaci
FROM amazoncorretto:21-al2023-headless

# Zkopírujte buildovaný jar z fáze build do výsledného image
COPY --from=build /app/target/*.jar app.jar