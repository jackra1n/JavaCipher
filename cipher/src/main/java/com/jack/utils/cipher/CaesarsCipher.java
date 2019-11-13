package com.jack.utils.cipher;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * This is a class that allows you encrypt 
 * your String using Caesars Cipher.
 * 
 * @author Jacek Lajdecki
 * 
 */
public class CaesarsCipher 
{
  private List<Character> alphabet = CipherUtils.alphabetList();
  int key = 0;
  
  /*
   * Encodes desired text.
   */
  public String encrypt(String txtToEncrypt)
  {
    String encryptedText = "";    
    for (Character character : txtToEncrypt.toLowerCase().toCharArray())
    {
      int charIndex = alphabet.indexOf(character);
      encryptedText += (Character.isWhitespace(character)) ? StringUtils.SPACE
              : (CipherUtils.getRightIndexEncrypting(charIndex, key));
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
      int charIndex = alphabet.indexOf(character);
      decryptedText += (Character.isWhitespace(character)) ? StringUtils.SPACE
              : (CipherUtils.getRightIndexDecrypting(charIndex, key));
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
