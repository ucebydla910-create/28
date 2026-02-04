public class Shedule {
    private WeekDay[] week;

    public Shedule() {
        week = new WeekDay[6];
        String[] days = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота"};
        for (int i = 0; i < week.length; i++) {
            week[i] = new WeekDay(days[i]);
        }
    }

    public void add(int dayNumber, int slot, String name, String teacher, String room, String type) throws Exception {

        if (dayNumber < 1 || dayNumber > week.length) {
            throw new IllegalArgumentException("Номер дня должен быть от 1 до " + week.length);
        }

        Subject subject = new Subject(name, teacher, room, type);

        week[dayNumber - 1].add(slot, subject);
    }

    public void print() {
        for (WeekDay day : week) {
            day.print();
        }
    }

    public void findTeacher(String teacherName) {
        System.out.println("=== Занятия преподавателя " + teacherName + " ===");
        boolean found = false;

        for (int i = 0; i < week.length; i++) {
            week[i].findTeacher(teacherName, i);
        }

        if (!found) {
            System.out.println("Занятия не найдены");
        }
        System.out.println("==================================");
    }
}
