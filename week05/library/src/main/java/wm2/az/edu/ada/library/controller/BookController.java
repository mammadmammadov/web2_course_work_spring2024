package wm2.az.edu.ada.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wm2.az.edu.ada.library.BookIdSequence;
import wm2.az.edu.ada.library.model.Book;
import wm2.az.edu.ada.library.service.BookService;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/delete/{idx}")
    public String deleteBook(@PathVariable Integer idx) {
        bookService.deleteBook(idx);
        return "redirect:/books";
    }

    @GetMapping("/edit/{idx}")
    public String editBook(@PathVariable Integer idx, Model model) {
        Book bookToEdit = bookService.getBook(idx);
        model.addAttribute("book", bookToEdit);
        return "edit_book_form";
    }

    @PostMapping("/update/{idx}")
    public String updateBook(@PathVariable Long idx, @ModelAttribute("book") Book updatedBook) {
        bookService.updateBook(updatedBook);
        return "redirect:/books";
    }
}
