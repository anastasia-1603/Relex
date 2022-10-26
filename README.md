# RESTfull API service для обработки последовательности чисел.
### Описание:
#### Программа позволяет считать массив целых чисел из текстового файла, обработать и выдать необходимые результаты.
---
### Использование:

#### Информация о файле передается в теле запроса в виде json.
#### Тип запрашиваемой операции может передаваться как параметр в json или определяться из URL запроса.
---
#### Примеры: #### 

**URL: localhost:8080/file/get_max_value**
Body:
```json
{
    "file_path" : "C:/10m.txt"
}
```
Response:
```json
{
    "max_value": 49999978
}
```
**URL: localhost:8080/file/get_min_value**
Body:
```json
{
    "file_path" : "C:/10m.txt"
}
```
Response:
```json
{
    "min_value": -49999996
}
```
**URL: localhost:8080/file/get_mean_value**
Body:
```json
{
    "file_path" : "C:/10m.txt"
}
```
Response:
```json
{
    "mean_value": 7364.418442641844
}
```
**URL: localhost:8080/file/get_longest_increasing_sequence**
Body:
```json
{
    "file_path" : "C:/10m.txt"
}
```
Response:
```json
{
    "increasing_sequence": [
        [
            -48190694,
            -47725447,
            -43038241,
            -20190291,
            -17190728,
            -6172572,
            8475960,
            25205909,
            48332507,
            48676185
        ]
    ]
}
```
**URL: localhost:8080/file/get_longest_decreasing_sequence**
Body:
```json
{
    "file_path" : "C:/10m.txt"
}
```
Response:
```json
{
    "decreasing_sequence": [
        [
            47689379,
            42381213,
            30043880,
            12102356,
            -4774057,
            -5157723,
            -11217378,
            -23005285,
            -23016933,
            -39209115,
            -49148762
        ]
    ]
}
```
**URL: localhost:8080/file/get_longest_increasing_sequence**
Body:
```json
{
    "file_path" : "C:/file.txt"
}
file.txt содержит массив {1, 2, 1, 3, 7, 1, 2, 3}
```
Response:
```json
{
    "increasing_sequence": [
        [
            1,
            3,
            7
        ],
        [
            1,
            2,
            3
        ]
    ]
}
```
**URL: localhost:8080/file/get_longest_decreasing_sequence**
Body:
```json
{
    "file_path" : "C:/file.txt"
}
file.txt содержит массив {1, 2, 1, 3, 7, 1, 2, 3}
```
Response:
```json
{
    "decreasing_sequence": [
        [
            2,
            1
        ],
        [
            7,
            1
        ]
    ]
}
```
**URL: localhost:8080/file/**
Body:
```json
{
    "file_path" : "C:/10m.txt",
    "operation" : "get_max_value"
}
```
Response:
```json
{
    "max_value": 49999978
}
```
