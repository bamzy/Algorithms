package com.bamzy.google;
/**
 * Suppose we have a file system that stores both files and directories.
 * An example of one system is represented in the following picture:
 *
 * Here, we have dir as the only directory in the root. dir contains two subdirectories, subdir1 and subdir2. subdir1 contains a file file1.ext and subdirectory subsubdir1. subdir2 contains a subdirectory subsubdir2, which contains a file file2.ext.
 * In text form, it looks like this (with ⟶ representing the tab character):
 * dir
 * ⟶ subdir1
 * ⟶ ⟶ file1.ext
 * ⟶ ⟶ subsubdir1
 * ⟶ subdir2
 * ⟶ ⟶ subsubdir2
 * ⟶ ⟶ ⟶ file2.ext
 * If we were to write this representation in code, it will look like this: "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext". Note that the '\n' and '\t' are the new-line and tab characters.
 * Every file and directory has a unique absolute path in the file system, which is the order of directories that must be opened to reach the file/directory itself, all concatenated by '/'s. Using the above example, the absolute path to file2.ext is "dir/subdir2/subsubdir2/file2.ext". Each directory name consists of letters, digits, and/or spaces. Each file name is of the form name.extension, where name and extension consist of letters, digits, and/or spaces.
 * Given a string input representing the file system in the explained format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.
 * Note that the testcases are generated such that the file system is valid and no file or directory name has length 0.
 *
 * Example 1:
 *
 * Input: input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
 * Output: 20
 * Explanation: We have only one file, and the absolute path is "dir/subdir2/file.ext" of length 20.
 * Example 2:
 *
 * Input: input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * Output: 32
 * Explanation: We have two files:
 * "dir/subdir1/file1.ext" of length 21
 * "dir/subdir2/subsubdir2/file2.ext" of length 32.
 * We return 32 since it is the longest absolute path to a file.
 * Example 3:
 * Input: input = "a"
 * Output: 0
 * Explanation: We do not have any files, just a single directory named "a".
 *
 * Constraints:
 * •	1 <= input.length <= 104
 * •	input may contain lowercase or uppercase English letters, a new line character '\n', a tab character '\t', a dot '.', a space ' ', and digits.
 * •	All file and directory names have positive length.
 */

import java.util.ArrayList;

public class BuildDirectoryTreeFromString {
    int longestFileAddress = 0;
    private class DirectoryNode {
        String name;

        ArrayList<DirectoryNode> children;
        int depth;
        public DirectoryNode(String name, int depth){
            this.children = new ArrayList<>();
            this.name = name.replace("\t","");
            this.depth = depth;
        }
        public void add(DirectoryNode child){
            this.children.add(child);
        }
    }
    public int solve(String s){
        this.longestFileAddress = 0;
        dfs(build(s),0);
        return this.longestFileAddress;
    }

    public DirectoryNode build(String s){
        String[] names =  s.split("\n");
        DirectoryNode root = new DirectoryNode(names[0],0);
        buildRec(names,1,root);
        return root;


    }
    public void dfs(DirectoryNode root,int length){
        if(root.children.size()==0 && isValidFileName(root.name)){
            this.longestFileAddress = Math.max(length+root.name.length(),this.longestFileAddress);
            return;
        } else {
            for (int i =0 ; i<root.children.size();i++){
                dfs(root.children.get(i),length+root.name.length()+1);
            }
        }
    }
    /**
     *
     * dir
     *      dir1
     *              child1
     *              child2
     *                      child7
     *      dir2
     *              child3
     *              child4
     *                      child5
     *      dir3
     */
    private void buildRec(String[] names, int current, DirectoryNode parent){
        DirectoryNode last = null;
        if(current>= names.length) return;
        for(int i = current;i<names.length;i++){
            int currentDepth = countLevel(names[i]);
            if(currentDepth == parent.depth+1) {
                last = new DirectoryNode(names[i],currentDepth);
                parent.add(last);
                if(!isValidFileName(names[i])) buildRec(names,i+1,last);
            } else if( currentDepth<= parent.depth) return;


        }
    }
    private boolean isValidFileName(String name){
        if(name.contains(".")) return true;
        return false;
    }
    private int countLevel(String input){
        int count = 0;
        for(int i = 0 ; i< input.length()-1 ; i++){
            if(input.charAt(i) == '\t' ) count++;
        }
        return count;

    }
    public static void runTest(){
        BuildDirectoryTreeFromString bdfs = new BuildDirectoryTreeFromString();
        System.out.println(bdfs.solve("dir\n\tdir1\n\t\tchild1\n\t\tchild2\n\t\t\tchild7\n\tdir2\n\t\tchild3\n\t\tchild4\n\t\t\tchild5\n\tdir3"));
        System.out.println(bdfs.solve("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(bdfs.solve("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(bdfs.solve("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
