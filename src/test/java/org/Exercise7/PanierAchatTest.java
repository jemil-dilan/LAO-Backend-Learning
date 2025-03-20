package org.Exercise7;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PanierAchatTest {
    PanierAchat objectUnderTest = new PanierAchat();

    @Test
    void addProductTest() {
        //given
        objectUnderTest.addProduct(new Product(1, "Bouteille", 5));
        objectUnderTest.addProduct(new Product(2, "Chaise", 2));
        objectUnderTest.addProduct(new Product(3, "ordinateur", 1));
        //when
        List<Product> actualResult = objectUnderTest.getProducts();
        //then
        assertEquals(3, actualResult.size());
    }

    @Test
    void deleteProductTest() {
        //given
        objectUnderTest.addProduct(new Product(1, "Bouteille", 5));
        objectUnderTest.addProduct(new Product(2, "Chaise", 2));
        objectUnderTest.addProduct(new Product(3, "ordinateur", 1));
        //when
        objectUnderTest.deleteProduct(2);
        List<Product> actualResult = objectUnderTest.getProducts();
        //then
        assertEquals(2, actualResult.size());
    }

    @Test
    void productsQuantityTest() {
        //given
        objectUnderTest.addProduct(new Product(1, "Bouteille", 5));
        objectUnderTest.addProduct(new Product(2, "Chaise", 2));
        objectUnderTest.addProduct(new Product(3, "ordinateur", 1));
        //when
        int actualResult = objectUnderTest.productsQuantity();
        //then
        assertEquals(8, actualResult);
    }

    @Test
    void findProductByIdValidTest(){
        //given
        objectUnderTest.addProduct(new Product(1, "Bouteille", 5));
        objectUnderTest.addProduct(new Product(2, "Chaise", 2));
        objectUnderTest.addProduct(new Product(3, "ordinateur", 1));
        //when
        Optional<Product> actualResult = objectUnderTest.findProductById(2);
        //then
        assertNotNull(actualResult);
    }

    @Test
    void findProductByIdInValidTest(){
        //given
        objectUnderTest.addProduct(new Product(1, "Bouteille", 5));
        objectUnderTest.addProduct(new Product(2, "Chaise", 2));
        objectUnderTest.addProduct(new Product(3, "ordinateur", 1));
        //when
        Optional<Product> actualResult = objectUnderTest.findProductById(0);
        //then
        assertTrue(actualResult.isEmpty());
    }

    @Test
    void modifyProductQuantityValidTest(){
        //given
        objectUnderTest.addProduct(new Product(1, "Bouteille", 5));
        objectUnderTest.addProduct(new Product(2, "Chaise", 2));
        objectUnderTest.addProduct(new Product(3, "ordinateur", 1));
        Product expected = new Product(1, "Bouteille", 50);
        //when
        Product actualResult = objectUnderTest.modifyProductQuantity(1, 50);
        //then
        assertAll(
                () -> assertNotNull(actualResult),
                () -> assertEquals(expected, actualResult)
        );

    }

    @Test
    void modifyProductQuantityInValidTest(){
        //given
        objectUnderTest.addProduct(new Product(1, "Bouteille", 5));
        objectUnderTest.addProduct(new Product(2, "Chaise", 2));
        objectUnderTest.addProduct(new Product(3, "ordinateur", 1));
        //when
        Product actualResult = objectUnderTest.modifyProductQuantity(0, 5);
        //then
        assertNull(actualResult);
    }
}