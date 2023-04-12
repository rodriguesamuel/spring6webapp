package sam.springframework.spring6webapp.services;

import sam.springframework.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
