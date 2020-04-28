FROM openjdk:7
COPY ./src/com/bamzy /usr/src/myapp
WORKDIR /usr/src/myapp
RUN ls
CMD ["ls", "-a"]
