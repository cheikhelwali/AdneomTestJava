package com.adneomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PartitionTest {
    private  ArrayList<Integer> list;

    @Before
    public void init() {
        System.out.println("Creation et initialization d'une List");
        list = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
    }

    @Test
    public void testPartition() {

        List<ArrayList<Integer>> subLists = Partition.partition(list,2);
        System.out.println("sublists pour une taille de 2 : "+subLists);
        assertTrue(subLists.size()==3); // Il faut qu'on a une list de 3 sous list  [ [1,2], [3,4], [5] ]

        subLists = Partition.partition(list,3);
        System.out.println("sublists pour une taille de 3 : "+subLists);
        assertTrue(subLists.size()==2); // Il faut qu'on a une list de 2 sous list  [ [1,2,3], [4,5] ]

        subLists = Partition.partition(list,1);
        System.out.println("sublists pour une taille de 1 : "+subLists);
        assertTrue(subLists.size()==5); // Il faut qu'on a une list de 5 sous list  [ [1], [2], [3], [4], [5] ]

        subLists = Partition.partition(list,6); // On aura un message pour choisir une taille inférieur à la taille de list
        assertTrue(subLists.isEmpty());

    }
}