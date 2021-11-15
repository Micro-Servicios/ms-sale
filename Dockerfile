FROM azul/zulu-openjdk:11.0.10
RUN apt update

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app


ENV SERVER_PORT 8743
ENV EUREKA_URI "http://localhost:8762/eureka"

ENTRYPOINT ["java", \
            "-cp", \
            "app:app/lib/*", \
            "arquitectura.software.mssale.MsSaleApplication"]