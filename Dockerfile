FROM gradle:7.2.0-jdk11 as build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle testJar -x test

FROM openjdk:11

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/large-scale-testng-1.0-SNAPSHOT-alltests.jar /app/tests.jar

WORKDIR /app

ENV TEST=random.name.tests.set9.nine.Test10.secondTest
ENV TIMEOUT=3000

CMD java -cp tests.jar -ea -Dtest.timeout.max=${TIMEOUT} -Dtestng.dtd.http=true org.testng.TestNG -methods ${TEST}
