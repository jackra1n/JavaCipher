package com.jack.utils.cipher;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a method that allows you to encrypt 
 * your String using Monoalphabetic Cipher.
 * 
 * @author Jacek Lajdecki
 * 
 */
public class SubtitutionCipher 
{
  private List<Character> alteredAlphabet = createAlphabetList();
  private List<Character> alphabet = createAlphabetList();
  private List<Character> key = new ArrayList<Character>();
    
  public String encrypt(String txtToEncrypt)
  {
    checkKey();
    
    alteredAlphabet.removeAll(key);
    alteredAlphabet.addAll(0, key);
    
    String encryptedText = "";    
    for (Character character : txtToEncrypt.toLowerCase().toCharArray())
    {
      int index = alphabet.indexOf(character);
      if (index == -1)
      {
        encryptedText += " ";
      }
      else 
      {
        encryptedText += alteredAlphabet.get(index);
      }
    }
    return encryptedText;
  }
  
  public String decrypt(String encryptedText)
  {
    String decryptedText = "";
    for (Character character : encryptedText.toLowerCase().toCharArray())
    {
      int index = alteredAlphabet.indexOf(character);
      if (index == -1)
      {
        decryptedText += " ";
      }
      else 
      {
        decryptedText += alphabet.get(index);
      }
    }
    return decryptedText;
  }
  
  private void checkKey()
  {
    StringBuilder sb = new StringBuilder();
    for (Character c : key)
    {
      sb.append(c);
    }
    checkKey(sb.toString());
  }
  
  private void checkKey(String keyString)
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
  
  public String getKey()
  {
    return key.toString();
  }
  
  public void setKey(String key)
  {
    checkKey(key);
    this.key = charArrToList(key.toCharArray());
  }
}
