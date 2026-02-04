
public class WeekDay {
    private final String dayName;
    private Subject[] slotList;

    public WeekDay(String dayName) {
        this.dayName = dayName;
        this.slotList = new Subject[10]; // Допустим, максимально 10 пар в день
    }

    public void add(int slotNumber, Subject subject) throws Exception {
        if (slotNumber < 1 || slotNumber > slotList.length) {
            throw new IllegalArgumentException("Номер пары должен быть от 1 до " + slotList.length);
        }

        if (slotList[slotNumber - 1] != null) {
            throw new IllegalStateException("В этот слот уже добавлен предмет: " + slotList[slotNumber - 1]);
        }

        slotList[slotNumber - 1] = subject;
    }

    public Subject getSubject(int slotNumber) {
        if (slotNumber < 1 || slotNumber > slotList.length) {
            return null;
        }
        return slotList[slotNumber - 1];
    }

    public void print() {
        System.out.println("=================" + dayName + "===============");
        for (int i = 0; i < slotList.length; i++) {
            if (slotList[i] != null) {
                System.out.println((i + 1) + ") " + slotList[i]);
            }
        }
        System.out.println("==========================================");
    }

    public void findTeacher(String teacherName, int dayIndex) {
        for (int i = 0; i < slotList.length; i++) {
            if (slotList[i] != null && slotList[i].getTeacher().equalsIgnoreCase(teacherName)) {
                String dayName = getDayNameFromIndex(dayIndex);
                System.out.printf("%s, %d пара: %s%n", dayName, i + 1, slotList[i].getName());
            }
        }
    }

    private String getDayNameFromIndex(int index) {
        String[] days = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота"};
        return (index >= 0 && index < days.length) ? days[index] : "День " + (index + 1);
    }
}