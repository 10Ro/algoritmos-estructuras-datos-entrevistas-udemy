package com.danielblanco.algoritmosestructuras._01_remove_dups;

import java.util.HashSet;

import com.danielblanco.algoritmosestructuras._00_linkedlist.Node;

/*
 * Escribe un algoritmo para eliminar los elementos duplicados en una Lista enlazada
 *
 * Ejemplo:
 *  Input: 1->2->2->3->4->1
 *  Output: 1->2->3->4
 *
 *
 *
 * Follow-up: ¿Cuál sería tu solución si no pudieras utilizar memoria adicional?
 */
public class RemoveDups {

  public void removeDups(Node head) {
    HashSet<Integer> foundValues = new HashSet<>();
    if (head == null)
      return;

    Node current = head;
    foundValues.add(current.value);
    while (current != null && current.next != null) {
      if (!foundValues.add(current.next.value)) {
        current.next = current.next.next;
      }
      current = current.next;
    }
  }
}
