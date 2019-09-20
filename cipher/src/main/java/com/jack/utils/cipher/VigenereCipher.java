package com.jack.utils.cipher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VigenereCipher
{
  List<Character> alphabet = CipherUtils.createAlphabetList();
  List<Character> alteredAlphabet = new ArrayList<Character>();
  List<Character> key = new ArrayList<Character>();

  public String encrypt(String textToEncrypt)
  {
    String encryptedText = "";
    System.out.println(alphabet);
    System.out.println(alteredAlphabet);
    Collections.sort(alteredAlphabet);
    System.out.println(alteredAlphabet);
    for (Character character : textToEncrypt.toLowerCase().toCharArray())
    {
      int charIndex = alphabet.indexOf(character);
      if (charIndex == -1)
      {
        encryptedText += " ";
      }
      else 
      {
        encryptedText += alteredAlphabet.get(charIndex);
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
  
  private List<Character> makeAlteredAlphabet()
  {
    CipherUtils.checkKey(this.key);
    List<Character> listWithKey = new ArrayList<Character>();
    int keyPlace = 0;
    for (Character character : alphabet)
    {
      int index = 0;
      if (keyPlace >= key.size())
      {
        keyPlace = 0;
      }
      int keyIndex = alphabet.indexOf(key.get(keyPlace));
      int alphabetIndex = alphabet.indexOf(character);
      if (alphabetIndex + keyIndex >= alphabet.size())
      {
        index = alphabetIndex - alphabet.size() + keyIndex;
      }
      else 
      {
        index = alphabetIndex + keyIndex;
      }
      keyPlace++;
      listWithKey.add(alphabet.get(index));
    }
    return listWithKey;
  }
  
  public List<Character> getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = CipherUtils.charArrToList(key.toLowerCase().toCharArray());
    alteredAlphabet = makeAlteredAlphabet();
  }
}
