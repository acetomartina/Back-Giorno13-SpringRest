package com.martina.blogrest.services;

import com.martina.blogrest.entities.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    // lista che simula il database.
    private final List<Author> authors = new ArrayList<>();

    private long nextId = 1;

    public List<Author> findAll() {
        return authors;
    }

    public Author save(Author author) {

        author.setId(nextId);

        // genera automaticamente l'avatar.
        author.setAvatar("https://ui-avatars.com/api/?name="
                + author.getNome() + "+" + author.getCognome());

        authors.add(author);

        // incrementa l'id per il prossimo autore.
        nextId++;

        return author;
    }
}