package com.mkyong.editor;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "editor")
public class EditorBean {

    private TreeNode root;
    private TreeNode selectedNode;
    private Boolean disabled = true;

    public EditorBean() {
        root = new DefaultTreeNode("Root", null);
        root.setSelectable(false);
        TreeNode node0 = new DefaultTreeNode("Node 0", root);
//		node0.setSelectable(false);
        TreeNode node1 = new DefaultTreeNode("Node 1", root);
        TreeNode node2 = new DefaultTreeNode("directItem", "Node 2", root);

        TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
        TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);

        TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);
        TreeNode node11 = new DefaultTreeNode("directItem", "Node 1.1", node1);

        TreeNode node000 = new DefaultTreeNode("directItem", "Node 0.0.0", node00);
        TreeNode node001 = new DefaultTreeNode("directItem", "Node 0.0.1", node00);
        TreeNode node010 = new DefaultTreeNode("directItem", "Node 0.1.0", node01);

        TreeNode node100 = new DefaultTreeNode("directItem", "Node 1.0.0", node10);
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void onSelect(NodeSelectEvent selectedNode) {
        TreeNode treeNode = selectedNode.getTreeNode();
        disabled = !treeNode.getChildren().isEmpty();
        this.selectedNode = treeNode;
    }

    public void onRowSelect(NodeSelectEvent event) {
        disabled = false;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

}