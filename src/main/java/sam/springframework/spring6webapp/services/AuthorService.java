package sam.springframework.spring6webapp.services;

import sam.springframework.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
