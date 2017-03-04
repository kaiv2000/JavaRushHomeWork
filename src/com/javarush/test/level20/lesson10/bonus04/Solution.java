package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable
{
    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException
    {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));
    }

    private ArrayList<Node<String>> heap = new ArrayList<>();
    private int heapSize = 0;

    public Solution()
    {
        add("0");
    }

    private static class Node<E> implements Serializable
    {
        E item;
        int arrayListIndex;
        Node<E> nextL;
        Node<E> nextR;
        Node<E> parent;

        Node(Node<E> nextL, Node<E> nextR, E element, Node<E> parent)
        {
            this.item = element;
            this.nextL = nextL;
            this.nextR = nextR;
            this.parent = parent;
        }

    }

    private Node<String> lastParent()
    {
        for (int i = (heap.size() - 1) / 2; i < heap.size(); i++)
        {
            if (heap.get(i) != null && (heap.get(i).nextL == null || heap.get(i).nextR == null ))
                return heap.get(i);
        }
        return null;
    }

    @Override
    public boolean remove(Object o)
    {
        boolean result = false;
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i) != null && heap.get(i).item.equals((String)o)){
                result = removeWithChilds((Node<String>)heap.get(i));
                break;
            }
        }

        //Trim heap by deleting last null elements
        for (int i = heap.size() - 1; i > 0 ; i--) {
            if (heap.get(i) == null)
                heap.remove(i);
            else break;
        }
        return result;
    }

    //left aligment
    public boolean removeWithChilds(Node<String> node)
    {
        if (node.nextR != null)
            removeWithChilds(node.nextR);
        if (node.nextL != null)
            removeWithChilds(node.nextL);
        if (node.arrayListIndex == heap.size() - 1)
            heap.remove(heap.size() - 1);
        Node<String> parent = node.parent;

        if (parent != null) {
            if (parent.nextL == node) {
                parent.nextL = parent.nextR;
                parent.nextR = null;
            }
            if (parent.nextR == node)
                parent.nextR = null;
        }
        if (node.arrayListIndex < heap.size())
            heap.set(node.arrayListIndex, null);
        node = null;
        heapSize--;
        return true;
    }

    @Override
    public boolean add(String s)
    {
        final Node<String> p = lastParent();
        final Node<String> newNode = new Node(null, null, s, p);
        if (p != null)
            if (p.nextL == null) p.nextL = newNode;
            else p.nextR = newNode;
        newNode.arrayListIndex = heap.size(); //Appends the specified s element to the end of this heap.
        heap.add(newNode);
        heapSize++;
        return true;
    }

    @Override
    public int size()
    {
        if (heapSize == 0)
            return 0;
        else return heapSize - 1;
    } //don't count root (zero node)

    public String getParent(String value) {
        //have to be implemented
        String parent = null;
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i) != null && heap.get(i).item.equals(value))
            {
                parent = heap.get(i).parent.item;
            }
        }
        if (parent != null && parent.equals("0")) parent = null;
        return parent;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }
}