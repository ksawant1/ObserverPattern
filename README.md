# CSX42: Assignment 2
**Name:Krupa Sawant
**B-Number:B00 814013
** Use of 3 Slack Days

-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.

Note: build.xml is present in (./studentskills/src/) folder.

## Instruction to clean:

```commandline
ant -buildfile channelpopularity/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
ant -buildfile channelpopularity/src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile channelpopularity/src/build.xml run -Dinput="input.txt" -Dmodify="modify.txt" -Dout1="output0.txt" -Dout2="output1.txt" -Dout3="output2.txt" -Derror="error.txt"

```
Note: Arguments accept the absolute path of the files.


## Description:
## Assumptions
    1. Each line of input contains one operation per line.
    2. The input line doesn't contain spaces.
    3. Haven't completed the debug part so program accepts 5 inputs- input.txt, modify.txt, outputfiles and error files
    
## Program FLow
 1. Driver code accepts line of input from File Processor and sends to Helper class.
 2. Helper Class processes every line of input and calls the corresponding action to be performed to Tree Helper.
 3. The Tree Helper class inserting nodes into tree instances and searching for bnumber from corresponding trees.
 4. If a value already exists in a tree, fot both insert and modify we need to update the value and notify listeners.
 5. If value is not present we clone it twice, register the listeners for every node and insert into tree. 
 6. Tree class and Treenode which is a helper to tree helps building the tree recursively.
 4. Result Class writes to output file and console.
 5. Data structure used is array list for output.
 
 ## Use of Binary Search Tree for insertion, search
 1. Binary tree is a data structure composed of nodes that has the following properties
 -Each tree has a root node at the top containing some value (in our case student record with bnumber as the key).
 -The root node has zero or more child nodes which itself has more children.
 - Every node has its own subtree made of left and right branches.
  2.BST allows for fast lookup, insertion and removal of nodes. 
  3.On average, each comparison allows the operations to skip about half of the tree, so it takes time proportional to the logarithm of the number of items stored in the tree O(log n).
  4.worst case scenario happens when tree is unbalanced.
  5.For search, you visit the root node, if value matches you return the node else if value is less than root key value you search 
  on the left else you go to the right of the root node and recursively search
  6.For insertion, you see which node is null and if it's null you create a new node based on whether it should accommodate the left subtree or
  right.
  7. To print in order, we first go to the left, then the root and then towards right so it prints in ascending order.
  References: https://www.freecodecamp.org/news/binary-search-trees-bst-explained-with-examples/
  https://www.moreofless.co.uk/binary-search-tree-bst-java/
  
## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [7/14/2020]


