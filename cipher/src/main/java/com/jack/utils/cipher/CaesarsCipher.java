package com.jack.utils.cipher;

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
  private List<Character> alteredAlphabet = CipherUtils.createAlphabetList();
  private List<Character> alphabet = CipherUtils.createAlphabetList();
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
    String decryptedText = "";    
    for (Character character : encryptedText.toLowerCase().toCharArray())
    {
      int index = alphabet.indexOf(character);
      if (index == -1)
      {
        decryptedText += " ";
      }
      else if (index-key < 0)
      {
        index = alphabet.size()-(key-index);
        decryptedText += alteredAlphabet.get(index);
      }
      else 
      {
        index -= key;
        decryptedText += alteredAlphabet.get(index);
      }
    }
    return decryptedText;
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
