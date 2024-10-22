# -*- coding: cp1251 -*-
import sys

def print_upper_right_triangle(rows_num, filler):
    """
    Виводить верхній правий трикутник матриці заданого розміру, використовуючи символ-заповнювач.

    :param rows_num: Кількість рядків (і стовпців) квадратної матриці.
    :param filler: Символ, який використовується для заповнення трикутника.
    :raises SystemExit: Якщо символ-заповнювач не коректний (не є одиничним символом).
    """

    # Перевірка на коректність символа-заповнювача
    if len(filler) != 1:
        if len(filler) == 0:
            print("Не введено символ-заповнювач")
            sys.exit(1)
        else:
            print("Забагато символів-заповнювачів")
            sys.exit(1)
    
    # Створення зубчастого масиву
    lst = []
    for i in range(rows_num):
        lst.append([])  # Додаємо новий рядок у зубчастий список
        for j in range(rows_num):
            if j < i:
                lst[i].append(" ")  # Додаємо пробіли перед символом-заповнювачем
            else:
                lst[i].append(filler)  # Додаємо символ-заповнювач до рядка

    # Виведення масиву
    for row in lst:
        print("".join(row))
