package com.example.task10_adapter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class MainController {

    @FXML
    private ListView<String> demolist;

    @FXML
    private TextField inputField;

    @FXML
    private Button insertButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button findButton;

    private Adapter demo = new Adapter(); // Создаём объект адаптера

    @FXML
    public void initialize() {
        // Обработчик кнопки "Вставка"
        insertButton.setOnAction(event -> {
            try {
                long value = Long.parseLong(inputField.getText());
                demo.insert(value); // Вставляем значение через адаптер
                updateListView();  // Обновляем ListView
                inputField.clear();
            } catch (NumberFormatException e) {
                showAlert("Ошибка", "Введите корректное число!");
            }
        });

        // Обработчик кнопки "Удаление"
        removeButton.setOnAction(event -> {
            try {
                long value = Long.parseLong(inputField.getText());
                if (demo.delete(value)) { // Удаляем значение через адаптер
                    updateListView();    // Обновляем ListView
                } else {
                    showAlert("Ошибка", "Элемент не найден!");
                }
                inputField.clear();
            } catch (NumberFormatException e) {
                showAlert("Ошибка", "Введите корректное число!");
            }
        });

        // Обработчик кнопки "Поиск"
        findButton.setOnAction(event -> {
            try {
                long value = Long.parseLong(inputField.getText());
                int index = demo.find(value); // Поиск элемента через адаптер
                if (index < demo.display().size()) {
                    showAlert("Результат поиска", "Элемент найден на позиции: " + index);
                } else {
                    showAlert("Результат поиска", "Элемент не найден!");
                }
                inputField.clear();
            } catch (NumberFormatException e) {
                showAlert("Ошибка", "Введите корректное число!");
            }
        });
    }

    // Обновление содержимого ListView
    private void updateListView() {
        demolist.getItems().clear();
        demolist.getItems().addAll(demo.display());
    }

    // Показ всплывающего сообщения
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}