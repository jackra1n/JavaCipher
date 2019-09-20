package com.jack.utils.cipher;

import java.util.ArrayList;
import java.util.List;

public class CipherUtils
{
  static List<Character> createAlphabetList()
  {
    return charArrToList("abcdefghijklmnopqrstuvwxyz".toCharArray());
  }
  
  static List<Character> charArrToList(char[] chars)
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
    if (key == null)
    {
      throw new IllegalArgumentException("Cipher key is not set");
    }
    StringBuilder sb = new StringBuilder();
    for (Character c : key)
    {
      sb.append(c);
    }
    checkKey(sb.toString());
  }
  
  static void checkKey(String keyString)
  {
    if (keyString == null)
    {
      throw new IllegalArgumentException("Cipher key is not set");
    }
    List<Character> newList = new ArrayList<Character>();
    for (char c : keyString.toCharArray())
    {
      if (!newList.contains(c))
      {
        newList.add(c);
      }
      else 
      {
        throw new IllegalArgumentException("Key is not supposed to have duplicate characters. Your key is: "+keyString);
      }
    }
  }
}
