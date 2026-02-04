public class TestClass {
    public static void main(String[] args) {

        System.out.println("=== Тестирование класса Subject ===");

        try {
            Subject math = new Subject("Математика", "Иванов", "310", "лекция");
            Subject physics = new Subject("Физика", "Петров", "215", "практика");
            Subject programming = new Subject("Программирование", "Сидоров", "105", "лабораторная");

            System.out.println("Тест 1 пройден: предметы созданы успешно");
            System.out.println("Math: " + math);
            System.out.println("Physics: " + physics);
            System.out.println("Programming: " + programming);

            try {
                Subject invalid = new Subject("", "Иванов", "310", "лекция");
                System.out.println("Тест 2 не пройден: должна быть ошибка");
            } catch (IllegalArgumentException e) {
                System.out.println("Тест 2 пройден: " + e.getMessage());
            }
            try {
                Subject invalidType = new Subject("Математика", "Иванов", "310", "семинар");
                System.out.println("Тест 3 не пройден: должна быть ошибка типа");
            } catch (IllegalArgumentException e) {
                System.out.println("Тест 3 пройден: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Ошибка при тестировании: " + e.getMessage());
        }
    }
}
