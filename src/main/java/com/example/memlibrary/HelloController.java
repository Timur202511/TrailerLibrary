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
    private Button playButton; // Стару кнопку iconButton1 прибрали

    @FXML
    private MediaView mainMediaView; // ЗАМІНИЛИ ImageView на MediaView (назва має збігатися з fx:id у FXML)

    @FXML
    private TextArea descriptionArea;

    @FXML
    private VBox iconContainer;

    private MediaPlayer mediaPlayer;
    private final List<MediaItem> items = new ArrayList<>();
    private MediaItem currentItem;

    @FXML
    public void initialize() {
        createItems();
        createIcons();
    }
    @FXML
    public void handlePause(ActionEvent event) {
        // Перевіряємо, чи плеєр взагалі створений і запущений
        if (mediaPlayer != null) {
            // Якщо відео зараз відтворюється — ставимо на паузу
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
                descriptionArea.setText(descriptionArea.getText() + "\n[Відео призупинено]");
            }
            // Якщо воно вже на паузі — продовжуємо відтворення
            else if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
                mediaPlayer.play();
                // Прибираємо напис про паузу, оновлюючи опис
                showItem(currentItem);
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
                "Моя думка: сюжет досить цікавий,фінал має досить несподіваний. Фільм один з небагатьох що має погану кінцівку  Моя оцінка 8,5/10"
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
                "Моя думка: Marvel як завжди на висоті, в цьму фільми сподобалось намагання представити машину часу максимально науково хоч це здається неможливо  Моя оцінка 8/10"
        ));
        items.add(new MediaItem(
                "Harry Potter 5 ",
                "/media/HarryPotter.mp4",
                7.5,
                "Моя думка: cюжет дуже цікавий, з фільмом можна провести багато парелелей з нашою школою. Цікавий факт з кожним фільмом заставка на початку Ворнер Бразерс стає все темнішою і темнішою як і події частин  Моя оцінка 7/10"
        ));
        items.add(new MediaItem(
                "Guardians of the Galaxy ",
                "/media/Guardians.mp4",
                7.6,
                "Моя думка: Фільм чудово піднімає настрій і тримає увагу до кінця, також фільм має крутий сасундтрек  Моя оцінка 7.5/10"
        ));
        items.add(new MediaItem(
                "Matrix ",
                "/media/Matrix.mp4",
                7.3,
                "Моя думка: Можливо ми живемо у матриці? Ні? А чим тоді доведете? От і думайте тепер   Моя оцінка 9.5/10"
        ));
        items.add(new MediaItem(
                "DrStrange ",
                "/media/DrS.mp4",
                6.8,
                "Моя думка: фільм вражає своєю похмурою атмосферою хоррору. Сюжет досить заплутаний, звичайні смерині не зрозуміють   Моя оцінка 6.9/10"
        ));
        items.add(new MediaItem(
                "Iron Man ",
                "/media/IronMan.mp4",
                7.9,
                "Моя думка: ТОНІ СТАРК ЗІБРАВ АТОМНИЙ РЕАКТОР СИДЯЧИ В ПЕЧЕРІ   Моя оцінка 7.8/10"
        ));


    }

    private void createIcons(){
        for (MediaItem item : items) {
            Button button = new Button(item.getTitle());
            button.getStyleClass().add("menu-button");

            // 1. Збільшуємо ширину кнопки до 170 (щоб вона займала майже всю панель у 180px)
            button.setPrefSize(170, 60);

            // 2. Дозволяємо тексту переноситися на новий рядок, якщо назва занадто довга
            button.setWrapText(true);

            button.setOnAction(event -> showItem(item));
            iconContainer.getChildren().add(button);
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
            descriptionArea.setText("Будь ласка, спочатку оберіть фільм зі списку ліворуч!");
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