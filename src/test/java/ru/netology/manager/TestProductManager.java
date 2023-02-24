package ru.netology.manager;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestProductManager {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Азазель", 540, "Б. Акунин");
    Product smartphone = new Smartphone(4, "Galaxy S22", 59_990, "Samsung");
    Product product = new Product(12, "Сумка женская", 12_000);
    @Test
    void shouldAddAnything () {
        manager.add(smartphone);
        Product [] expected = {smartphone};
        Product [] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldAddAll () {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        Product [] expected = {book, smartphone, product};
        Product [] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSearchByName () {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "Азазель";
        Product [] expected = {book};
        Product [] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

        @Test
    void shouldSearchWhenProductNameDoesNotMatch () {
            manager.add(book);
            manager.add(smartphone);
            manager.add(product);
            String name = "Мастер и Маргарита";
            Product[] expected = {};
            Product[] actual = manager.searchBy(name);
            assertArrayEquals(expected, actual);

        }

}
