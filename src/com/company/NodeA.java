package com.company;

import java.util.stream.Stream;

public class NodeA {
    private String Name;
    private String description;
    private int Id;


    public NodeA() {}

    public NodeA(String Name,int Id, String description) {
        this.Name = Name;
        this.description = description;
        this.Id = Id;

    }

    public String returnName() {
        return Name;
    }

    public String returnDescription() {
        return description;
    }
    public int returnId(){
        return Id;
    }



    public int[] intToArray(){
        String[] str1 = (description).split("");
        int[] intAr = Stream.of(str1).mapToInt(Integer::parseInt).toArray();
        return intAr;

    }

    public int[] retSpecificIndices(int[] indices){
        int[] desAr = intToArray();
        int[] SpecAr = new int[indices.length];
        for(int i = 0; i < indices.length; i++){
            SpecAr[i] = desAr[indices[i]];
        }
        return SpecAr;
    }

    public void printNodeA() {
        System.out.println("{" + Name + " " + description + " " + "}");
    }


}

