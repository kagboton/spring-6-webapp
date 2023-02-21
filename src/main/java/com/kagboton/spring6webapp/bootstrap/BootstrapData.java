package com.kagboton.spring6webapp.bootstrap;

import com.kagboton.spring6webapp.domain.Author;
import com.kagboton.spring6webapp.domain.Book;
import com.kagboton.spring6webapp.domain.Publisher;
import com.kagboton.spring6webapp.repositories.AuthorRepository;
import com.kagboton.spring6webapp.repositories.BookRepository;
import com.kagboton.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author kilian = new Author();
        kilian.setFirstName("Kilian");
        kilian.setLastName("Agboton");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Dev");
        ddd.setIsbn("1234");

        Author kilianSaved = authorRepository.save(kilian);
        Book dddSaved = bookRepository.save(ddd);

        Author toto = new Author();
        toto.setFirstName("Toto");
        toto.setLastName("Henderson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Dev without EJB");
        noEJB.setIsbn("54789632");

        Author totoSaved = authorRepository.save(toto);
        Book noEJBSaved = bookRepository.save(noEJB);

        Publisher thePublisher = new Publisher();
        thePublisher.setPublisherName("Kings Herald");
        thePublisher.setCity("Books Town");
        Publisher savedPublisher = publisherRepository.save(thePublisher);

        dddSaved.setPublisher(savedPublisher);
        noEJBSaved.setPublisher(savedPublisher);

        kilianSaved.getBooks().add(dddSaved);
        totoSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(kilianSaved);
        noEJBSaved.getAuthors().add(totoSaved);

        authorRepository.save(kilianSaved);
        authorRepository.save(totoSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
