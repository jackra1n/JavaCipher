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
  
  /*
   * Encodes desired text.
   */
  public String encrypt(String txtToEncrypt)
  {
    String encryptedText = "";    
    for (Character character : txtToEncrypt.toLowerCase().toCharArray())
    {
      int index = alphabet.indexOf(character);
      if (Character.isWhitespace(character))
      {
        encryptedText += " ";
      }
      else if (index+key >= alphabet.size())
      {
        index = index-alphabet.size()+key;
        encryptedText += alphabet.get(index);
      }
      else 
      {
        index += key;
        encryptedText += alphabet.get(index);
      }
    }
    return encryptedText;
  }
  
  /*
   * Decodes desired encrypted text.
   */
  public String decrypt(String encryptedText)
  {
    String decryptedText = "";    
    for (Character character : encryptedText.toLowerCase().toCharArray())
    {
      int index = alphabet.indexOf(character);
      if (Character.isWhitespace(character))
      {
        decryptedText += " ";
      }
      else if (index-key < 0)
      {
        index = alphabet.size()-(key-index);
        decryptedText += alphabet.get(index);
      }
      else 
      {
        index -= key;
        decryptedText += alphabet.get(index);
      }
    }
    return decryptedText;
  }
  
  /*
   * Tells you the key set for the cipher.
   */
  public int getKey()
  {
    return this.key;
  }
  
  /*
   * This method sets the key of your cipher. That means how many places it has to move the alphabet.
   */
  public void setKey(int key)
  {
    this.key = key;
  }
}
