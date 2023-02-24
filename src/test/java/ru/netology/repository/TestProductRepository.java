package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class TestProductRepository {
    private ProductRepository repo = new ProductRepository();
    Product book = new Book(1, "Азазель", 560, "Б. Акунин");
    Product smartphone = new Smartphone(12, "Galaxy S22", 59_900, "Samsung");
    Product product = new Product(23, "Сумка женская", 12_000);

    @Test
    public void shouldFindOne() {
        repo.save(book);
        Product[] expected = {book};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        repo.save(book);
        repo.save(smartphone);
        repo.save(product);
        Product[] expected = {book, smartphone, product};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(book);
        repo.save(smartphone);
        repo.save(product);
        repo.removeById(12);
        Product[] expected = {book, product};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllById() {
        repo.save(book);
        repo.save(smartphone);
        repo.save(product);
        repo.removeById(1);
        repo.removeById(12);
        repo.removeById(23);
        Product[] expected = {};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

}
