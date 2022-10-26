Найденные значения:
1. Максимальное число в файле: 49999978
2. Минимальное число в файле: -49999996
3. Медиана: 25216.0
4. Среднее арифметическое значение: 7364.418442641844
5. Самая длинная последовательность идущих подряд чисел, которая увеличивается:
    -48190694, -47725447, -43038241, -20190291, -17190728, -6172572, 8475960, 25205909, 48332507, 48676185
6. Самая длинная последовательность идущих подряд чисел, которая уменьшается:
    47689379, 42381213, 30043880, 12102356, -4774057, -5157723, -11217378, -23005285, -23016933, -39209115, -49148762

Примеры:

URL: localhost:8080/file/get_max_value

Body:

{
    "file_path" : "C:/10m.txt"
}
Response:

{
    "max_value": 49999978
}

URL: localhost:8080/file/get_min_value

Body:

{
    "file_path" : "C:/10m.txt"
}
Response:

{
    "min_value": -49999996
}

URL: localhost:8080/file/get_median_value

Body:

{
    "file_path" : "C:/10m.txt"
}

Response:

{
    "median_value": 25216.0
}

URL: localhost:8080/file/get_mean_value

Body:

{
    "file_path" : "C:/10m.txt"
}

Response:

{
    "mean_value": 7364.418442641844
}


URL: localhost:8080/file/get_longest_increasing_sequence

Body:

{
    "file_path" : "C:/10m.txt"
}
Response:

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
URL: localhost:8080/file/get_longest_decreasing_sequence

Body:

{
    "file_path" : "C:/10m.txt"
}
Response:

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
URL: localhost:8080/file/get_longest_increasing_sequence

Body:

{
    "file_path" : "C:/file.txt"
}
file.txt содержит массив {1, 2, 1, 3, 7, 1, 2, 3}

Response:

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
URL: localhost:8080/file/get_longest_decreasing_sequence

Body:

{
    "file_path" : "C:/file.txt"
}
file.txt содержит массив {1, 2, 1, 3, 7, 1, 2, 3}

Response:

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
URL: localhost:8080/file/

Body:

{
    "file_path" : "C:/10m.txt",
    "operation" : "get_max_value"
}
Response:

{
    "max_value": 49999978
}
