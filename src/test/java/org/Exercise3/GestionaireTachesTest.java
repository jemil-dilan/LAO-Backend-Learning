package org.Exercise3;

import org.Exercise7.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GestionaireTachesTest {
    GestionaireTaches objectUnderTest = new GestionaireTaches();

    @Test
    void addedTaskTest(){
        //Given
        objectUnderTest.addTask(new Tache("Acheter telephone",
                Status.EN_COURS));
        objectUnderTest.addTask(new Tache("faire des course",
                Status.TERMINER));
        objectUnderTest.addTask(new Tache("Laver habit",
                Status.ANNULER));

        //When
        List<Tache> actualResult = objectUnderTest.getTaches();
        //Then
        assertEquals(3, actualResult.size());
    }

    @Test
    void deletedTaskTest(){
        //Given
        objectUnderTest.addTask(new Tache("Acheter telephone",
                Status.EN_COURS));
        objectUnderTest.addTask(new Tache("faire des course",
                Status.TERMINER));
        objectUnderTest.addTask(new Tache("Laver habit",
                Status.ANNULER));

        //When
        objectUnderTest.deleteTask("faire des course");
        List<Tache> actualResult = objectUnderTest.getTaches();
        //Then
        assertEquals(2, actualResult.size());
    }

    @Test
    void markTaskAsFinishedTest(){
        //Given
        objectUnderTest.addTask(new Tache("Acheter telephone",
                Status.EN_COURS));
        objectUnderTest.addTask(new Tache("faire des course",
                Status.TERMINER));
        objectUnderTest.addTask(new Tache("Laver habit",
                Status.ANNULER));

        //When
        objectUnderTest.markTaskAsFinished("Acheter telephone");
        Status actualResult = objectUnderTest.getTaskStatusByDescription("Acheter telephone");
        //Then
        assertEquals(Status.TERMINER, actualResult);
    }

    @Test
    void markTaskAsFinishedWithErrorTest(){
        //Given
        objectUnderTest.addTask(new Tache("Acheter telephone",
                Status.EN_COURS));
        objectUnderTest.addTask(new Tache("faire des course",
                Status.TERMINER));
        objectUnderTest.addTask(new Tache("Laver habit",
                Status.ANNULER));

        //When
        objectUnderTest.markTaskAsFinished("Acheter telephone");
        //Then
        assertThrows(RuntimeException.class, () -> objectUnderTest.getTaskStatusByDescription("Acheter billet"));
    }

    @Test
    void findByIdTestWithValidInformation(){
        //given
        objectUnderTest.addTask(new Tache("Acheter telephone",
                Status.EN_COURS));
        objectUnderTest.addTask(new Tache("faire des course",
                Status.TERMINER));
        objectUnderTest.addTask(new Tache("Laver habit",
                Status.ANNULER));
        //when
        Optional<Tache> actualResult = objectUnderTest.findTaskById("Acheter telephone");
        //then
        assertNotNull(actualResult);
    }

    @Test
    void findByIdTestWithInvalidInformation(){
        //given
        objectUnderTest.addTask(new Tache("Acheter telephone",
                Status.EN_COURS));
        objectUnderTest.addTask(new Tache("faire des course",
                Status.TERMINER));
        objectUnderTest.addTask(new Tache("Laver habit",
                Status.ANNULER));
        //when
        Optional<Tache> actualResult = objectUnderTest.findTaskById(null);
        //then
        assertTrue(actualResult.isEmpty());
    }

    @Test
    void modifyProductQuantityValidTest(){
        //given
        objectUnderTest.addTask(new Tache("Acheter telephone",
                Status.EN_COURS));
        objectUnderTest.addTask(new Tache("faire des course",
                Status.TERMINER));
        objectUnderTest.addTask(new Tache("Laver habit",
                Status.ANNULER));
        Tache expected = new Tache("Lire", Status.EN_COURS);
        //when
        Tache actualResult = objectUnderTest.modifyTaskDescription("Acheter telephone",
                "Lire");
        //then
        assertAll(
                () -> assertNotNull(actualResult),
                () -> assertEquals(expected, actualResult)
        );

        ;
    }

    @Test
    void modifyProductQuantityInValidTest(){
        //given
        objectUnderTest.addTask(new Tache("Acheter telephone",
                Status.EN_COURS));
        objectUnderTest.addTask(new Tache("faire des course",
                Status.TERMINER));
        objectUnderTest.addTask(new Tache("Laver habit",
                Status.ANNULER));
        //when
        Tache actualResult = objectUnderTest.modifyTaskDescription("vendre",
                "Coder");
        //then
        assertNull(actualResult);
    }
}