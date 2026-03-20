package klu.Skill6;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private List<Book> bookStore = new ArrayList<>();

    // welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Library!";
    }

    // count
    @GetMapping("/count")
    public int totalBooks() {
        return bookStore.size();
    }

    // price
    @GetMapping("/price")
    public double samplePrice() {
        return 29.99;
    }

    // books
    @GetMapping("/books")
    public List<String> getBookTitles() {
        return Arrays.asList("Java Basics", "Spring Boot Guide", "REST API Design");
    }

    // books/{id}
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details for Book ID: " + id;
    }

    // search?title=
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    // author/{name}
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by: " + name;
    }

    //addbook
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookStore.add(book);
        return "Book added successfully!";
    }

    // viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookStore;
    }
}