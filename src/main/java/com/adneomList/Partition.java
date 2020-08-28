package com.adneomList;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    public static List<ArrayList<Integer>> partition(ArrayList<Integer> list, int taille){


        ArrayList<Integer> subListElements=null;
        List<ArrayList<Integer>> subList = new ArrayList<ArrayList<Integer>>();

        if(list.isEmpty()){
            System.out.println("Attention la liste est vide");
        }
        else if (taille>list.size()){
            System.out.println("Veuillez choisir une taille moins que le size de la list");
        }
        else {
            /*
            Looping through our list
             */
            for (int i = 0; i < list.size(); ) {
                subListElements = new ArrayList<Integer>(); // Creation de la sous list.
                for (int j = 0; j < taille; j++) {
                    if (i == list.size()) break;
                    subListElements.add(list.get(i));
                    i++;
                }
                subList.add(subListElements);
            }
        }

        return subList;
    }

}
