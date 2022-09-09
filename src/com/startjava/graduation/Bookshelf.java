package com.startjava.graduation;

import java.util.ArrayList;
import java.util.Scanner;

public class Bookshelf {

    private final int fixCells = 10;
    private final int fixSize = fixCells * Book.FIX_SIZE;
    private ArrayList <Book> books = new ArrayList<>();

    Bookshelf() {
        addTestBooks();
    }

    public void addBook() {
        Book book = null;
        printReport();
        printReportLine();
        System.out.println("Добавить книгу");
        try {
            book = inputBook();
            if (Util.chooseYes("Добавить книгу?")) {
                books.add(book);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        printReport();
    }

    private Book inputBook() throws IllegalArgumentException {
        Scanner scan = new Scanner(System.in, "windows-1251");
        Book book = new Book();

        if (getEmptyCells() > 0) {
            System.out.print("Наименование : ");
            book.setName(scan.nextLine());
            System.out.print("Автор        : ");
            book.setAuthor(scan.nextLine());
            System.out.print("Год          : ");
            book.setYear(scan.nextInt());
            if (book.getSize() > getEmptySize()) {
                throw new IllegalArgumentException("Для данной книги места на полке нет");
            }
        } else {
            throw new IllegalArgumentException("На полке нет места. Вы не можете добавлять книги");
        }
        return book;
    }

    private int getEmptyCells() {
        return Math.round((float) getEmptySize() / (float) Book.FIX_SIZE);
    }

    private int getEmptySize() {
        int sizeOfBooks = 0;
        for (Book book : books) {
            sizeOfBooks += book.getSize();
        }
        return fixSize - sizeOfBooks;
    }

    public void deleteBook() {
        printReport();
        printReportLine();
        System.out.println("Удалить книгу");
        Book book = new Book();

        try {
            book = findBook();
            System.out.println("Книга \"" + book.getName() + "\" находится на месте " + (books.indexOf(book) + 1));
            if (Util.chooseYes("Удалить книгу?")) {
                books.remove(book);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        printReport();
    }

    public Book findBook() throws IllegalArgumentException {
        Scanner scan = new Scanner(System.in, "windows-1251");
        System.out.print("Наименование : ");
        Book book = getBookByName(scan.nextLine().trim());
        return book;
    }

    private Book getBookByName(String name) throws IllegalArgumentException {
        for (Book book : books) {
            if (book.getName().equals(name)) return book;
        }
        throw new IllegalArgumentException("На полке книги \"" + name + "\" нет");
    }

    public void clear() {
        printReport();
        printReportLine();
        if (Util.chooseYes("В хотите удалить все книги с полки? ")) {
            books.clear();
        }
        printReport();
    }

    public void printReport() {
        printReportLine();
        printReportBusyCells();
        printReportEmptyCells();
        printInfo();
    }

    private void printReportBusyCells() {
        for (Book book : books) {
            System.out.println(String.format("| %2d ", books.indexOf(book) + 1) + book.toReportString());
        }
    }

    private void printReportEmptyCells() {
        int num = books.size() + 1;
        for (int i = 0; i < getEmptyCells(); i++) {
            printReportEmptyCell(num + i);
        }
    }

    private void printReportEmptyCell(int num) {
        System.out.println("| " + String.format("%2d ", num) + "| " + " ".repeat(Book.FIX_AUTHOR_SIZE) + " | " +
                " ".repeat(Book.FIX_NAME_SIZE) + " | " + " ".repeat(Book.FIX_YEAR_SIZE) + " |");
    }

    private void printReportLine() {
        Util.printLine("-", Book.INFO_LEN);
    }

    public void printInfo() {
        printReportLine();
        System.out.println("На полке " +  (books.size() > 0 ? books.size() : "нет") + " книг. " +
                "Осталось места для " + getEmptyCells() + " книг.");
    }

// =============================================================================================

    private void addTestBooks() {
//        System.out.println("*** addTestBooks ***");

        Book book;

        book = new Book();
        book.setName("Над пропастью во ржи");
        book.setAuthor("Джером Дэвид Селинджер");
        book.setYear(1951);
        books.add(book);

        book = new Book();
        book.setName("Жажда жизни");
        book.setAuthor("Ирвинг Стоун");
        book.setYear(1973);
        books.add(book);

        book = new Book();
        book.setName("Унесенные ветром");
        book.setAuthor("Маргарет Митчелл");
        book.setYear(1936);
        books.add(book);

        book = new Book();
        book.setName("Великий Гэтсби");
        book.setAuthor("Фрэнсис Скотт Фицджеральд");
        book.setYear(1925);
        books.add(book);

        book = new Book();
        book.setName("Улисс");
        book.setAuthor("Джеймс Джойс");
        book.setYear(1920);
        books.add(book);

/*
        book = new Book();
        book.setName("Гордость и предубеждение");
        book.setAuthor("Джейн Остин");
        book.setYear(1831);
        books.add(book);

        book = new Book();
        book.setName("Кентерберийские рассказы");
        book.setAuthor("Джефри Чосер");
        book.setYear(1972);
        books.add(book);

        book = new Book();
        book.setName("\"Илиада\" и \"Одиссея\"");
        book.setAuthor("Гомер");
        book.setYear(2013);
        books.add(book);

        book = new Book();
        book.setName("На маяк");
        book.setAuthor("Вирджиния Вулф");
        book.setYear(1927);
        books.add(book);

        book = new Book();
        book.setName("История");
        book.setAuthor("Геродот");
        book.setYear(1972);
        books.add(book);
*/
    }
}