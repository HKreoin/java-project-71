setup:
	./gradlew wrapper --gradle-version 8.5

run-dist:
	./build/install/app/bin/app

build:
	./gradlew clean build

run:
	./gradlew run

build-run: build run

report:
	./gradlew jacocoTestReport

test:
	./gradlew test

lint:
	./gradlew checkstyleMain

.PHONY: build
