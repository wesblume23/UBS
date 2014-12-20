package com.ubs.opsit.interviews.wordfrequency;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WordFrequencyTest 
{
	
    @Test
    public void count() //determine if class accurately counts number of occurrences
    {
    	countWords counter = new countWords();
    	Map<String, Integer> words = counter.countOccurrencesOfWordsWithin("This is a sentence");
        
    	Assert.assertEquals(words.size(),4);
    	Assert.assertEquals(1, words.get("sentence"),0);
    	Assert.assertEquals(1, words.get("this"),0);
    	Assert.assertEquals(1, words.get("is"),0);
    	Assert.assertEquals(1, words.get("a"),0);
    	
    	words = counter.countOccurrencesOfWordsWithin("This is the sentence");
    	Assert.assertEquals(words.size(),5);
    	Assert.assertEquals(2, words.get("sentence"),0);
    	Assert.assertEquals(2, words.get("this"),0);
    	Assert.assertEquals(2, words.get("is"),0);
    	Assert.assertEquals(1, words.get("a"),0);
    	Assert.assertEquals(1, words.get("the"),0);	
    }
    
    @Test
    public void duplicates() //determine if class eliminates duplicates
    {
    	countWords counter = new countWords();
    	Map<String, Integer> words = counter.countOccurrencesOfWordsWithin("This THIS This THiS this");
  
    	Assert.assertEquals(words.size(), 1);
    	Assert.assertEquals(5, words.get("this"),0);
    }
    
    @Test
    public void nonAlpha() //test if class eliminates non-alphanumeric characters from count
    {
    	countWords counter = new countWords();
    	Map<String, Integer> words = counter.countOccurrencesOfWordsWithin("This, is my friend");	
    	Assert.assertEquals(words.size(), 4);
    	Assert.assertEquals(1, words.get("this"),0);
    }
    
    
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void empty() throws IllegalArgumentException //test if class throws appropriate exception
    {
    	countWords counter = new countWords();
        Map<String, Integer> words = counter.countOccurrencesOfWordsWithin("");
    }
     
}
