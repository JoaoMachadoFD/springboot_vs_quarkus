package org.machado.quarkus.rest.api;


import io.quarkus.narayana.jta.runtime.TransactionConfiguration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Transactional
@TransactionConfiguration(timeout = 600)
public class BookService {

    @Inject
    BookRepository bookRepository;

    public List<Book> readAll() {
        return bookRepository.readAll();
    }

    public Book readOne(String id) {
        return bookRepository.readOne(id);
    }

    public Book insert(Book book) {
        book.setId(UUID.randomUUID().toString());

        return bookRepository.insert(book);
    }

    public void update(Book book, String id) {
        bookRepository.update(book, id);
    }

    public void delete(String id) {
        bookRepository.delete(id);
    }

}
