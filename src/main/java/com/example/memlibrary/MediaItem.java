package com.example.memlibrary;

public class MediaItem {

    // 1. Поля класу (Атрибути / Стан об'єкта)
    // Це закриті (private) змінні. Вони визначають, які саме дані зберігатиме кожен фільм.
    // Завдяки модифікатору private, ніхто ззовні не може випадково стерти або змінити ці дані.
    private String title;       // Назва фільму (наприклад, "Star Wars 3")
    private String videoPath;   // Шлях до файлу трейлера у ресурсах (наприклад, "/media/SW.mp4")
    private double imdbRating;  // Офіційний рейтинг фільму дробовим числом (наприклад, 7.7)
    private String myOpinion;   // Твоя особиста розгорнута думка/рецензія про цей фільм

    // 2. Конструктор класу
    // Це спеціальний метод, який викликається лише ОДИН раз — у момент створення фільму через "new MediaItem(...)".
    // Його завдання — взяти передані значення та розкласти їх по "поличках" (полях класу).
    public MediaItem(String title, String videoPath, double imdbRating, String myOpinion){

        // Ключове слово 'this' вказує Java, що ми записуємо дані саме у поличку ЦЬОГО конкретного об'єкта,
        // щоб не переплутати поля класу з однойменними параметрами у дужках конструктора.
        this.title = title;
        this.videoPath = videoPath;
        this.imdbRating = imdbRating;
        this.myOpinion = myOpinion;
    }

    // 3. Геттери (Getters / Методи доступу)
    // Оскільки поля закриті (private), Контролер не може написати "item.title".
    // Тому ми робимо відкриті (public) методи-геттери, які просто повертають (return) копію цих даних для читання.

    public String getTitle(){
        return title; // Дозволяє дізнатися назву фільму
    }

    public String getVideoPath(){
        return videoPath; // Дозволяє дізнатися шлях до відеофайлу
    }

    public double getImdbRating(){
        return imdbRating; // Дозволяє отримати рейтинг IMDb
    }

    public String getMyOpinion(){
        return myOpinion; // Дозволяє дістати твій відгук для TextArea
    }
}