package NeetCode.Stack.medium;

import java.util.Stack;

// The simplified canonical path should follow these rules:

// The path must start with a single slash '/'.
// Directories within the path must be separated by exactly one slash '/'.
// The path must not end with a slash '/', unless it is the root directory.
// The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.


//TC: O(n)
//SC: (n)

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] pathArr = path.split("/");
        for(String currDir:pathArr){
            if(currDir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!currDir.equals(".") && !currDir.equals("")){
                stack.push(currDir);
            }
        }

        if(stack.isEmpty()){
            return "/";
        }


        StringBuilder cb = new StringBuilder();
        for(String dir:stack){
            cb.append("/");
            cb.append(dir);
        }

        return cb.toString();
    }





}
