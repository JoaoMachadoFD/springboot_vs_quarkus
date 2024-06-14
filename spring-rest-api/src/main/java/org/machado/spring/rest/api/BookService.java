package org.machado.spring.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    public Book readOne(String id) {
        return bookRepository.findById(id).get();
    }

    public Book insert(Book book) {
        return bookRepository.save(book);
    }

    public void update(Book book, String id) {
        book.setId(id);
        bookRepository.save(book);
    }

    public void delete(String id) {
        bookRepository.deleteById(id);
    }

}
