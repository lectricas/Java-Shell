# CLI
Простой интерпретатор командной строки, поддерживающий команды:

- cat [FILE] - выводит содержимое файла на экран
- echo - выводит на экран свои аргумент
- wc [FILE] - выводит количество строк, слов и байт в файле
- pwd - выводит текущую директорию

## Арxитектура
- MainConsole внутри которого крутится бесконечный цикл, а так же лежит синглтон с env.
- Parser - там есть state machine, которая лексирует команду.
- Wc, Cat, Echo, Pwd, EnvMover - реализация линуксовых программ, а так же класс для работы с переменными.
- Разные служебные классы.

## Запуск
- ./gradlew build
- ./gradlew run