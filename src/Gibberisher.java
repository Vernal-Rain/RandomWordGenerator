//Csci 1913 Project 3
//Elaine Lee

/**
 * Gibberisher class
 * */

public class Gibberisher
{
    private Trie<CharBag> model;
    private int segSize, samples;

    public Gibberisher(int segSize) //Constructor
    {
        this.model = new Trie<>();
        this.segSize = segSize;
        this.samples = 0;
    }

    public void train(LetterSample sample) //Adds sample to model
    {
        TrieNode<CharBag> node = model.getNode(sample.getSegment());
        if (node.getData() == null)
        {
            node.setData(new CharBag());
        }
        node.getData().add(sample.getNextLetter());
        samples++;
    }

    public void train(String s) //Adds letter samples from string to model
    {
        LetterSample[] samples = LetterSample.toSamples(s, segSize);
        for (LetterSample sample: samples)
        {
            train(sample);
        }
    }

    public void train(String[] s) //Adds letter samples from each string to model
    {
        for (String str: s)
        {
            train(str);
        }
    }

    public int getSampleCount() //Get samples
    {
        return samples;
    }

    public String generate() //Generate word using model
    {
        String word = "";
        TrieNode<CharBag> node = model.getRoot();
        char c = node.getData().getRandomChar();
        while (c != LetterSample.STOP)
        {
            word += c;
            if (word.length() < segSize)
            {
                node = node.getChild(c);
            }
            else
            {
                node = model.getNode(word.substring(word.length()-segSize, word.length()));
            }
            if (node.getData() == null)
            {
                return word;
            }
            c = node.getData().getRandomChar();
        }
        return word;
    }
}