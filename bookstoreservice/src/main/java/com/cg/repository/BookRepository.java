package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
