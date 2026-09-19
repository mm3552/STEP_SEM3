package encapsulation_and_access_control.class_problems;

class AttendanceSheet {
    private final String[] students;
    private int count;

    AttendanceSheet(int maximumStudents) {
        students = new String[maximumStudents];
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }
        if (count < students.length) {
            students[count] = name;
            count++;
        }
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}
