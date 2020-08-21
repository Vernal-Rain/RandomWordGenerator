//Csci 1913 Project 3
//Elaine Lee

/**
 * Trie class
 * */

public class Trie<T>
{
    private TrieNode<T> root;

    public Trie() //Constructor
    {
        this.root = new TrieNode<>();
    }

    public TrieNode<T> getNode(String s) //Gets node based on string
    {
        TrieNode<T> node = root;
        for (char c: s.toCharArray())
        {
            node = node.getChild(c);
        }
        return node;
    }

    public T get(String s) //Gets data on node
    {
        return getNode(s).getData();
    }

    public void put(String s, T t) //Sets data on node
    {
        getNode(s).setData(t);
    }

    public TrieNode<T> getRoot() //Gets root node
    {
        return root;
    }
}