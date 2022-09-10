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

        byte menuItem = 0;
        while (menuItem != MENU_EXIT) {
            printLine("*");
            bookshelfMain.printMenu();
            menuItem = bookshelfMain.chooseMenu();
            bookshelfMain.runMenu(menuItem);
        }
    }

    private void printMenu() {
        System.out.println("""
                1 -> Добавить книгу
                2 -> Удалить книгу
                3 -> Удалить все
                4 -> Показать книги
                5 -> Инфо
                6 -> Выход
                """);
    }

    private byte chooseMenu() {
        Scanner scan = new Scanner(System.in, CHARSET_NAME);
        printLine("-");
        byte menuItem = 0;
        System.out.print("Выберите пункт меню: ");
        try {
            menuItem = scan.nextByte();
            menuItem = menuItem < 0 || menuItem > MENU_EXIT ? 0 : menuItem;
        } catch (InputMismatchException e) {
            menuItem = 0;
        }
        return menuItem;
    }

    private void runMenu(byte menu) {
        switch (menu) {
            case 1 -> addBook();
            case 2 -> deleteBook();
            case 3 -> clear();
            case 4 -> bookshelf.printReport();
            case 5 -> bookshelf.printInfo();
        }
    }

    public void addBook() {
        Book book = null;
        bookshelf.printReport();
        printLine("-");
        System.out.println("Новая книга");
        try {
            book = inputBook();
            if (chooseYes("Добавить книгу?")) {
                bookshelf.addBook(book);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        bookshelf.printReport();
    }

    private Book inputBook() throws IllegalArgumentException {
        Scanner scan = new Scanner(System.in, CHARSET_NAME);
        Book book = new Book();

        bookshelf.checkCells();
        System.out.print("Наименование : ");
        book.setName(scan.nextLine());
        System.out.print("Автор        : ");
        book.setAuthor(scan.nextLine());
        System.out.print("Год          : ");
        try {
            book.setYear(scan.nextInt());
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Ошибка: Год книги введён неверно");
        }
        bookshelf.checkSpace(book);

        return book;
    }

    private void deleteBook() {
        bookshelf.printReport();
        printLine("-");
        System.out.println("Удаление книги");
        Book book = new Book();

        try {
            book = askBook();
            bookshelf.printBookCell(book);
            if (chooseYes("Удалить книгу?")) {
                bookshelf.deleteBook(book);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        bookshelf.printReport();
    }

    private Book askBook() throws IllegalArgumentException {
        Scanner scan = new Scanner(System.in, CHARSET_NAME);

        System.out.print("Наименование : ");
        Book book = bookshelf.findBook(scan.nextLine().trim());

        return book;
    }

    public void clear() {
        bookshelf.printReport();
        printLine("-");
        if (chooseYes("В хотите удалить все книги с полки? ")) {
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

    public static String leftString (String str, int num) {
        return num > str.length() ? str : str.substring(0, num);
    }

    public static void printLine(String type) {
        System.out.println(type.repeat(Book.INFO_LEN));
    }
}