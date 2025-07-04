package com.danielblanco.algoritmosestructuras.arraysstringshashtables._01_is_unique;

import java.util.HashSet;
import java.util.Set;

/*
 * Dado un método que recibe una String, comprobar si todos los caracteres son únicos o no.
 *
 * isUnique("abcde") => true;
 * isUnique("abcded") => false;
 */
public class IsUnique {

  private static int NUMBER_OF_CHARS = 128;

  public boolean isUnique(String s) {
    if (s.length() > NUMBER_OF_CHARS)
      return false; // Más caracteres que el número de caracteres únicos posibles

    Set<Character> characters = new HashSet<>();
    for (Character c : s.toCharArray()) {
      if (characters.contains(c))
        return false; // Si ya existe el carácter, no es único
      characters.add(c); // Añadir el carácter al conjunto
    }
    return true;
  }
}
