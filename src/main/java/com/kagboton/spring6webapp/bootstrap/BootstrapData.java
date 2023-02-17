package com.kagboton.spring6webapp.bootstrap;

import com.kagboton.spring6webapp.domain.Author;
import com.kagboton.spring6webapp.domain.Book;
import com.kagboton.spring6webapp.repositories.AuthorRepository;
import com.kagboton.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author kilian = new Author();
        kilian.setFistName("Kilian");
        kilian.setLastName("Agboton");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Dev");
        ddd.setIsbn("1234");

        Author kilianSaved = authorRepository.save(kilian);
        Book dddSaved = bookRepository.save(ddd);

        Author toto = new Author();
        toto.setFistName("Toto");
        toto.setLastName("Henderson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Dev without EJB");
        noEJB.setIsbn("54789632");

        Author totoSaved = authorRepository.save(toto);
        Book noEJBSaved = bookRepository.save(noEJB);

        kilianSaved.getBooks().add(dddSaved);
        totoSaved.getBooks().add(noEJBSaved);
        
        authorRepository.save(kilianSaved);
        authorRepository.save(totoSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());

    }
}
