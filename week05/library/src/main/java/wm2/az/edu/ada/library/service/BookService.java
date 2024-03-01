package wm2.az.edu.ada.library.service;

import org.springframework.stereotype.Service;
import wm2.az.edu.ada.library.IdSequence;
import wm2.az.edu.ada.library.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> bookList = new ArrayList<>(List.of(new Book(IdSequence.next(), "Introduction to Mathematical Logic", "2010", "Intro to Mathematical Logic", "Elliott Mendelson"),
            new Book(IdSequence.next(), "Principles of Mathematical Analysis", "1976", "Principles of Analysis", "Walter Rudin"),
            new Book(IdSequence.next(), "Discrete Mathematics and Its Applications", "2018", "Discrete Math & Applications", "Kenneth H. Rosen"),
            new Book(IdSequence.next(), "Linear Algebra and Its Applications", "2015", "Linear Algebra & Applications", "David C. Lay")));

    public void addBook(Book book) {
        if (book == null) {
            return;
        }
        if (book.getAuthor() == null || book.getDescription() == null || book.getTitle() == null) {
            return;
        }

        book.setId(IdSequence.next());

        bookList.add(book);

        System.out.println(book);
    }

    public List<Book> listBooks() {
        return bookList;
    }

    public void deleteBook(Integer idx) {
        if (idx == null || idx < 0 || idx >= bookList.size()) {
            return;
        }
        bookList.remove(idx.intValue());

    }

    public Book findBookById(Integer id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }


}
