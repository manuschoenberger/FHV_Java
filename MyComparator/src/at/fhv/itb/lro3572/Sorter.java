package at.fhv.itb.lro3572;

import java.util.*;

public class Sorter {
	public static void sort(Object[] values, MyComparator comp) {
		for (int i = 0; i < values.length - 1; i += 1) {
			int minPos = i;
			for (int j = i; j < values.length; j += 1) {
				if (comp.compare(values[j], values[minPos]) < 0) {
					minPos = j;
				}
			}
			Object tmp = values[i];
			values[i] = values[minPos];
			values[minPos] = tmp;
		}
	}
	
	public static void main(String[] args) {
		Person[] persons = {new Person("Sarah", 100), new Person("Lea", 50)};
		
		// eigene Implementierung
		sort(persons, new MyComparator() {
			
			@Override
			public int compare(Object o1, Object o2) {
				return ((Person) o1).getSalary() - ((Person) o2).getSalary();
			}
		});
		
		for(Person p: persons) {
			System.out.println(p);
		}
		
		
		// API Implementierung
		System.out.println();
		Comparator<Person> cmp = new Comparator<Person>() {
			
			@Override
			public int compare(Person o1, Person o2) {
				return o2.getSalary() - o1.getSalary();
			}
		};
		Arrays.sort(persons, cmp);
		
		for(Person p: persons) {
			System.out.println(p);
		}
	}
}
