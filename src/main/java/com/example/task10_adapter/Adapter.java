package com.example.task10_adapter;

import java.util.ArrayList;
import java.util.Arrays;

public class Adapter implements Adaptee<Long> {
    private OrdArray array; // Особая структура данных

    public Adapter() {
        array = new OrdArray(1000); // Создание OrdArray с максимальным размером
    }

    // Преобразование элементов структуры данных в строку
    @Override
    public String toString(ArrayList<Long> list) {
        return String.join(" ", list.toString());
    }

    // Вставка элемента
    @Override
    public void insert(Long value) {
        array.insert(value);
    }

    // Удаление элемента
    @Override
    public boolean delete(Long value) {
        return array.delete(value);
    }

    // Поиск элемента
    @Override
    public int find(Long value) {
        return array.find(value);
    }

    public ArrayList<String> display() {
        String[] subStr = array.display().split(" "); // Разделяем строку на элементы
        ArrayList<String> result = new ArrayList<>();
        for (String item : subStr) {
            if (!item.trim().isEmpty()) { // Убираем пустые строки
                result.add(item);
            }
        }
        return result;
    }
}