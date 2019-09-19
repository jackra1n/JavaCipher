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
}
