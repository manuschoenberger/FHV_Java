package at.fhv.msc.java;

import java.util.Iterator;

import java.util.NoSuchElementException;

public class MyList<T> implements Iterable<T> {
    private T[] _array;
    
    public MyList(T[] values) {
        _array = values;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>();
    }
    
    private class MyIterator<E> implements Iterator<E> {
        private int _index;
        
        private MyIterator() {
            _index = 0;
        }

        @Override
        public boolean hasNext() {
            return (_index < _array.length);
        }

        @SuppressWarnings("unchecked")
		@Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return (E) (_array[_index++]);
        }
    }
    
    public static void main(String[] args) {
        Double[] values = {1.0, 2.0, 3.0, 4.0, 5.0};
        MyList<Double> vals = new MyList<>(values);
        
        for(Double i: vals) {
            System.out.println(i);
        }
    }
}
