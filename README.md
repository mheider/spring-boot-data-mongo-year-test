# spring-boot-data-mongo-year-test

## See following stackoverflow question

https://stackoverflow.com/questions/53327879/spring-boot-2-1-0-mongo-codecconfigurationexception-cant-find-a-codec-for-cl/53335981#53335981 

Simple Test project to show 
```
org.bson.codecs.configuration.CodecConfigurationException: Can't find a codec for class java.time.Year.
```

## How to run
Just run ```mvn clean test``` to run all tests. ```aFoobarRepositoryTest``` triggers the Exception.
