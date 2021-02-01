package com.company;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class Main {

    static void fileReader(Map mapNA) throws IOException {
        File file = new File("C:\\Avatar_characters.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String[] space = sc.nextLine().split("\\s+");
            String newname = strip(space[1], '+');
            /*System.out.println("Number: " + space[2]);
            System.out.println("Spaced name: " + newname);
            System.out.println("Id" + space[0]);*/
            int nums = Integer.parseInt(space[0]);
            mapNA.put(nums, new NodeA(newname,nums,space[2]));
        }
    }

    static String strip(String unStripped, char specialChar) {
        String[] stringContent = unStripped.split("_");
        String cleanStr = "";
        for( int i = 0; i < stringContent.length; i++) {
            cleanStr = cleanStr.concat(stringContent[i])+ " ";
        }
        if(specialChar == '+') {
            return cleanStr;
        }
        return cleanStr+specialChar;
    }

    static void questionsReadIn(BinaryTreeA tree) throws IOException {
        File file = new File("C:\\AvatarQ.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String[] space = sc.nextLine().split("\\s+");
            /*System.out.println("Key: " + space[0]);
            System.out.println("Question: " + space[1]);
            System.out.println("Parent: " + space[2]);*/
            if (tree.root == null) {
                tree.root = new NodeQuestA(Integer.parseInt(space[0]), strip(space[1], '?'),Integer.parseInt(space[2]), null, null);
                /* System.out.println("root");
                tree.root.printNode();*/
            }
            else {
                tree.addNode(Integer.parseInt(space[0]),strip(space[1], '?'), Integer.parseInt(space[2]));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Map<Integer, NodeA> mapNA = new HashMap<Integer, NodeA>();
        BinaryTreeA tree = new BinaryTreeA();
        questionsReadIn(tree);
        fileReader(mapNA);
        int see[][] = tree.YesorNo(tree.root);
        for (int i = 0; i < see[0].length; i++) {
            System.out.print(see[0][i] + " ");
        }
        System.out.println("hello");
        for (int i = 0; i < see[1].length; i++) {
            System.out.print(see[1][i] + " ");
        }
        System.out.println("hello");

        for (NodeA value : mapNA.values()) {
            int[] comp = value.retSpecificIndices(see[0]);
            for (int i = 0; i < comp.length; i++) {
                System.out.print(comp[i]);
            }
            boolean retval = Arrays.equals(comp, see[1]);
            for (int i = 0; i < see[1].length; i++) {
                System.out.print(see[1][i]);
            }
            if (retval == true) {
                System.out.print(value.returnName());
            } else {
                //System.out.println(retval);
            }
        }
        System.out.println("hello");
    }
}

