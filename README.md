### Hexlet tests and linter status:
[![Actions Status](https://github.com/HKreoin/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/HKreoin/java-project-71/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/d06795edcb9b6fd2ad51/maintainability)](https://codeclimate.com/github/HKreoin/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/d06795edcb9b6fd2ad51/test_coverage)](https://codeclimate.com/github/HKreoin/java-project-71/test_coverage)

## Описание
Вычислитель отличий – программа, определяющая разницу между двумя структурами данных. Это популярная задача, для решения которой существует множество онлайн-сервисов, например: http://www.jsondiff.com/. Подобный механизм используется при выводе тестов или при автоматическом отслеживании изменении в конфигурационных файлах.

## Возможности утилиты:

Поддержка разных входных форматов: yaml и json

Генерация отчета в виде plain text, stylish и json

## Инструкция по запуску

Наберите в bash следующие команды

`make build` - компиляция программы

`./build/install/app/bin/app -h` - вывод справки:

`Usage: gendiff [-hV] [-f=format] filepath1 filepath2`

`Compares two configuration files and shows a difference.`

`      filepath1         path to first file`
      
`      filepath2         path to second file`
      
 ` -f, --format=format   output format [default: stylish]`

 ` -h, --help            Show this help message and exit.`
  
 ` -V, --version         Print version information and exit.`

## Пример работы программы
[![asciicast](https://asciinema.org/a/W3UY5qbOCIj5ScaYeJPYOF8mf.svg)](https://asciinema.org/a/W3UY5qbOCIj5ScaYeJPYOF8mf)
