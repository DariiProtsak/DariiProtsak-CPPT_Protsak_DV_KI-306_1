# -*- coding: cp1251 -*-
"""
������ ��� ���������� ������������� ������ �� ������ � �������
"""

import os
import struct
import sys
import math

def calculate_expression(x):
    """
    �������� ����� y = sin(3x - 5) / ctg(2x).

    Args:
        x (float): ������ �������� � �������.

    Returns:
        float: ��������� ���������� ������.
        None: � ������� ������� ����������.
    """
    try:
        # ���������� ��������� ������: sin(3x - 5)
        numerator = math.sin(3 * x - 5)
        
        # ���������� ��������� ������: ctg(2x) = 1/tan(2x)
        denominator = 1 / math.tan(2 * x)
        
        # ���������� ������ �� ���� � ��������� ��������
        if abs(denominator) < 1e-10:
            raise ZeroDivisionError("��������� 2x �������� �� ����, ��������� ��������� �����.")
        
        return numerator / denominator
    except ZeroDivisionError as e:
        print(f"�������: {e}")
        return None
    except Exception as e:
        print(f"���������� ������� ��� ���������: {e}")
        return None

def write_result(filename, result, mode='text'):
    """
    ������ ��������� � ���� � ���������� ��� �������� ������.

    Args:
        filename (str): ���� �� ����� ��� ������.
        result (float): ������� �������� ��� ������.
        mode (str): ����� ������:
            - 'text': ����� � ���������� ������
            - 'binary': ����� � �������� ������
    """
    try:
        if mode == 'text':
            # ³�������� ���� � ���������� ����� � UTF-8 ����������
            with open(filename, 'w', encoding="utf-8") as f:
                f.write(str(result))
        elif mode == 'binary':
            # ³�������� ���� � �������� ����� �� �������� �����
            # � ������ � �������� ������� (8 ����)
            with open(filename, 'wb') as f:
                f.write(struct.pack('d', result))
        else:
            raise ValueError("�������� ����� ������.")
    except OSError as e:
        print(f"������� ��� ����� � ���� {filename}: {e}")

def read_result(filename, mode='text'):
    """
    ���� ��������� � ����� � ��������� ������.

    Args:
        filename (str): ���� �� ����� ��� �������.
        mode (str): ����� �������:
            - 'text': ������� � ���������� �����
            - 'binary': ������� � �������� �����

    Returns:
        float: ��������� ��������.
        None: � ������� ������� �������.
    """
    try:
        # ���������� ��������� �����
        if not os.path.exists(filename):
            raise FileNotFoundError(f"���� {filename} �� ��������.")

        if mode == 'text':
            # ������ �� ���������� ������� ���
            with open(filename, 'r', encoding="utf-8") as f:
                return float(f.read().strip())
        elif mode == 'binary':
            # ������ ����� ��� �� ����� � �������� �������
            with open(filename, 'rb') as f:
                return struct.unpack('d', f.read(8))[0]
        else:
            raise ValueError("�������� ����� �������.")
    except FileNotFoundError as e:
        print(e)
    except ValueError as e:
        print(f"������� ����������� ����� � ����� {filename}: {e}")
    except struct.error as e:
        print(f"������� ������� ������� ����� � ����� {filename}: {e}")
    except OSError as e:
        print(f"������� ������� �� ����� {filename}: {e}")
    return None

if __name__ == "__main__":
    """
    �������� ���� ��������.
    """
    try:
        # �������� ����� ���
        x = float(input("������ �������� x � �������: "))
        
        # ���������� ���������
        result = calculate_expression(x)
        
        if result is not None:
            print(f"��������� ����������: {result}")
            
            # �������� ��������� � ����� ����� �������
            write_result("textRes.txt", result, mode='text')
            write_result("binRes.bin", result, mode='binary')
            
            # ������ �� ���������� �������� ����������
            text_result = read_result('textRes.txt', mode='text')
            bin_result = read_result('binRes.bin', mode='binary')
            
            # �������� �������� ����������
            if text_result is not None:
                print(f"��������� � ���������� �����: {text_result}")
            if bin_result is not None:
                print(f"��������� � �������� �����: {bin_result}")
    except ValueError:
        print("�������: ������ �������� ������� ��������")
    except Exception as e:
        print(f"������� ������������� �������: {e}")
        sys.exit(1)