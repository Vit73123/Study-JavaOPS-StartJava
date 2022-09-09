package com.startjava.graduation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfMain {
    private Bookshelf bookshelf = new Bookshelf();
    private static final byte MENU_EXIT = 6;

    public static void main(String[] args) {
        BookshelfMain work = new BookshelfMain();

        byte menu = 0;
        while (menu != MENU_EXIT) {
            work.printBorderLine("*");
            work.showMenu();
            menu = work.chooseMenu();
            work.runMenu(menu);
        }
    }

    private void showMenu() {
        System.out.println("""
                1 -> Показать книги
                2 -> Показать сводку
                3 -> Добавить книгу
                4 -> Удалить книгу
                5 -> Очистить полку
                6 -> Выход
                """);
    }

    private byte chooseMenu() {
        printBorderLine("-");
        byte menu = 0;
        System.out.print("Выберите пункт меню: ");
        Scanner scan = new Scanner(System.in, "cp866");
//        Scanner scan = new Scanner(System.in, "windows-1251");
        try {
            menu = scan.nextByte();
            menu = menu < 0 || menu > MENU_EXIT ? MENU_EXIT : menu;
        } catch (InputMismatchException e) {
            menu = 0;
        }
        return menu;
    }

    private void runMenu(byte menu) {
        switch (menu) {
            case 1 -> bookshelf.printReport();
            case 2 -> bookshelf.printInfo();
            case 3 -> bookshelf.addBook();
            case 4 -> bookshelf.deleteBook();
            case 5 -> bookshelf.clear();
        }
    }

    private void printBorderLine(String type) {
        Util.printLine(type, Book.INFO_LEN);
    }
}