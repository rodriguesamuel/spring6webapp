package sam.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sam.springframework.spring6webapp.domain.Author;
import sam.springframework.spring6webapp.domain.Book;
import sam.springframework.spring6webapp.domain.Publisher;
import sam.springframework.spring6webapp.repositories.AuthorRepository;
import sam.springframework.spring6webapp.repositories.BookRepository;
import sam.springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Jhonson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE development without EJB");
        noEJB.setIsbn("789456");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        Publisher joao = new Publisher();
        joao.setAddress("address");
        joao.setState("some state");
        joao.setZip("some zip");
        joao.setPublisherName("joão");

        publisherRepository.save(joao);

        Publisher lucas = new Publisher();
        lucas.setAddress("address lucas");
        lucas.setState("some state");
        lucas.setZip("some zip");
        lucas.setPublisherName("lucas");

        publisherRepository.save(lucas);

        System.out.println("In bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
