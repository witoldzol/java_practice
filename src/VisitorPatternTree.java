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
    int n = scanner.nextInt();

    /* Read values & colors */
    values = new int[n];
    colors = new Color[n];
    map = new HashMap<>(n);

    //get values
    for(int i=0; i<n;i++){
      values[i] = scanner.nextInt();
    }

    //get colors
    for(int i=0; i<n;i++){
      colors[i] = (scanner.nextInt() == 0) ? Color.RED : Color.GREEN;
    }

    // save edges
    for(int i=0; i<n-1;i++){
      int u = scanner.nextInt();
      int v = scanner.nextInt();

      //edges are undirected - so we have to save them in both directions
      HashSet uNeighbours = map.get(u);
      if(uNeighbours == null) {
        uNeighbours = new HashSet<>();
        map.put(u,uNeighbours);
      }
      uNeighbours.add(v);

      HashSet vNeighbours = map.get(v);
      if(vNeighbours == null) {
        vNeighbours = new HashSet<>();
        map.put(v,vNeighbours);
      }
      vNeighbours.add(u);
    }
    return null;
  }


  public static void main(String[] args) {
    Tree root = solve();
    SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
    ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
    FancyVisitor vis3 = new FancyVisitor();

    root.accept(vis1);
    root.accept(vis2);
    root.accept(vis3);

    int res1 = vis1.getResult();
    int res2 = vis2.getResult();
    int res3 = vis3.getResult();

    System.out.println(res1);
    System.out.println(res2);
    System.out.println(res3);
  }
}
