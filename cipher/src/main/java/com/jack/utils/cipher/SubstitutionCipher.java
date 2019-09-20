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
public class SubstitutionCipher 
{
  private List<Character> alteredAlphabet = CipherUtils.createAlphabetList();
  private List<Character> alphabet = CipherUtils.createAlphabetList();
  private List<Character> key = new ArrayList<Character>();
    
  public String encrypt(String txtToEncrypt)
  {
    CipherUtils.checkKey(key);
    
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
  
  public String getKey()
  {
    return key.toString();
  }
  
  public void setKey(String key)
  {
    CipherUtils.checkKey(key);
    this.key = CipherUtils.charArrToList(key.toCharArray());
  }
}
