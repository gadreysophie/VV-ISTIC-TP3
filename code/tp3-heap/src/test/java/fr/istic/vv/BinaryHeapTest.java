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
        comparator = (o1, o2) -> 0;
        binaryHeap = new BinaryHeap<>(comparator);
        element = 1;
    }

    @Test
    @DisplayName("test sur l'ajout d'un noeud")
    void testAjoutUnNoeud(){
        binaryHeap.push(element);
    }

    @Test
    @DisplayName("test sur le nombre de noeuds du graphe")
    void testCountNode(){
        binaryHeap.push(element);
        assertEquals(1,binaryHeap.count());
        binaryHeap.push(element);
        assertEquals(2, binaryHeap.count());
    }

    @Test
    @DisplayName("test sur le remove")
    void testRemove(){
        binaryHeap.push(element);
        binaryHeap.pop();
        assertEquals(0,binaryHeap.count());
    }

    @Test
    @DisplayName("test sur la méthode peek")
    void testPeek(){
        binaryHeap.push(element);
        assertEquals(element,binaryHeap.peek());
    }

    @Test
    @DisplayName("test sur la méthode pop")
    void testPop(){
        binaryHeap.push(element);
        int element1 = binaryHeap.pop();
        assertEquals(element,element1);
    }

    @Test
    @DisplayName("test sur la méthode pop avec plusieurs éléments")
    void testMultiplePop(){
        binaryHeap.push(element);
        binaryHeap.push(3);
        binaryHeap.push(5);
        binaryHeap.push(3);
        int element1 = binaryHeap.pop();
        assertEquals(element,element1);
    }

    @Test
    @DisplayName("test sur la méthode peek avec plusieurs éléments")
    void testMultiplePeek(){
        binaryHeap.push(element);
        binaryHeap.push(3);
        binaryHeap.push(5);
        binaryHeap.push(3);
        int element1 = binaryHeap.peek();
        assertEquals(element,element1);
    }


}