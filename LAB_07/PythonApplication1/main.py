# -*- coding: cp1251 -*-

import matrix_module

# Запитуємо у користувача розмір матриці та символ-заповнювач
rows_num = int(input("Введіть розмір квадратної матриці: "))
filler = input("Введіть символ-заповнювач: ")

# Викликаємо функцію для виведення верхнього правого трикутника
matrix_module.print_upper_right_triangle(rows_num, filler)
