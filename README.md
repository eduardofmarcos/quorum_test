
# quorum-test
### Basic Information to run the application

This project uses Quarkus, the Supersonic Subatomic Java Framework.

This project is designed for the Quorum.us admission process.

## Running the application in dev mode

Be sure to have JDK version 21 installed before running the project.

If JDK is not installed, you can download and install it by following the instructions at:
https://sdkman.io/

You can check your JDK version by running the following command in the terminal:
```shell script
java -version
```

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

./mvnw is a wrapper, and it does NOT require Maven to be globally installed.

> **_NOTE:_**  The app is listening on  <http://localhost:8080/> (will redirect to swagger)

> **_NOTE:_**  Legislators path - related to question 1 of the test-  <http://localhost:8080/legislators/summary>.

> **_NOTE:_**  Bills path - related to question 2 of the test-  <http://localhost:8080/bills/summary>.

___________________________________________________________________________________________________________
### Extra project information
## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quorum-test-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
