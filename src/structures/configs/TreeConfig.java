package structures.configs;

import structures.nodes.BNode;
import structures.trees.BTree;

import java.util.ArrayList;
import java.util.List;

public class TreeConfig {
    private static BTree bTree;
    public static <T> BTree setTreeConfig(int treeStep, List<T> keys ){
        BNode<T> bNode=new BNode<T>(treeStep, keys, new ArrayList<BNode<T>>(), true  );
        return new BTree(bNode);
    }
}
