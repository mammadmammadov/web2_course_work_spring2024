package wm2.az.edu.ada.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wm2.az.edu.ada.library.IdSequence;
import wm2.az.edu.ada.library.model.Book;
import wm2.az.edu.ada.library.service.BookService;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @GetMapping({"", "/"})
    public String listBooks(Model model) {
        var list = bookService.listBooks();
        model.addAttribute("books", list);
        return "list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("book", new Book(0, "", "", "", ""));
        return "new_book_form";
    }

    @PostMapping("/save")
    public String saveBook(Model model, @ModelAttribute("book") Book newBook) {
        bookService.addBook(newBook);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Integer id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "edit_book_form";
    }


    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Integer id, @ModelAttribute("book") Book updatedBook) {
        Book existingBook = bookService.findBookById(id);
        if (existingBook != null) {

            existingBook.setId(IdSequence.next());
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setYear(updatedBook.getYear());
            existingBook.setAuthor(updatedBook.getAuthor());
        }
        return "redirect:/books";
    }

}
