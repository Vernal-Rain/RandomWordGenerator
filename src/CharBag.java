//Csci 1913 Project 3
//Elaine Lee

import java.util.Random;
/**
 * Char bag class
 * */

public class CharBag
{
    private int[] count;
    private int size;

    public CharBag() //Constructor
    {
        this.count = new int[27];
        this.size = 0;
    }

    private int index(char c) //Converts char to index value
    {
        return (Character.isAlphabetic(c)? Character.toLowerCase(c)-'a': 26);
    }

    public void add(char c) //Increments count of char
    {
        count[index(c)]++;
        size++;
    }

    public void remove(char c) //Decrements count of char if count > 0
    {
        if (count[index(c)] > 0)
        {
            count[index(c)]--;
            size--;
        }
    }

    public int getCount(char c) //Get count
    {
        return count[index(c)];
    }

    public int getSize() //Get number of chars stored
    {
        return size;
    }

    public char getRandomChar() //Get random char based on probability
    {
        if (getSize() == 0)
        {
            return LetterSample.STOP;
        }
        Random random = new Random();
        int rand = random.nextInt(getSize())+1;
        int ind = 0;
        rand -= count[ind];
        while (rand > 0)
        {
            ind++;
            rand -= count[ind];
        }
        return (ind < 26? (char)('a'+ind): LetterSample.STOP);
    }

    public String toString() //Format: CharBag{a:count_a, b:count_a, ...}
    {
        String s = "CharBag{";
        for (int i = 0; i < count.length-1; i++)
        {
            s += ((char)('a'+i)) + ":" + count[i] + ", ";
        }
        return s + LetterSample.STOP + ":" + count[26] + "}";
    }
}