package com.jack.utils.cipher;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * This is a class that allows you encrypt 
 * your String using Alphabetic Cipher.
 * 
 * @author Jacek Lajdecki
 * 
 */
public class SubstitutionCipher 
{
  private List<Character> alteredAlphabet = CipherUtils.alphabetList();
  private List<Character> alphabet = CipherUtils.alphabetList();
  private List<Character> key = new ArrayList<Character>();
    
  /*
   * Encrypts desired text with your key using Alphabetical Substitution
   */
  public String encrypt(String txtToEncrypt)
  {
    String encryptedText = "";    
    for (Character character : txtToEncrypt.toLowerCase().toCharArray())
    {
      encryptedText += Character.isWhitespace(character) ? StringUtils.SPACE 
              : alteredAlphabet.get(alphabet.indexOf(character));
    }
    return encryptedText;
  }

  /*
   * Decrypts desired text with your key using Alphabetical Substitution
   */
  public String decrypt(String encryptedText)
  {
    String decryptedText = "";
    for (Character character : encryptedText.toLowerCase().toCharArray())
    {
      int index = alteredAlphabet.indexOf(character);
      decryptedText += Character.isWhitespace(character) ? StringUtils.SPACE
              : alphabet.get(index); 
    }
    return decryptedText;
  }
  
  /*
   * Return your key
   */
  public String getKey()
  {
    return key.toString();
  }
  
  /*
   * Sets key of your substitution
   */
  public void setKey(String key)
  {
    CipherUtils.checkKey(key);
    this.key = CipherUtils.charArrayToList(key.toCharArray());
    alteredAlphabet.removeAll(this.key);
    alteredAlphabet.addAll(0, this.key);
  }
}
