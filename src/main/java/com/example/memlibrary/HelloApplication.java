
        package com.example.memlibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

// Наш головний клас наслідується (extends) від базового класу Application.
// Це обов'язково для будь-якої графічної програми на JavaFX, щоб операційна система розуміла, що це віконний додаток.
public class HelloApplication extends Application {

    // Метод start — це головне "серце" запуску інтерфейсу. 
    // Об'єкт 'stage' (сцена/підмостки) — це саме фізичне вікно програми (з кнопками згорнути, розгорнути, закрити).
    @Override
    public void start(Stage stage) throws IOException {

        // 1. Створюємо завантажувач FXMLLoader та вказуємо йому чіткий шлях до нашого XML-файлу з дизайном.
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/trailerlibrary/hello-view.fxml"));

        // 2. Створюємо Scene (полотно) всередині вікна. 
        // fxmlLoader.load() зчитує наш FXML-код, будує за ним блоки, а цифри 800 і 650 задають початкову ширину та висоту вікна в пікселях.
        Scene scene = new Scene(fxmlLoader.load(), 800, 650);

        // 3. Встановлюємо текст, який буде відображатися на самій верхній рамці вікна програми.
        stage.setTitle("Бібліотека трейлерів моїх улюблнгих фільмів");

        // 4. Кладемо наше готове полотно (компоненти інтерфейсу) всередину вікна додатка.
        stage.setScene(scene);

        // 5. Даємо команду операційній системі фізично відобразити вікно на екрані монітора (зробити його видимим).
        stage.show();
    }

    // Вкладений клас Launcher. Він потрібен для того, щоб обійти технічні обмеження збирання JavaFX у деяких середовищах.
    public class Launcher {
        // Головний метод main, який шукає комп'ютер під час запуску програми.
        public static void main(String[] args) {
            // Ця команда дає сигнал JavaFX запустити життєвий цикл додатка і викликати метод start(), який ми розібрали вище.
            Application.launch(HelloApplication.class, args);
        }
    }
}