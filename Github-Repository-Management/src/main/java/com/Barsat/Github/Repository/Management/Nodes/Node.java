package com.Barsat.Github.Repository.Management.Nodes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
public class Node {

    public String name;
    public boolean isDirectory;
    public Node parent;
    public String path;
    public String displayName;
    public String url;
    public Set<Node> children = new HashSet<>();

    public Node(String name , Node parent , boolean isDirectory , String path , String displayName , String url) {
        this.name = name;
        this.parent = parent;
        this.isDirectory = isDirectory;
        this.path = path;
        this.displayName = displayName;
        this.url = url;
    }

    public void addChildrenToParent(Node children){
        this.children.add(children);

    }

    @JsonIgnore
    public Node getParent(){
        return parent;
    }


    //recursion to get any node that is inside list of list.
    public Node accessAnyNode(String name){
        if(name.equals(this.name)){
            return this;
        }

        for(Node child : children){
            Node theNode = child.accessAnyNode(name);
            if (theNode != null) {
                return theNode;
            }

        }
        return null;
    }




    // Helper method  generate a string representation of the tree structure
    public String toStringHelper(Node node, int level) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < level; i++) {
            sb.append("  ");  // Two spaces per level of depth
        }


        sb.append(node.getName()).append("\n");
        sb.append(node.getUrl()).append("\n");
//        sb.append(node.getPath()).append("\n");
//        sb.append(node.isDirectory);




        for (Node child : node.getChildren()) {
            sb.append(toStringHelper(child, level + 1));  // Increase the level for child nodes
        }

        return sb.toString();
    }




}