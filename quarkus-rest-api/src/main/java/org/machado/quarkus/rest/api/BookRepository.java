package org.machado.quarkus.rest.api;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BookRepository implements PanacheRepositoryBase<Book, String> {

    public List<Book> readAll() {
        return listAll();
    }

    public Book readOne(String id) {
        return find("id = ?1", id).firstResult();
    }

    public Book insert(Book book) {
        persist(book);
        return book;
    }

    public void update(Book book, String id) {
        update("author = ?2, title = ?3, price = ?4 where id = ?1", id, book.getAuthor(), book.getTitle(), book.getPrice());
    }

    public void delete(String id) {
        delete("id = ?1", id);
    }

}
