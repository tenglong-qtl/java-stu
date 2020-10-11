package org.zicheng.stu.collection.queue.iter;

import java.util.Iterator;

/**
 * Author: zicheng
 * Since: 2020-10-11 21:54
 */
public class Iter<T> implements Iterable<T> {
    private Object[] objects = new Object[10];
    private int size = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iteror();
    }

    private class Iteror implements Iterator<T>{
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex != size;
        }

        @Override
        public T next() {
            return (T) objects[currentIndex++];
        }
    }

    public void add(T element){
        if (this.size == this.objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[size++] = element;
    }

    public int size() {
        return size;
    }

    public T get(int i){
        if (i < 0 || i >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) this.objects[i];
    }

    public static void main(String[] args) {
        Iter<Integer> integers = new Iter<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(Integer i : integers){
            System.out.println(i);
        }
    }
}
