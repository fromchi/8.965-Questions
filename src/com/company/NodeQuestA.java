package com.company;

public class NodeQuestA {
        public int value;
        public String qBody;
        public int qnumber;
        public NodeQuestA left;
        public NodeQuestA right;

        NodeQuestA(){}

        NodeQuestA(int value, String qBody, int qnumber) {
            this.value = value;
            this.qBody = qBody;
            this.qnumber = qnumber;
            right = null;
            left = null;
        }
        NodeQuestA(int value, String qBody, int qnumber, NodeQuestA right, NodeQuestA left) {
        this.value = value;
        this.qBody = qBody;
        this.qnumber = qnumber;
        this.right = right;
        this.left = left;
        }

        public void printNode() {
            if(right == null && left == null) {
                System.out.println("{ "+ "ID: "+ value+ ", Body: "+qBody +", YesNode: null, NoNode: null }");
        }
            else if(right == null){
                System.out.println("{ "+ "ID: "+ value + ", Body: "+qBody+ ", YesNode: "+ left.value+ ", NoNode: null }");
        }
        else if(left == null) {
            System.out.println("{ "+ "ID: "+ value + ", Body: "+qBody+ ", YesNode: null, NoNode: " + right.value+" }");
        }
        else {
            System.out.println("{ "+ "ID: "+ value + ", Body: "+qBody+ ", YesNode: "+ right.value+ ", NoNode: "+ left.value+ " }");
        }
    }
}