package com.jack.utils.cipher;

import java.util.ArrayList;
import java.util.List;

public class VigenereCipher
{
  List<Character> alphabet = CipherUtils.createAlphabetList();
  List<Character> alteredAlphabet = new ArrayList<Character>();
  List<Character> key = new ArrayList<Character>();

  public String encrypt(String textToEncrypt)
  {
    String encryptedText = "";
    int keyPlace = 0;
    for (Character character : textToEncrypt.toLowerCase().toCharArray())
    {
      int charIndex = alphabet.indexOf(character);
//      for (int i = 0; i < array.length; i++)
//      {
//        
//      }
//      if (charIndex == -1)
//      {
//        encryptedText += " ";
//      }
//      else 
//      {
//        encryptedText += alteredAlphabet.get(charIndex);
//      }
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
  
  private Character encryptChar(char stringChar,char keyChar)
  {
    CipherUtils.checkKey(this.key);
    List<Character> listWithKey = CipherUtils.createAlphabetList();
    listWithKey.remove(keyChar);
    listWithKey.add(0, keyChar);
    int index = alphabet.indexOf(stringChar);
    return listWithKey.get(index);
  }
  
  public List<Character> getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = CipherUtils.charArrToList(key.toLowerCase().toCharArray());
//    alteredAlphabet = makeAlteredAlphabet();
  }
}
