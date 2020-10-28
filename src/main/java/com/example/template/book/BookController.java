package com.example.template.book;

import com.example.template.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/book/{bookId}")
    Book productStockCheck(@PathVariable(value = "bookId") Long bookId) {
        return  this.bookService.getBookById(bookId);
    }

    @PostMapping("/book")
    Book bookInsert(@RequestBody String data) {
        return this.bookService.save(data);
    }

    @RequestMapping(method = RequestMethod.PUT, path="/book/{book}", consumes = "application/json")
    Book bookModify(@PathVariable(value = "book") String book) {
        return this.bookService.save(book);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/book/decreaseStock", consumes = "application/json")
    Book updateBookStock(@RequestBody String data) {
        return this.bookService.save(data);
    }

}
