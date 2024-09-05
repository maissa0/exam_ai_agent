FROM eclipse-temurin:17-jdk-alpine as builder

# Authors
LABEL author="Mohamad Khalil BELDI <mohamadkhalil.beldi@esprit.tn>"
LABEL maintainer="Houssem Tebai <houssem.tebai@esprit.tn>"

# Workdir
WORKDIR /opt/app

# Copy Maven Wrapper
COPY .mvn/ .mvn

# Copy Maven Wrapper script && pom.xml
COPY mvnw pom.xml ./

# Fix mvnw &
RUN dos2unix mvnw && \
    chmod u+x mvnw

# Create target/dependency directory
RUN mkdir -p target/dependency

# Copy artifact
COPY ./target/*.jar ./target/api-gateway.jar

# Change workdir
WORKDIR /opt/app/target/dependency

# Unpacking the jar file
RUN jar -xf ../api-gateway.jar

# Base image
FROM eclipse-temurin:17-jre-alpine as runtime

# Authors
LABEL author="Mohamad Khalil BELDI <mohamadkhalil.beldi@esprit.tn>"
LABEL maintainer="Houssem Tebai <houssem.tebai@esprit.tn>"

# Create user
RUN addgroup vacataire_gateway ; adduser  --ingroup vacataire_gateway --disabled-password vacataire_gateway

# Use user
USER vacataire_gateway

# Path to unpacked jar from builder image
ARG DEPENDENCY=/opt/app/target/dependency

# Copy unpacked jar from builder image
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /opt/app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /opt/app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /opt/app

# Run vacaaire_api-gateway when container starts
ENTRYPOINT ["java","-cp","opt/app:opt/app/lib/*","com.esprit.dsi.ApigatewayApplication"]