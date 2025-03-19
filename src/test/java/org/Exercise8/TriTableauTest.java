package org.Exercise8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriTableauTest {
    TriTableau objectUnderTest = new TriTableau();

    @Test
    void sortingArrayTest() {
        //given
        int[] numbers = {1,7,2,5,4,6,3};
        int[] expected = {1,2,3,4,5,6,7};
        //when
        int[] actualResult = objectUnderTest.sortingArray(numbers);
        //then
        assertArrayEquals(expected, actualResult);
    }

    @Test
    void sortingArrayWithSortedArrayTest() {
        //given
        int[] numbers = {1,2,3,4,5,6,7};
        int[] expected = {1,2,3,4,5,6,7};
        //when
        int[] actualResult = objectUnderTest.sortingArray(numbers);
        //then
        assertArrayEquals(expected, actualResult);
    }

    @Test
    void sortingArrayWithInversedArrayTest() {
        //given
        int[] numbers = {7,6,5,4,3,2,1};
        int[] expected = {1,2,3,4,5,6,7};
        //when
        int[] actualResult = objectUnderTest.sortingArray(numbers);
        //then
        assertArrayEquals(expected, actualResult);
    }

    @Test
    void sortingArrayWithDoublesArrayTest() {
        //given
        int[] numbers = {7,8,5,5,3,1,2,1};
        int[] expected = {1,1,2,3,5,5,7,8};
        //when
        int[] actualResult = objectUnderTest.sortingArray(numbers);
        //then
        assertArrayEquals(expected, actualResult);
    }

    @Test
    void sortingArrayWithEmptyArrayTest() {
        //given
        int[] numbers = {};
        int[] expected = {};
        //when
        int[] actualResult = objectUnderTest.sortingArray(numbers);
        //then
        assertArrayEquals(expected, actualResult);
    }

    @Test
    void sortingArrayWithOneValueTest() {
        //given
        int[] numbers = {5};
        int[] expected = {5};
        //when
        int[] actualResult = objectUnderTest.sortingArray(numbers);
        //then
        assertArrayEquals(expected, actualResult);
    }
}