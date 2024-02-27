package wm2.az.edu.ada.library.service;

import org.springframework.stereotype.Service;
import wm2.az.edu.ada.library.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> bookList = new ArrayList<>(List.of(new Book(1, "Introduction to Mathematical Logic", "2010", "Intro to Mathematical Logic", "Elliott Mendelson"),
            new Book(2, "Principles of Mathematical Analysis", "1976", "Principles of Analysis", "Walter Rudin"),
            new Book(3, "Discrete Mathematics and Its Applications", "2018", "Discrete Math & Applications", "Kenneth H. Rosen"),
            new Book(4, "Linear Algebra and Its Applications", "2015", "Linear Algebra & Applications", "David C. Lay")
    ));

    public void addBook(Book book) {
        if (book == null) {
            return;
        }
        if (book.getAuthor() == null || book.getDescription() == null || book.getTitle() == null) {
            return;
        }
        bookList.add(book);
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

    public Book getBook(Integer id) {
        return bookList.stream().filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void updateBook(Integer id, Book updatedBook) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)) {
                bookList.set(i, updatedBook);
                break;
            }
        }
    }
}
