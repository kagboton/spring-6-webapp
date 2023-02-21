package com.kagboton.spring6webapp.services;

import com.kagboton.spring6webapp.domain.Author;
import com.kagboton.spring6webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> finAll() {
        return authorRepository.findAll();
    }
}
