package com.bamzy;

import java.util.List;

public class Main {

    public static void main(String[] args) {
       ConstructBinaryFromPreorderAndInorder constructBinaryFromPreorderAndInorder = new ConstructBinaryFromPreorderAndInorder();
       constructBinaryFromPreorderAndInorder.buildTree(new int[]{1}, new int[]{1});
    }
}
