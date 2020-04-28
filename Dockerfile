FROM openjdk:11
RUN mkdir /usr/local/workspace
COPY ./out/artifacts/Algorithms_jar/Algorithms.jar /usr/local/workspace
RUN ls /usr/local/workspace
RUN java -jar /usr/local/workspace/Algorithms.jar
