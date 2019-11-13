package com.jack.utils.cipher;

import java.util.ArrayList;
import java.util.List;

abstract class CipherUtils
{
  private static char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
  
  static List<Character> alphabetList()
  {
    return charArrayToList(ALPHABET);
  }
  
  static char getRightIndexEncrypting(int index, int key)
  {
    if (index+key >= alphabetList().size())
    {
      return alphabetList().get(index-alphabetList().size()+key);
    }
    else
    {
      return alphabetList().get(index+key);
    }
  }
  
  static char getRightIndexDecrypting(int index, int key)
  {
    if ((index-key) < 0)
    {
      return alphabetList().get(alphabetList().size() - (key - index));
    }
    else
    {
      return alphabetList().get(index-key);
    }
  }
  
  static List<Character> charArrayToList(char[] chars)
  {
    List<Character> list = new ArrayList<Character>();
    for (char c : chars)
    {
      list.add(c);
    }
    return list;
  }
  
  static void checkKey(List<Character> key)
  {
    checkIfArrayHasDuplicates(key);
  }
  
  static void checkKey(String keyString)
  {    
    List<Character> keyList = new ArrayList<Character>();
    for (Character character : keyString.toCharArray())
    {
      keyList.add(character);
    }
    checkIfArrayHasDuplicates(keyList);    
  }
  
  private static void checkIfArrayHasDuplicates(List<Character> keyList)
  {
    if (keyList == null)
    {
      throw new IllegalArgumentException("Cipher key is not set");
    }
    List<Character> newList = new ArrayList<Character>();
    for (char c : keyList)
    {
      if (!newList.contains(c))
      {
        newList.add(c);
      }
      else 
      {
        throw new IllegalArgumentException("Key is not supposed to have duplicate characters. Your key is: "+keyList.toString());
      }
    }
  }
}
