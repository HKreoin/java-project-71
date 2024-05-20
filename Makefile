run-dist:
	./build/install/app/bin/app

run-dist1:
	./build/install/app/bin/app src/test/resources/filepath1.json src/test/resources/filepath2.json

run-dist2:
	./build/install/app/bin/app src/test/resources/filepath1.yaml src/test/resources/filepath2.yaml

build:
	./gradlew clean build

run:
	./gradlew run

build-run: build run

report:
	./gradlew jacocoTestReport

test:
	./gradlew test

linter:
	./gradlew checkstyleMain

.PHONY: build