import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
  RED, GREEN
}

abstract class Tree {

  private int value;
  private Color color;
  private int depth;

  public Tree(int value, Color color, int depth) {
    this.value = value;
    this.color = color;
    this.depth = depth;
  }

  public int getValue() {
    return value;
  }

  public Color getColor() {
    return color;
  }

  public int getDepth() {
    return depth;
  }

  public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

  private ArrayList<Tree> children = new ArrayList<>();

  public TreeNode(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitNode(this);

    for (Tree child : children) {
      child.accept(visitor);
    }
  }

  public void addChild(Tree child) {
    children.add(child);
  }
}

class TreeLeaf extends Tree {

  public TreeLeaf(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitLeaf(this);
  }
}

abstract class TreeVis
{
  public abstract int getResult();
  public abstract void visitNode(TreeNode node);
  public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
  int result = 0;

  public int getResult() {
    //implement this
    return result;
  }

  public void visitNode(TreeNode node) {
    System.out.print("Current result " + this.result);
    System.out.print("Value " + node.getValue());
    this.result += node.getValue();
  }

  public void visitLeaf(TreeLeaf leaf) {
    System.out.print("Current result " + this.result);
    System.out.print("Value " + leaf.getValue());
    this.result += leaf.getValue();
  }
}

class ProductOfRedNodesVisitor extends TreeVis {
  public int getResult() {
    //implement this
    return 1;
  }

  public void visitNode(TreeNode node) {
    //implement this
  }

  public void visitLeaf(TreeLeaf leaf) {
    //implement this
  }
}

class FancyVisitor extends TreeVis {
  public int getResult() {
    //implement this
    return 0;
  }

  public void visitNode(TreeNode node) {
    //implement this
  }

  public void visitLeaf(TreeLeaf leaf) {
    //implement this
  }
}

public class Solution {

  private static int[] values;
  private static Color[] colors;
  private static HashMap<Integer, HashSet<Integer>> map;

  public static Tree solve() {
    Scanner scanner = new Scanner(System.in);
    int numNodes = scanner.nextInt();

    /* Read values & colors */
    values = new int[numNodes];
    colors = new Color[numNodes];
    map = new HashMap<>(numNodes);

    //get values
    for(int i=0; i<numNodes;i++){
      values[i] = scanner.nextInt();
    }
    //get colors
    for(int i=0; i<n;i++){
      colors[i] = (scanner.nextInt() == 0) ? Color.RED : Color.GREEN;
    }
    //get rid of empty line
    scanner.nextLine();
    //get edges ( there are n -1 edges )
    for(int i=1; i<n;i++){
      ArrayList<Integer> edge = parseToEdge(scanner.nextLine());
      Integer parent = edge.get(0);
      Integer child = edge.get(1);

      if(edges.containsKey(parent)){
        ArrayList<Integer> updated = edges.get(parent);
        updated.add(child);
        edges.put(parent,updated);
      } else {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(child);
        edges.put(parent,list);
      }
    }

    TreeMap<Integer,ArrayList<Integer>> sorted = new TreeMap<>();
    sorted.putAll(edges);
    Map<Integer,Integer> depths = new HashMap<>();
    if(edges.size()>0){
      depths.put(1,0);
    }
    Set<Tree> tree = new HashSet<>();
    //create nodes & leafes
    for(int k : sorted.keySet()){
      int parentDepth = depths.get(k);
      Color color = Color.values()[colors[k-1]];
      for(int child : edges.get(k)) {
        // insert depth for children, relative to their parent
        depths.put(child,parentDepth+1);
        //check if we have leaf
        boolean isLeaf = edges.get(child) == null;
        Color leafColor = Color.values()[colors[child-1]];
        Tree nodeChild = (isLeaf) ?
                new TreeLeaf(values[child-1], leafColor, parentDepth+1) :
                new TreeNode(values[child-1], leafColor, parentDepth+1);
        //add the child to parent
        node.addChild(nodeChild);
      }
    }
    return parent;
  }

  private static ArrayList<Integer> parseToEdge(String str){
    String[] chunks = str.split(" ");
    ArrayList<Integer> edge = new ArrayList<>();
    for(String s: chunks){
      edge.add(Integer.parseInt(s));
    }
    return edge;
  }

