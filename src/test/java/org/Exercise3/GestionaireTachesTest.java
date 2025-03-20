package org.Exercise3;

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
}