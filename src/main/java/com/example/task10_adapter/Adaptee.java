package com.example.task10_adapter;

import java.util.ArrayList;

public interface Adaptee<E> {
    String toString(ArrayList<E> list); // Преобразование в строку
    void insert(E value);               // Вставка элемента
    boolean delete(E value);            // Удаление элемента
    int find(E value);                  // Поиск элемента
}
