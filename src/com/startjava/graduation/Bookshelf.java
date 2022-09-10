package com.startjava.graduation;

import java.util.ArrayList;

public class Bookshelf {

    private final int fixCells = 10;
    private final int fixSize = fixCells * Book.FIX_SIZE;
    private ArrayList <Book> books = new ArrayList<>();

    Bookshelf() {
        addTestBooks();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void checkCells() throws IllegalArgumentException {
        if (getEmptyCells() <= 0)
            throw new IllegalArgumentException("На полке места нет");
    }

    public void checkSpace(Book book) throws IllegalArgumentException {
        if (book.getSize() > getEmptySpace())
            throw new IllegalArgumentException("На полке места нет для данной книги");
    }

    public Book findBook(String name) throws IllegalArgumentException {
        for (Book book : books) {
            if (book.getName().equals(name)) return book;
        }
        throw new IllegalArgumentException("На полке книги \"" + name + "\" нет");
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public void clear() {

        books.clear();
    }

    public void printReport() {
        BookshelfMain.printLine("-");
        printReportBusyCells();
        printReportEmptyCells();
        printInfo();
    }

    public void printInfo() {
        BookshelfMain.printLine("-");
        System.out.println("На полке " +  (books.size() > 0 ? books.size() : "нет") + " книг. " +
                "Осталось места для " + getEmptyCells() + " книг.");
    }

    private int getEmptyCells() {
        return Math.round((float) getEmptySpace() / (float) Book.FIX_SIZE);
    }

    private int getEmptySpace() {
        int sizeOfBooks = 0;
        for (Book book : books) {
            sizeOfBooks += book.getSize();
        }
        return fixSize - sizeOfBooks;
    }

    public void printBookCell(Book book) {
        System.out.println("Книга \"" + book.getName() + "\" находится на месте " + (books.indexOf(book) + 1));
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
//        System.out.println("| " + String.format("%2d", num) + " ".repeat(Book.INFO_LEN - 5) + "|");
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