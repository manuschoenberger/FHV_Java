package at.fhv.msc.java;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicIntArray implements Iterable<Integer> {
	
	final static int _DEFAULT_SIZE = 10;
	private int[] _array;
	private int _size;
	
	// Konstruktoren:
	
	public DynamicIntArray() {
		this(_DEFAULT_SIZE);
	}
	
	public DynamicIntArray(int size) {
		_array = new int[size];
		_size = size;
	}
	
	public DynamicIntArray(int[] initialValues) {
		_size = initialValues.length;
		_array = new int[_size];
		System.arraycopy(initialValues, 0, _array, 0, _size);
	}
	
	// Methoden:
	
	public int get(int index) {
		if (index < 0 || index >= _size) {
			throw new IndexOutOfBoundsException();
		}
		
		return _array[index];
	}
	
    public int getSize() {
        return _size;
    }
	
    public void set(int index, int value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        if (index >= _size) {
            setSize(index + 1);
        }
        
        _array[index] = value;
    }
	
    public void setSize(int newSize) {
        if (newSize > _array.length) {
            int[] newArray = new int[newSize];
            System.arraycopy(_array, 0, newArray, 0, _size);
            _array = newArray;
        }
        
        _size = newSize;
    }
	
	public int size() {
		return _size;
	}
	
    public void clear() {
        _array = new int[_size];
    }
    
    // for-each:
	
	public void forEachModify(Performable action) {
		for (int i = 0; i < _size; i++) {
			int retval = action.performModify(_array[i]);
			_array[i] = retval;
		}
	}
	
	public void forEach(Performable action) {
		for (int i = 0; i < _size; i++) {
			action.performModify(_array[i]);
		}
	}
	
	// Iterator (Iterable):
	
    public Iterator<Integer> iterator() {
        return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<Integer> {
    	private int _index;
    	
    	private ArrayIterator() {
    		_index = 0;
    	}
    	
        public boolean hasNext() {
            return _index < _size;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("ERROR: Out of Array Bounds");
            }
            return _array[_index++];
        }

//        public void remove() {
//            throw new UnsupportedOperationException();
//        }
    }

	public static void main(String[] args) {
		
		// Test 1:
		
		DynamicIntArray array = new DynamicIntArray(new int[] {1, 2, 3});
		
		array.forEach(new Performable() {
			@Override
			public int performModify(int value) {
				return 0;}
			
			@Override
			public void perform(int value) {
				System.out.println(value * 2);
			}
			
		});
		
		for (int i = 0; i < array.getSize(); i++) {
		    System.out.println(array.get(i));
		}
		
		System.out.println();

		array.forEachModify(new Performable() {
			@Override
		    public int performModify(int value) {
		        return value * 2;
		    }

			@Override
			public void perform(int value) {}
		});

		for (int i = 0; i < array.getSize(); i++) {
		    System.out.println(array.get(i));
		}
		
		System.out.println();

		array.set(3, 4);
		array.set(5, 6);

		for (int value : array) {
		    System.out.println(value);
		}
		
		System.out.println();
		
		// Test 2:
		
		ArrayIterator iter = (ArrayIterator) array.iterator();
		
		try {
			System.out.println(iter.hasNext());
			System.out.println(iter.next());
			System.out.println(iter.hasNext());
			System.out.println(iter.next());
			System.out.println(iter.hasNext());
			System.out.println(iter.next());
			System.out.println(iter.hasNext());
			System.out.println(iter.next());
			System.out.println(iter.hasNext());
			System.out.println(iter.next());
			System.out.println(iter.hasNext());
			System.out.println(iter.next());
			System.out.println(iter.hasNext());
			System.out.println(iter.next());
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		// Test 3:
		DynamicIntArray array1 = new DynamicIntArray();
		
		System.out.println();
		System.out.println(array1.size());
		array1.setSize(5);
		System.out.println(array1.size());
		array1.set(5, 7777);
		System.out.println(array1.get(5));
		System.out.println(array1.getSize());
		array1.set(8, 8888);
		System.out.println(array1.get(8));
	}

}
