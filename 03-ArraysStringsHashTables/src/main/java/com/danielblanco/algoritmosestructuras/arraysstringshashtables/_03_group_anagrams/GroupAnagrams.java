package com.danielblanco.algoritmosestructuras.arraysstringshashtables._03_group_anagrams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Un anagrama es una palabra creada a partir de la reordenación de las letras de otra palabra. Ej: saco - caso
 * Dado un array de strings, devuelve los anagramas agrupados. Cualquier orden es válido.
 *
 * Ejemplo:
 *  Input: words = ["saco", "arresto", "programa", "rastreo", "caso"].
 *  Output: [["saco", "caso"], ["arresto", "rastreo"], ["programa"]].
 */
public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] words) {
    if (words == null || words.length == 0)
      return Collections.emptyList();

    Map<String, List<String>> anagramMap = buildAnagramMap(words);
    return new ArrayList<>(anagramMap.values());
  }

  private Map<String, List<String>> buildAnagramMap(String[] words) {
    Map<String, List<String>> map = new HashMap<>();
    for (String word : words) {
      String hash = getAnagramHash(word);
      if (!map.containsKey(hash)) {
        map.put(hash, new ArrayList<>());
      }

      map.get(hash).add(word);
    }

    return map;
  }

  private String getAnagramHash(String s) {
    int[] letterCount = new int[26];
    for (int c : s.toCharArray()) {
      letterCount[c - 'a']++;
    }

    return Arrays.toString(letterCount);
  }
}
