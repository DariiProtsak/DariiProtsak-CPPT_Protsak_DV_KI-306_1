# -*- coding: cp1251 -*-
"""
Модуль для обчислення математичного виразу та роботи з файлами
"""

import os
import struct
import sys
import math

def calculate_expression(x):
    """
    Обчислює вираз y = sin(3x - 5) / ctg(2x).

    Args:
        x (float): Вхідне значення в радіанах.

    Returns:
        float: Результат обчислення виразу.
        None: У випадку помилки обчислення.
    """
    try:
        # Обчислюємо чисельник виразу: sin(3x - 5)
        numerator = math.sin(3 * x - 5)
        
        # Обчислюємо знаменник виразу: ctg(2x) = 1/tan(2x)
        denominator = 1 / math.tan(2 * x)
        
        # Перевіряємо ділення на нуль з невеликою похибкою
        if abs(denominator) < 1e-10:
            raise ZeroDivisionError("Котангенс 2x близький до нуля, неможливо обчислити вираз.")
        
        return numerator / denominator
    except ZeroDivisionError as e:
        print(f"Помилка: {e}")
        return None
    except Exception as e:
        print(f"Несподівана помилка при обчисленні: {e}")
        return None

def write_result(filename, result, mode='text'):
    """
    Записує результат у файл у текстовому або бінарному форматі.

    Args:
        filename (str): Шлях до файлу для запису.
        result (float): Числове значення для запису.
        mode (str): Режим запису:
            - 'text': запис у текстовому форматі
            - 'binary': запис у бінарному форматі
    """
    try:
        if mode == 'text':
            # Відкриваємо файл у текстовому режимі з UTF-8 кодуванням
            with open(filename, 'w', encoding="utf-8") as f:
                f.write(str(result))
        elif mode == 'binary':
            # Відкриваємо файл у бінарному режимі та записуємо число
            # у форматі з подвійною точністю (8 байт)
            with open(filename, 'wb') as f:
                f.write(struct.pack('d', result))
        else:
            raise ValueError("Невідомий режим запису.")
    except OSError as e:
        print(f"Помилка при записі у файл {filename}: {e}")

def read_result(filename, mode='text'):
    """
    Читає результат з файлу у вказаному форматі.

    Args:
        filename (str): Шлях до файлу для читання.
        mode (str): Режим читання:
            - 'text': читання з текстового файлу
            - 'binary': читання з бінарного файлу

    Returns:
        float: Прочитане значення.
        None: У випадку помилки читання.
    """
    try:
        # Перевіряємо існування файлу
        if not os.path.exists(filename):
            raise FileNotFoundError(f"Файл {filename} не знайдено.")

        if mode == 'text':
            # Читаємо та конвертуємо текстові дані
            with open(filename, 'r', encoding="utf-8") as f:
                return float(f.read().strip())
        elif mode == 'binary':
            # Читаємо бінарні дані як число з подвійною точністю
            with open(filename, 'rb') as f:
                return struct.unpack('d', f.read(8))[0]
        else:
            raise ValueError("Невідомий режим читання.")
    except FileNotFoundError as e:
        print(e)
    except ValueError as e:
        print(f"Помилка конвертації даних з файлу {filename}: {e}")
    except struct.error as e:
        print(f"Помилка читання бінарних даних з файлу {filename}: {e}")
    except OSError as e:
        print(f"Помилка доступу до файлу {filename}: {e}")
    return None

if __name__ == "__main__":
    """
    Головний блок програми.
    """
    try:
        # Отримуємо вхідні дані
        x = float(input("Введіть значення x в радіанах: "))
        
        # Обчислюємо результат
        result = calculate_expression(x)
        
        if result is not None:
            print(f"Результат обчислення: {result}")
            
            # Записуємо результат у файли різних форматів
            write_result("textRes.txt", result, mode='text')
            write_result("binRes.bin", result, mode='binary')
            
            # Читаємо та перевіряємо збережені результати
            text_result = read_result('textRes.txt', mode='text')
            bin_result = read_result('binRes.bin', mode='binary')
            
            # Виводимо прочитані результати
            if text_result is not None:
                print(f"Результат з текстового файлу: {text_result}")
            if bin_result is not None:
                print(f"Результат з бінарного файлу: {bin_result}")
    except ValueError:
        print("Помилка: Введіть коректне числове значення")
    except Exception as e:
        print(f"Виникла непередбачена помилка: {e}")
        sys.exit(1)