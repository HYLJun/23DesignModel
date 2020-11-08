package 结构模式7种;

import java.util.Vector;

/**
 * 组合模式 也称部分-整体模式，在处理类似树形结构的问题比较方便
 */
class TreeNode {
    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children = new Vector<>();

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    //添加子节点
    public void add(TreeNode node) {
        children.add(node);
    }


    //删除子节点
    public void remove(TreeNode node) {
        children.remove(node);
    }
}

class Tree {
    TreeNode root = null;

    public Tree(String name) {
        this.root = new TreeNode(name);
    }
}

public class A11组合模式Composite {
    public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);
        System.out.println("build the tree finish");

    }
}

