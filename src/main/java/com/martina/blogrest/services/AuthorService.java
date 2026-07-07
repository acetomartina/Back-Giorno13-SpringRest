package com.martina.blogrest.services;

import com.martina.blogrest.entities.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final List<Author> authors = new ArrayList<>();
    private Long nextId = 1L;

    public List<Author> findAll() {
        return authors;
    }

    public Author save(Author author) {
        author.setId(nextId);
        author.setAvatar("https://ui-avatars.com/api/?name="
                + author.getNome() + "+"
                + author.getCognome());

        authors.add(author);
        nextId++;

        return author;
    }

    public Author findById(Long id) {
        return authors.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Author update(Long id, Author authorAggiornato) {
        Author author = findById(id);

        if (author != null) {
            author.setNome(authorAggiornato.getNome());
            author.setCognome(authorAggiornato.getCognome());
            author.setEmail(authorAggiornato.getEmail());
            author.setDataDiNascita(authorAggiornato.getDataDiNascita());
        }

        return author;
    }

    public boolean delete(Long id) {
        Author author = findById(id);

        if (author != null) {
            authors.remove(author);
            return true;
        }

        return false;
    }
}