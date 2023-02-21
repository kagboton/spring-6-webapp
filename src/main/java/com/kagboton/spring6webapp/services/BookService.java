package com.kagboton.spring6webapp.services;

import com.kagboton.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
