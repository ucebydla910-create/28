import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Shedule shedule = new Shedule();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int command = getIntInput("Введите команду: ");

            try {
                switch (command) {
                    case 1:
                        addSubject();
                        break;
                    case 2:
                        shedule.print();
                        break;
                    case 3:
                        findTeacher();
                        break;
                    case 0:
                        System.out.println("Выход из программы");
                        return;
                    default:
                        System.out.println("Неизвестная команда");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Расписание занятий ===");
        System.out.println("1. Добавить предмет");
        System.out.println("2. Показать расписание");
        System.out.println("3. Найти преподавателя");
        System.out.println("0. Выход");
    }

    private static void addSubject() throws Exception {
        System.out.println("Введите через пробел: день недели, номер пары, предмет, преподаватель, аудиторию, тип");
        System.out.print("Пример: 1 2 Математика Иванов 310 лекция\n> ");
        scanner.nextLine();

        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        if (parts.length < 6) {
            throw new IllegalArgumentException("Недостаточно данных. Нужно 6 параметров");
        }

        try {
            int dayNumber = Integer.parseInt(parts[0]);
            int slot = Integer.parseInt(parts[1]);
            String name = parts[2];
            String teacher = parts[3];
            String room = parts[4];
            String type = parts[5];

            shedule.add(dayNumber, slot, name, teacher, room, type);
            System.out.println("Предмет успешно добавлен!");

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Номер дня и номер пары должны быть числами");
        }
    }

    private static void findTeacher() {
        System.out.print("Введите фамилию преподавателя: ");
        scanner.nextLine();
        String teacherName = scanner.nextLine();
        shedule.findTeacher(teacherName);
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Пожалуйста, введите число");
                scanner.next();
            }
        }
    }
}
