package com.startjava.graduation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfMain {
    private Bookshelf bookshelf = new Bookshelf();
    private static final byte MENU_EXIT = 6;
    private static final int LINE_LEN = 100;
    Scanner scan = new Scanner(System.in, "windows-1251"); // Консоль Idea
//    Scanner scan = new Scanner(System.in, "cp866"); // Консоль Idea

    public static void main(String[] args) {
        BookshelfMain bookshelfMain = new BookshelfMain();

        bookshelfMain.printLine("*", LINE_LEN);
        bookshelfMain.printReport();
        bookshelfMain.printLine("*", LINE_LEN);
        while (!bookshelfMain.runMenu()) {
            bookshelfMain.printLine("*", LINE_LEN);
        }
    }

    private boolean runMenu() {
        System.out.println("""
                1 -> Добавить книгу
                2 -> Удалить книгу
                3 -> Удалить все
                4 -> Показать книги
                5 -> Инфо
                6 -> Выход""");
        printLine("-", LINE_LEN);

        byte menuItem;
        System.out.print("Выберите пункт меню: ");
        try {
            menuItem = scan.nextByte();
            scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
            return false;
        }

        try {
            switch (menuItem) {
                case 1 -> addBook();
                case 2 -> deleteBook();
                case 3 -> clear();
                case 4 -> printReport();
                case 5 -> printInfo();
                case MENU_EXIT -> {
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            printLine("-", LINE_LEN);
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void addBook() {
        if (!bookshelf.hasCells()) {
            throw new IllegalArgumentException("На полке места нет. Вы не можете добавлять книги.");
        }

        Book book = new Book();
        System.out.println("Новая книга");
        System.out.print("Наименование : ");
        book.setName(scan.nextLine());
        System.out.print("Автор        : ");
        book.setAuthor(scan.nextLine());
        System.out.print("Год          : ");
        try {
            book.setYear(scan.nextInt());
            scan.nextLine();
        } catch (InputMismatchException e) {
            scan.nextLine();
            throw new IllegalArgumentException("Ошибка! Год книги введён неверно");
        }
        if (chooseYes("Добавить книгу?")) {
            bookshelf.addBook(book);
        }
        printReport();
    }

    private void deleteBook() {
        if (!bookshelf.hasBook()) {
            throw new IllegalArgumentException("На полке книг нет. Вы не можете удалять книги.");
        }

        System.out.println("Удаление книги");
        System.out.print("Наименование : ");

        String name = scan.nextLine().trim();

        if (!bookshelf.hasBook(name)) {
            throw new IllegalArgumentException("На полке книги \"" + name + "\" нет");
        }

        if (chooseYes("Удалить книгу " + "\"" + name + "\"" + "?")) {
            bookshelf.deleteBook(name);
        }
        printReport();
    }

    public void clear() {
        if (!bookshelf.hasBook()) {
            throw new IllegalArgumentException("На полке книг нет. Вы не можете удалять книги.");
        }
        if (chooseYes("Вы хотите удалить все книги с полки? ")) {
            bookshelf.clear();
        }
        printReport();
    }

    private boolean chooseYes(String message) {
        String yesNo;
        do {
            System.out.print(message + " [да / нет]: ");
            yesNo = scan.nextLine();
            if (yesNo.trim().equalsIgnoreCase("нет")) return false;
        } while (!yesNo.trim().equalsIgnoreCase("да"));
        return true;
    }

    private void printReport() {
        printLine("-");
        for (int i = 0; i < Bookshelf.CELLS_NUM; i++) {
            System.out.printf("| %2d ", i + 1);
            String bookStringFormat = "%-" + (bookshelf.getSize() + 4) + "s |\n";
            if (bookshelf.getBooks()[i] != null) {
                System.out.printf(bookStringFormat, bookshelf.getBooks()[i]);
            } else {
                System.out.printf(bookStringFormat, "");
            }
        }
        printInfo();
    }

    private void printInfo() {
        printLine("-");
        System.out.println(bookshelf.getInfo());
    }

    private void printLine(String type) {
        System.out.println(type.repeat(bookshelf.getSize() + 11));
    }

    private void printLine(String type, int len) {
        System.out.println(type.repeat(len));
    }
}