package com.example.memlibrary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView; // 1. ЗАМІНИЛИ ImageView на MediaView

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private Button playButton; // Зв'язок із кнопкою "Дивитись трейлер" із FXML.

    @FXML
    private MediaView mainMediaView; // Наш головний "екран", на якому показується картинка відео.

    @FXML
    private TextArea descriptionArea; // Текстове поле, куди виводяться назва, рейтинг та твоя думка.

    @FXML
    private VBox iconContainer; // Вертикальна панель ліворуч, куди код автоматично додаватиме кнопки фільмів.

    private MediaPlayer mediaPlayer; // Об'єкт-плеєр. Це "динамік та касетник" програми. Сам керує пуском/паузою.
    private final List<MediaItem> items = new ArrayList<>(); // Наш список (база даних), де зберігаються всі 10 фільмів.
    private MediaItem currentItem; // Змінна-вказівник, яка запам'ятовує, який саме фільм користувач вибрав прямо зараз.
    @FXML
    public void initialize() {
        createItems(); // Щойно програма ввімкнулася — наповнюємо список фільмами.
        createIcons(); // Одразу після цього створюємо кнопки для кожного фільму в лівій панелі.
    }
    @FXML
    public void handlePause(ActionEvent event) {
        if (mediaPlayer != null) { // Перевірка: якщо відео взагалі ще не запускали, то й павзи не буде.

            // Якщо відео зараз активне (грає)
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause(); // Наказуємо плеєру зупинити кадр
                descriptionArea.setText(descriptionArea.getText() + "\n"); // Додаємо маркер у текст
            }
            // Якщо воно вже було на паузі
            else if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
                mediaPlayer.play(); // Знімаємо з паузи, трейлер грає далі
                showItem(currentItem); // Перемальовуємо текст в TextArea, щоб прибрати напис "[Відео призупинено]"
            }
        }
    }

    private void createItems() {
        items.add(new MediaItem(
                "Transformers: The Last Knight",
                "/media/transformers.mp4",
                5.2,
                "Моя думка: Фільм має реально хороші спецефекти, хоча на думку критиків це такий собі фільм в порівнянні з іншими частинами але це мій найулюбленіший із всієї серії. Моя оцінка 7.5/10"
        ));
        items.add(new MediaItem(
                "Star Wars 3",
                "/media/SW.mp4",
                7.7,
                "Моя думка: Цей фільм мабуть має один з найбільших сюжетних поворотів у всій кіноіндустрії, Енакін Скайвокер, міг стати наймогутнішим джедаєм але, але це ви вже дізнаєтесь переглянувши фільм. Моя оцінка 10/10"
        ));
        items.add(new MediaItem(
                "Spider Man 3",
                "/media/SpiderMan3.mp4",
                8,
                "Моя думка: сюжет досить цікавий,фінал має досить несподіваний. Фільм один з небагатьох що має погану кінцівку.  Моя оцінка 8,5/10"
        ));
        items.add(new MediaItem(
                "Avengers 3",
                "/media/Avengers3.mp4",
                8.4,
                "Моя думка: серія фільміф месники це така серія в якій щоб поглинути в сюжет треба обов'язково передивитися кожну сюжетну лінію персонажа. Сам фільм зрооблений якісно особливо вражає CGI.  Моя оцінка 8/10"
        ));
        items.add(new MediaItem(
                "Avengers 4",
                "/media/Avengers4.mp4",
                8.4,
                "Моя думка: Marvel як завжди на висоті, в цьму фільми сподобалось намагання представити машину часу максимально науково хоч це здається неможливо.  Моя оцінка 8/10"
        ));
        items.add(new MediaItem(
                "Harry Potter 5 ",
                "/media/HarryPotter.mp4",
                7.5,
                "Моя думка: cюжет дуже цікавий, з фільмом можна провести багато парелелей з нашою школою. Цікавий факт з кожним фільмом заставка на початку Ворнер Бразерс стає все темнішою і темнішою як і події частин.  Моя оцінка 7/10"
        ));
        items.add(new MediaItem(
                "Guardians of the Galaxy ",
                "/media/Guardians.mp4",
                7.6,
                "Моя думка: Фільм чудово піднімає настрій і тримає увагу до кінця, також фільм має крутий сасундтрек.  Моя оцінка 9.5/10"
        ));
        items.add(new MediaItem(
                "Matrix ",
                "/media/Matrix.mp4",
                7.3,
                "Моя думка: Можливо ми живемо у матриці? Ні? А чим тоді доведете? От і думайте тепер.  Моя оцінка 9.5/10"
        ));
        items.add(new MediaItem(
                "DrStrange ",
                "/media/DrS.mp4",
                6.8,
                "Моя думка: фільм вражає своєю похмурою атмосферою хоррору. Сюжет досить заплутаний, звичайні смертні не зрозуміють.  Моя оцінка 6.9/10"
        ));
        items.add(new MediaItem(
                "Iron Man ",
                "/media/IronMan.mp4",
                7.9,
                "Моя думка: ТОНІ СТАРК ЗІБРАВ АТОМНИЙ РЕАКТОР СИДЯЧИ В ПЕЧЕРІ   Моя оцінка 7.8/10"
        ));


    }

    private void createIcons() {
        for (MediaItem item : items) { // Цикл "for-each": беремо по черзі кожен фільм із нашого списку
            Button button = new Button(item.getTitle()); // Створюємо нову JavaFX кнопку і пишемо на ній назву фільму
            button.getStyleClass().add("menu-button"); // Підключаємо до неї стиль дизайну із CSS файлу

            button.setPrefSize(170, 60); // Виставляємо розміри: 170 пікселів у ширину, 60 у висоту
            button.setWrapText(true); // Дозволяємо переносити довгі назви (наприклад, "Guardians of the Galaxy") на новий рядок

            // Головне: кажемо кнопці, що при кліку на неї треба викликати метод showItem() саме для ЦЬОГО фільму
            button.setOnAction(event -> showItem(item));

            iconContainer.getChildren().add(button); // Фізично додаємо готову кнопку всередину лівої панелі VBox
        }
    }

    private void showItem(MediaItem item) {
        // Якщо якесь відео вже грало — зупиняємо його
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        currentItem = item;

        // Формуємо текст для виведення на екран
        String info = "Фільм: " + item.getTitle() + "\n" +
                "Рейтинг IMDb: " + item.getImdbRating() + " / 10\n" +
                "\n" +
                " " + item.getMyOpinion();

        descriptionArea.setText(info);
    }

    @FXML
    public void playVideo(ActionEvent event) { // Метод має називатися playVideo, як у FXML
        if (currentItem == null) {
            descriptionArea.setText(" Cпочатку оберіть фільм зі списку ліворуч!");
            return;
        }

        try {
            // Якщо плеєр уже був ініціалізований раніше — зупиняємо його повністю
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }

            // Завантажуємо відеофайл із папки resources/media/
            String videoUrl = getClass().getResource(currentItem.getVideoPath()).toExternalForm();
            Media media = new Media(videoUrl);

            mediaPlayer = new MediaPlayer(media);

            // Передаємо плеєр на наш екран MediaView
            mainMediaView.setMediaPlayer(mediaPlayer);

            // Запускаємо відтворення
            mediaPlayer.play();

        } catch (Exception e) {
            e.printStackTrace();
            descriptionArea.setText("Помилка відтворення! Перевірте, чи файл лежить у resources/media/transformers.mp4");
        }
    }
}