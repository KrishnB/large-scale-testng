# Large Scale Testng tests

This is a dummy project to test large scale testng tests.

The project currently has 7000 tests, that run for a max 3000ms

## Building

```$shell
./gradlew clean build
```

### Generate tests CSV file

```$shell
./gradlew runTestsCSV
```
CSV file is generated as `tests.csv`


### Run Docker Image

```$shell
docker pull krishnanandb/large_scale_testng

docker run -t -i -e TEST='${TestName}' krishnanandb/large_scale_testng
```

