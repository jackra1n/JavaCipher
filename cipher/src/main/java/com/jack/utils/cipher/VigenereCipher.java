package com.jack.utils.cipher;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * This is a class that allows you encrypt
 * your String using Vigener Cipher.
 * 
 * @author Jacek Lajdecki
 * 
 */
public class VigenereCipher
{
  List<Character> alphabet = CipherUtils.alphabetList();
  List<Character> key = new ArrayList<Character>();

  public String encrypt(String textToEncrypt)
  {
    int keyPlace = 0;
    String encryptedText = "";
    for (Character character : textToEncrypt.toLowerCase().toCharArray())
    {
      int charIndex = alphabet.indexOf(character);
      int keyIndex = alphabet.indexOf(key.get(keyPlace));
      if (Character.isWhitespace(character))
      {
        encryptedText += StringUtils.SPACE;
      }
      else if (charIndex+keyIndex >= alphabet.size())
      {
        encryptedText += alphabet.get(charIndex-alphabet.size()+keyIndex);
        keyPlace = nextKeyChar(keyPlace); 
      }
      else 
      {
        encryptedText += alphabet.get(charIndex+keyIndex);        
        keyPlace = nextKeyChar(keyPlace); 
      }
    }
    return encryptedText;
  }
  
  public String decrypt(String encryptedText)
  {
    String decryptedText = "";
    int keyPlace = 0;
    for (Character character : encryptedText.toLowerCase().toCharArray())
    {
      int charIndex = alphabet.indexOf(character);
      int keyIndex = alphabet.indexOf(key.get(keyPlace));
      if (Character.isWhitespace(character))
      {
        decryptedText += StringUtils.SPACE;
      }
      else if (charIndex-keyIndex < 0)
      {
        decryptedText += alphabet.get(alphabet.size()+charIndex-keyIndex);
        keyPlace = nextKeyChar(keyPlace); 
      }
      else 
      {
        decryptedText += alphabet.get(charIndex-keyIndex);        
        keyPlace = nextKeyChar(keyPlace); 
      }
    }
    return decryptedText;
  }
  
  private int nextKeyChar(int keyPlace)
  {
    if (keyPlace == key.size()-1)
    {
      keyPlace = 0;        
    }
    else 
    {
      keyPlace += 1;
    }
    return keyPlace;
  }
  
  public List<Character> getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = CipherUtils.charArrayToList(key.toLowerCase().toCharArray());
  }
}
