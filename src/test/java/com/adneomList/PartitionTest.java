package com.adneomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class PartitionTest {
    private  ArrayList<Integer> list;
    private List<Integer> list2;

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
        list2 = Arrays.asList(1, 2, 3, 4, 5);
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

    @Test
    public void partitionEnStreamTest() {

        List<List<Integer>> subLists = Partition.partitionEnStream(list2,2);

        assertThat(subLists.size(), equalTo(3));


        subLists = Partition.partitionEnStream(list2,1);

        List<Integer> expectedPartition = Arrays.asList(1);
        assertThat(subLists.get(0).get(0), equalTo(expectedPartition.get(0)));
        assertThat(subLists.size(), equalTo(5));

    }


}