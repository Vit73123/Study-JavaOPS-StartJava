package com.startjava.graduation;

public class Bookshelf {
    public final static int CELLS_NUM = 10;
    private Book[] books = new Book[CELLS_NUM];
    private final int defaultSize = 50;
    private int size = defaultSize;
    private int booksNum = 0;

    Bookshelf() {
        addTestBooks();
    }

    public int getSize() {
        return size;
    }

    public Book[] getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books[booksNum] = book;
        if (booksNum > 0) {
            setSize(book.getLen());
        } else {
            size = book.getLen();
        }
        booksNum++;
    }

    public void deleteBook(String name) {
        int bookNum = getBookNum(name);
        System.arraycopy(books, bookNum + 1 , books, bookNum, booksNum - bookNum - 1);
        books[--booksNum] = null;
        if (booksNum > 0) {
            setSize();
        } else {
            size = defaultSize;
        }
    }

    public boolean hasBook() {
        return booksNum > 0;
    }

    public boolean hasBook(String name) {
        for (int i = 0; i < booksNum; i++) {
            if (books[i].getName().equals(name)) return true;
        }
        return false;
    }

    public boolean hasCells() {
        return booksNum < CELLS_NUM;
    }

    public void clear() {
        while (booksNum > 0) books[--booksNum] = null;
        size = defaultSize;
    }

    public String getInfo() {
        System.out.print("На полке " +  (booksNum > 0 ? booksNum : "нет") + " книг. ");
        if (booksNum == CELLS_NUM)
            return ("На полке места нет");
        else
            return ("Осталось места для " + (CELLS_NUM - booksNum) + " книг.");
    }

    private void setSize() {
        size = books[0].getLen();
        for (int i = 1; i < booksNum; i++) {
            int len = books[i].getLen();
            if (len > size) size = len;
        }
    }

    private void setSize(int len) {
        if (len > size) size = len;
    }

    private int getBookNum (String name) {
        for (int i = 0; i < booksNum; i++) {
            if (books[i].getName().equals(name)) return i;
        }
        return -1;
    }

    // =============================================================================================

    private void addTestBooks() {
//        System.out.println("*** addTestBooks ***");

        books[0] = new Book();
        books[0].setName("Над пропастью во ржи");
        books[0].setAuthor("Джером Дэвид Селинджер");
        books[0].setYear(1951);
        size = books[0].getLen();
        booksNum++;

        books[1] = new Book();
        books[1].setName("Жажда жизни");
        books[1].setAuthor("Ирвинг Стоун");
        books[1].setYear(1973);
        setSize(books[1].getLen());
        booksNum++;

        books[2] = new Book();
        books[2].setName("Унесенные ветром");
        books[2].setAuthor("Маргарет Митчелл");
        books[2].setYear(1936);
        setSize(books[2].getLen());
        booksNum++;

        books[3] = new Book();
        books[3].setName("Великий Гэтсби");
        books[3].setAuthor("Фрэнсис Скотт Фицджеральд");
        books[3].setYear(1925);
        setSize(books[3].getLen());
        booksNum++;

        books[4] = new Book();
        books[4].setName("Улисс");
        books[4].setAuthor("Джеймс Джойс");
        books[4].setYear(1920);
        setSize(books[4].getLen());
        booksNum++;

/*
        books[5] = new Book();
        books[5].setName("Гордость и предубеждение");
        books[5].setAuthor("Джейн Остин");
        books[5].setYear(1931);
        setSize(books[5].getLen());
        booksNum++;

        books[6] = new Book();
        books[6].setName("Кентерберийские рассказы");
        books[6].setAuthor("Джефри Чосер");
        books[6].setYear(1972);
        setSize(books[6].getLen());
        booksNum++;

        books[7] = new Book();
        books[7].setName("\"Илиада\" и \"Одиссея\"");
        books[7].setAuthor("Гомер");
        setSize(books[7].getLen());
        booksNum++;

        books[8] = new Book();
        books[8].setName("На маяк");
        books[8].setAuthor("Вирджиния Вулф");
        books[8].setYear(1927);
        setSize(books[8].getLen());
        booksNum++;

        books[9] = new Book();
        books[9].setName("История");
        books[9].setAuthor("Геродот");
        setSize(books[9].getLen());
        booksNum++;
*/
    }
}