public class Subject {
    private final String name;
    private final String teacher;
    private final String room;
    private final String type;

    private static final String[] ALLOWED_TYPES = {"лекция", "практика", "лабораторная"};

    public Subject(String name, String teacher, String room, String type) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название предмета не может быть пустым");
        }
        if (teacher == null || teacher.trim().isEmpty()) {
            throw new IllegalArgumentException("Фамилия преподавателя не может быть пустой");
        }
        if (room == null || room.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер аудитории не может быть пустым");
        }
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Тип занятия не может быть пустым");
        }

        boolean validType = false;
        for (String allowedType : ALLOWED_TYPES) {
            if (allowedType.equalsIgnoreCase(type.trim())) {
                validType = true;
                break;
            }
        }
        if (!validType) {
            throw new IllegalArgumentException("Некорректный тип занятия. Допустимые значения: лекция, практика, лабораторная");
        }

        this.name = name.trim();
        this.teacher = teacher.trim();
        this.room = room.trim();
        this.type = type.trim().toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getRoom() {
        return room;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s (%s), преп. %s, ауд. %s", name, type, teacher, room);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Subject subject = (Subject) obj;
        return name.equals(subject.name) &&
                teacher.equals(subject.teacher) &&
                room.equals(subject.room) &&
                type.equals(subject.type);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + teacher.hashCode();
        result = 31 * result + room.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
