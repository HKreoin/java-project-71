test:
	make -C app test

lint:
	make -C app lint

setup:
	make -C app setup

build-run:
	make -C app build-run

report:
	make -C app report

build:
	make -C app build

.PHONY: build
