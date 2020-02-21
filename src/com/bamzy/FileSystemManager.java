package com.bamzy;
/*Suppose we represent our file system as a string. For example, the string
"user\n\t
    pictures\n\t
    documents\n\t\
        tnotes.txt" represents:

user
    pictures
    documents
        notes.txt

The directory user contains an empty sub-directory pictures and a sub-directory
documents containing a file notes.txt.

The string
"user\n\t
    pictures\n\t\t
        photo.png\n\t\t
        camera\n\t
    documents\n\t\t
        lectures\n\t\t\t
                notes.txt"
represents:

user
    pictures
        photo.png
        camera
    documents
        lectures
            notes.txt

The directory user contains two sub-directories pictures and documents. pictures
contains a file photo.png and an empty second-level sub-directory camera. documents
contains a second-level sub-directory lectures containing a file notes.txt.

We want to find the longest (as determined by the number of characters) absolute path
to a file within our system. For example, in the second example above, the longest absolute
path is "user/documents/lectures/notes.txt", and its length is 33 (not including the double quotes).

Given a string representing the file system in this format, return the length of the longest
absolute path to a file in the abstracted file system. If there is not a file in the file system,
return 0.

Note: Due to system limitations, test cases use form feeds ('\f', ASCII code 12) instead of newline
characters.

Example

For fileSystem = "user\f\tpictures\f\tdocuments\f\t\tnotes.txt", the output should be
longestPath(fileSystem) = 24.

The longest path is "user/documents/notes.txt", and it consists of 24 characters.*/

import java.io.File;
import java.util.ArrayList;

public class FileSystemManager {
//    String carriageReturn = String.valueOf((char)12);
    String carriageReturn = "\n";
    class FileNode {
        FileNode(String name,boolean isFile, int rank,FileNode parent) {
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
    void parseRest(String text, FileNode parent){
        int count = 0;
        while (text.substring(0, 1).equals("\t")){
            count++;
            text = text.substring(1);
        }
        int index = text.indexOf(carriageReturn);

        String name;
        if (index != -1 )
            name= text.substring(0, index);
        else
            name = text;
        FileNode newElement = null ;
        if (name.contains(".")){
            if (count == parent.rank + 1 || (count == parent.rank && count == 0) ) {
                newElement = new FileNode(name, true, count,parent);
                parent.children.add(newElement);
            } else {
                newElement = new FileNode(name, true, count,parent);
                while (parent.rank +1!= count)
                    parent = parent.parent;
                parent.children.add(newElement);
            }

        } else {
            if (count == parent.rank + 1) {
                newElement = new FileNode(name, false, count, parent);
                parent.children.add(newElement);
            } else {
                newElement = new FileNode(name, false, count,parent);
                while (parent.rank +1 != count)
                    parent = parent.parent;
                parent.children.add(newElement);
            }

        }
        if (text.indexOf(carriageReturn) != -1)
            parseRest(text.substring(text.indexOf(carriageReturn)+1),newElement);

    }
    int longestPath(String fileSystem) {
        if (!fileSystem.contains(carriageReturn)){
            if (fileSystem.contains("."))
                return fileSystem.length();
            else
                return 0;
        }
        int endIndex = fileSystem.indexOf(carriageReturn);
        String first = fileSystem.substring(0, endIndex);
        FileNode root = new FileNode(first,false, 0, null);
        parseRest(fileSystem.substring(endIndex+1),root);

        recTraverse(root,"");
        if (maxSize != 0 )
            return maxSize-1;
        else
            return 0;
    }
    int maxSize=0;
    void recTraverse(FileNode t, String path){
        path = path + "/" + t.value;
        if (t.children.size() == 0 && t.isFile){
            if (path.length() > maxSize) {
                maxSize = path.replace(" ","").length();
                System.out.println(path);
            }

        } else {
            for (FileNode child : t.children) {
                recTraverse(child,path);

            }
        }
    }
}
