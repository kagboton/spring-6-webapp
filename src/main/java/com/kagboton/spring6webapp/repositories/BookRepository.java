package com.kagboton.spring6webapp.repositories;

import com.kagboton.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
