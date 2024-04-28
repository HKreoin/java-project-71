run-dist:
	./build/install/app/bin/app json/file1.json json/file2.json

build:
	./gradlew clean build

run:
	./gradlew run

build-run: build run

report:
	./gradlew jacocoTestReport

test:
	./gradlew test

.PHONY: build