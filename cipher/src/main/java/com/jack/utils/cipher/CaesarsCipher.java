package com.jack.utils.cipher;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a method that allows you to encrypt 
 * your String using Caesars Cipher.
 * 
 * @author Jacek Lajdecki
 * 
 */
public class CaesarsCipher 
{
  private List<Character> alteredAlphabet = createAlphabetList();
  private List<Character> alphabet = createAlphabetList();
  int key = 0;
    
  public String encrypt(String txtToEncrypt)
  {
    String encryptedText = "";    
    for (Character character : txtToEncrypt.toLowerCase().toCharArray())
    {
      int index = alphabet.indexOf(character);
      if (index == -1)
      {
        encryptedText += " ";
      }
      else if (index+key >= alteredAlphabet.size())
      {
        index = index-alphabet.size()+key;
        encryptedText += alteredAlphabet.get(index);
      }
      else 
      {
        index += key;
        encryptedText += alteredAlphabet.get(index);
      }
    }
    return encryptedText;
  }
  
  public String decrypt(String encryptedText)
  {
    
    
    return encryptedText;
  }
  
  private static List<Character> createAlphabetList()
  {
    return charArrToList("abcdefghijklmnopqrstuvwxyz".toCharArray());
  }
  
  private static List<Character> charArrToList(char[] chars)
  {
    List<Character> list = new ArrayList<Character>();
    for (char c : chars)
    {
      list.add(c);
    }
    return list;
  }
  
  public int getKey()
  {
    return this.key;
  }
  
  public void setKey(int key)
  {
    this.key = key;
  }
}
