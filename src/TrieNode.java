//Csci 1913 Project 3
//Elaine Lee

/**
 * Trie node class
 * */

public class TrieNode<T>
{
    private T data;
    private TrieNode<T>[] children;

    public TrieNode() //Constructor
    {
        this.data = null;
        this.children = new TrieNode[26];
    }

    public T getData() //Gets data
    {
        return data;
    }

    public void setData(T data) //Sets data
    {
        this.data = data;
    }

    public TrieNode<T> getChild(char c) //Makes new node if child is null, gets child
    {
        if (c < 'a' || c > 'z')
        {
            return null;
        }
        if (children[c-'a'] == null)
        {
            children[c-'a'] = new TrieNode<T>();
        }
        return children[c-'a'];
    }

    public int getTreeSize() //Gets tree size
    {
        int size = 1;
        for (TrieNode<T> child: children)
        {
            if (child != null)
            {
                size += child.getTreeSize();
            }
        }
        return size;
    }
}