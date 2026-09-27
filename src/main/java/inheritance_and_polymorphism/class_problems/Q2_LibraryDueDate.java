package inheritance_and_polymorphism.class_problems;

import java.time.LocalDate;

abstract class LibraryItem {
    String title;
    LibraryItem(String title) { this.title = title; }
    abstract int loanDays();
    LocalDate dueDate(LocalDate date) { return date.plusDays(loanDays()); }
}
class BookItem extends LibraryItem {
    BookItem(String t) { super(t); }
    int loanDays() { return 14; }
}
class DVDItem extends LibraryItem {
    DVDItem(String t) { super(t); }
    int loanDays() { return 7; }
}
class MagazineItem extends LibraryItem {
    MagazineItem(String t) { super(t); }
    int loanDays() { return 3; }
}
public class Q2_LibraryDueDate {
    public static void main(String[] args) {
        LocalDate current = LocalDate.of(2023, 10, 26);
        LibraryItem[] items = {new BookItem("1984"), new DVDItem("The Matrix"), new MagazineItem("Forbes Issue 500")};
        for (LibraryItem item : items)
            System.out.println(item.title + ": " + item.dueDate(current));
    }
}