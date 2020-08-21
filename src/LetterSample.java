//Csci 1913 Project 3
//Elaine Lee

/**
 * Letter sample class
 * */

public class LetterSample
{
    private String segment;
    private char next;
    public static final char STOP = '.';

    public LetterSample(String segment, char next) //Constructor
    {
        this.segment = segment;
        this.next = next;
    }

    public String getSegment() //Gets string segment
    {
        return segment;
    }

    public char getNextLetter() //Gets next letter
    {
        return next;
    }

    public static LetterSample[] toSamples(String s, int segSize) //Makes array of LetterSamples from string
    {
        LetterSample[] samples;
        LetterSample sample;
        String temp = "";
        for (char c: s.toLowerCase().toCharArray())
        {
            if (Character.isAlphabetic(c))
            {
                temp += c;
            }
        }
        temp += STOP;
        samples = new LetterSample[temp.length()];

        for (int i = 0; i < temp.length(); i++)
        {
            if (i < segSize)
            {
                sample = new LetterSample(temp.substring(0, i), temp.charAt(i));
            }
            else
            {
                sample = new LetterSample(temp.substring(i-segSize, i), temp.charAt(i));
            }
            samples[i] = sample;
        }
        return samples;
    }

    public String toString() //Format: "segment" -> next
    {
        return "\"" + segment + "\" -> " + next;
    }
}