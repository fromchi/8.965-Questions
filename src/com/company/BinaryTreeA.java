package com.company;
import java.util.Scanner;

public class BinaryTreeA {
    public NodeQuestA root;

    BinaryTreeA() {
        root = null;
    }

    BinaryTreeA(int key, String body, int qnumber) {
        root = new NodeQuestA(key, body, qnumber);

    }

    private NodeQuestA addR(NodeQuestA current, int value, String body, int qnumber) {
        if (current == null) {
            return new NodeQuestA(value, body, qnumber);
        }

        if (value < current.value) {
            current.left = addR(current.left, value, body, qnumber);
        }
        else if (value > current.value) {
            current.right = addR(current.right, value, body, qnumber);
        }
        else {
            return current;
        }

        return current;
    }


    public void addNode(int value, String Body, int qnumber) {
        root = addR(root, value, Body, qnumber);
    }


    /*print method*/
    public static void findFullNode(NodeQuestA root) {
        if (root != null) {
            root.printNode();
            findFullNode(root.left);
            if (root.left != null && root.right != null)
                findFullNode(root.right);
        }
    }

    public int[][] YesorNo(NodeQuestA root){
        int[] Qvalues = new int[50], compare = new int[50];
        int i = 0, j = 0;
        NodeQuestA newRoot = root;
        Scanner myObj = new Scanner(System.in);
        String userName;
        System.out.println(newRoot.qBody);
        Qvalues[i] = newRoot.qnumber;
        i++;
        while(newRoot != null) {
            userName = myObj.nextLine();
            if((userName.equals("Yes")) || (userName.equals("yes"))) {
                newRoot = newRoot.left;
                compare[j] = 0;
                if(newRoot == null){
                    System.out.println("And the guess is...");
                }
                else {
                    System.out.println(newRoot.qBody);
                    compare[j] = 0;
                    Qvalues[i] = newRoot.qnumber;
                    i++;
                    j++;
              }
          }
            else if((userName.equals("no")) || (userName.equals("No"))) {
                newRoot = newRoot.right;
                compare[j] = 1;
                if(newRoot == null) {
                    System.out.println("And the guess is...");
              }
                else {
                    System.out.println(newRoot.qBody);
                    Qvalues[i] = newRoot.qnumber;
                    i++;
                    j++;
                }
            }
            else {
                System.out.println("Try again typing Yes/No/yes/no");
            }
        }
        int QvalFinal[] = new int[i], YNval[] = new int[i];
        System.arraycopy(compare, 0, YNval, 0, i);
        System.arraycopy(Qvalues, 0, QvalFinal, 0, i);
        int[][] pair = {QvalFinal, YNval};
        return pair;
    }
}
