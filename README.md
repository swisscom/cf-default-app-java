# CF Default App Java

The default Java app that will be pushed into the Swisscom Application cloud if no source code is provided.

Based on [Spark](http://sparkjava.com)

## Run locally

1. Install the [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
1. Install [Gradle](https://gradle.org/gradle-download/)
1. Run `gradle build`
1. Run `java -jar build/libs/cf-default-app-java-1.0.0.jar`
1. Visit [http://localhost:4567](http://localhost:4567)

## Run in the cloud

1. Install the [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
1. Install [Gradle](https://gradle.org/gradle-download/)
1. Install the [cf CLI](https://github.com/cloudfoundry/cli#downloads)
1. Run `gradle build`
1. Run `cf push -p build/libs/cf-default-app-java-1.0.0.jar --random-route`
1. Visit the given URL

## Create ZIP

1. Install the [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
1. Install [Gradle](https://gradle.org/gradle-download/)
1. Run `gradle build`
1. Run `mv build/libs/cf-default-app-java-1.0.0.jar java_app.zip`
