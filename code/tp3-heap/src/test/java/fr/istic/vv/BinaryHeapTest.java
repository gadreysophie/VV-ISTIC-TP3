package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    Integer element;
    Comparator<Integer> comparator;
    BinaryHeap<Integer> binaryHeap;

    @BeforeEach
    void init(){
        binaryHeap = new BinaryHeap<>(comparator);
        element = 1;
    }

    @Test
    @DisplayName("test sur l'ajout d'un noeud")
    void testAjoutUnNoeud(){
        binaryHeap.push(element);
    }

}