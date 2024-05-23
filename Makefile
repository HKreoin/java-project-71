run-dist:
	./build/install/app/bin/app -h

run-dist1:
	./build/install/app/bin/app src/test/resources/filepath1.json src/test/resources/filepath2.json

run-dist2:
	./build/install/app/bin/app src/test/resources/filepath1.yaml src/test/resources/filepath2.yaml

run-dist3:
	./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json

run-dist4:
	./build/install/app/bin/app src/test/resources/file1.yaml src/test/resources/file2.yaml

run-dist5:
	./build/install/app/bin/app -f plain src/test/resources/file1.json src/test/resources/file2.json

run-dist6:
	./build/install/app/bin/app -f json src/test/resources/file1.yaml src/test/resources/file2.yaml

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