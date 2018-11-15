#spring-boot-data-mongo-year-test

Simple Test project to show 
```
org.bson.codecs.configuration.CodecConfigurationException: Can't find a codec for class java.time.Year.
```

## How to run
Just run ```mvn clean test``` to run all tests. ```aFoobarRepositoryTest``` triggers the Exception.
