package com.bamzy;

import java.util.ArrayList;

public class FileNode {
    FileNode(String name, boolean isFile, int rank, FileNode parent) {
        value = name;
        this.isFile = isFile;
        this.rank = rank;
        this.parent = parent;
        children = new ArrayList<>();
    }
    String value;
    boolean isFile;
    FileNode parent;
    int rank;
    ArrayList<FileNode> children;
}
