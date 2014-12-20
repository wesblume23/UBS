package com.ubs.opsit.interviews.wordfrequency;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class countWords implements WordFrequency
{
  //Thread Safe map for atomic read/write
  private Map<String, Integer> map = Collections.synchronizedMap(new HashMap<String, Integer>());
  
  /**
   *@Description            - Count the number of occurrences of words in a string
   *@Precondition           - Input parameter is not null or empty
   *@Postcondition          - Function returns thread safe map  
   *@param stringToEvaluate - (String) input to be parsed
   *@return map             - (Map<String, Integer>) occurrences of words and their frequency
   *@author                 - Wesley Blumenthal
   */
  public Map<String, Integer> countOccurrencesOfWordsWithin(String stringToEvaluate)
  { 
    if(StringUtils.isBlank(stringToEvaluate)) //test for null and empty
    {
      throw new IllegalArgumentException("Null or empty input");
    }
    else
    {
      String[] words = stringToEvaluate.split(" ");
      
      for (String word : words)
      {
        word = word.toLowerCase(); //do 'Hi' and 'hi' count as the same word? 
        word = word.replaceAll("[^A-Za-z0-9 ]", ""); //strip all non-alphanumeric characters
          
        if (this.map.containsKey(word))
        {
          Integer frequency = this.map.get(word);
            
          this.map.put(word, ++frequency);
        }
        else
        {
          this.map.put(word, 1);
        }
      }     
    }

	return map;
  }
  
}