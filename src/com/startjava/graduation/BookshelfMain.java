package com.startjava.graduation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfMain {
    private Bookshelf bookshelf = new Bookshelf();
    private static final byte MENU_EXIT = 6;
//    private static final String CHARSET_NAME = "windows-1251";  // Консоль Idea
    private static final String CHARSET_NAME = "cp866";         // Консоль Windows

    public static void main(String[] args) {
        BookshelfMain bookshelfMain = new BookshelfMain();

        boolean exit = false;
        bookshelfMain.bookshelf.printLine("*");
        bookshelfMain.bookshelf.printReport();
        while (!exit) {
            bookshelfMain.bookshelf.printLine("*");
            exit = bookshelfMain.runMenu();
        }
    }

    private boolean runMenu() {
        Scanner scan = new Scanner(System.in, CHARSET_NAME);

        System.out.println("""
                1 -> Добавить книгу
                2 -> Удалить книгу
                3 -> Удалить все
                4 -> Показать книги
                5 -> Инфо
                6 -> Выход
                """);
        bookshelf.printLine("-");

        byte menuItem = 0;
        System.out.print("Выберите пункт меню: ");
        try {
            menuItem = scan.nextByte();
            menuItem = menuItem < 0 || menuItem > MENU_EXIT ? 0 : menuItem;
        } catch (InputMismatchException e) {
            menuItem = 0;
        }

        try {
            switch (menuItem) {
                case 1 -> addBook();
                case 2 -> deleteBook();
                case 3 -> clear();
                case 4 -> bookshelf.printReport();
                case 5 -> bookshelf.printInfo();
                case MENU_EXIT -> {
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void addBook() throws IllegalArgumentException {
        Scanner scan = new Scanner(System.in, CHARSET_NAME);

        if (!bookshelf.hasCells()) {
            throw new IllegalArgumentException("На полке места нет. Вы не можете добавлять книги.");
        }

        Book book = new Book();
        bookshelf.printReport();
        bookshelf.printLine("-");
        System.out.println("Новая книга");
        System.out.print("Наименование : ");
        book.setName(scan.nextLine());
        System.out.print("Автор        : ");
        book.setAuthor(scan.nextLine());
        System.out.print("Год          : ");
        try {
            book.setYear(scan.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Год книги введён неверно");
            return;
        }
        if (chooseYes("Добавить книгу?")) {
            bookshelf.addBook(book);
        }
        bookshelf.printReport();
    }

    private void deleteBook() throws IllegalArgumentException {
        Scanner scan = new Scanner(System.in, CHARSET_NAME);

        bookshelf.printReport();
        bookshelf.printLine("-");
        System.out.println("Удаление книги");
        System.out.print("Наименование : ");

        if (!bookshelf.hasBooks()) {
            throw new IllegalArgumentException("На полке книг нет. Вы не можете удалять книги.");
        }

        String name = scan.nextLine().trim();

        if (!bookshelf.hasBook(name)) {
            throw new IllegalArgumentException("На полке книги \"" + name + "\" нет");
        }

        if (chooseYes("Удалить книгу " + "\"" + name + "\"" + "?")) {
            bookshelf.deleteBook(name);
        }
        bookshelf.printReport();
    }

    public void clear() throws IllegalArgumentException {
        bookshelf.printReport();
        bookshelf.printLine("-");

        if (!bookshelf.hasBooks()) {
            throw new IllegalArgumentException("На полке книг нет. Вы не можете удалять книги.");
        }
        if (chooseYes("Вы хотите удалить все книги с полки? ")) {
            bookshelf.clear();
        }
        bookshelf.printReport();
    }

    private boolean chooseYes(String message) {
        Scanner scan = new Scanner(System.in, CHARSET_NAME);
        String yesNo;
        do {
            System.out.print(message + " [да / нет]: ");
            yesNo = scan.nextLine();
            if (yesNo.trim().equalsIgnoreCase("нет")) return false;
        } while (!yesNo.trim().equalsIgnoreCase("да"));
        return true;
    }
}