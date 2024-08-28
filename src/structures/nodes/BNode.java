package structures.nodes;

import java.util.*;

/**
 * Represents node in BTree
 * Use Di to configure minimum degree t, the custom List for different sorting and searching methods
 *
 * @param <T>
 */
public class BNode<T> {
    private  boolean  isLeaf;
    private int treesStep;
    private List<T> keys;
    private List<BNode<T>> kids;

    /**
     * Constructs BNode with its dependencies
     *
     * @param treesStep minimum degree of BTree
     * @param keys a specified List with keys
     * @param kids a specified List with kids
     * @param isLeaf boolean paramets, which indicate is a node a leaf
     */
    public BNode(Integer treesStep, List<T> keys, List<BNode<T>> kids, Boolean isLeaf){
        if(isLeaf==null){
            throw new IllegalArgumentException("DI error: isLeaf was not implemented");
        }
        if(treesStep==null){
            throw new IllegalArgumentException("DI error: treesStep was not implemented");
        }
        if(keys==null){
            throw new IllegalArgumentException("DI error: List<T> keys was not implemented");
        }
        if(kids==null){
            throw new IllegalArgumentException("DI error: List<T> keys was not implemented");
        }
        this.treesStep = treesStep;
        this.kids = kids;
        this.keys = keys;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public int getTreesStep() {
        return treesStep;
    }

    public List<T> getKeys() {
        return keys;
    }

    public void addKeys(T key) {
        this.keys.add(key);
    }

    public List<BNode<T>> getKids() {
        return kids;
    }

    public void addKids(BNode<T> bNode) {
        this.kids.add(bNode);
    }
}
