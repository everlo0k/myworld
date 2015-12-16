/*
 * <p>ArrayListSortTest.java</p>
 */
package com.bigears.base.importnew.arraylistsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Project : myworld
 * @ClassName : com.bigears.base.importnew.arraylistsort.ArrayListSortTest
 * @Description: 数组排序
 * @Author : shenyang
 * @Date : 2015年12月16日 上午10:18:13
 */
public class ArrayListSortTest {

	static class Person implements Comparable<Person> {

		private String name;
		private int age;
		private int sex;

		public Person(String name, int age, int sex) {
			this.name = name;
			this.age = age;
			this.sex = sex;
		}

		public int compareTo(Person p) {
			if (this.sex > p.sex) {
				return 1;
			} else {
				if (this.age > p.age) {
					return 1;
				}
			}
			return 0;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	private static class Monkey {
		private String name;
		private int age;
		private int sex;

		public Monkey(String name, int age, int sex) {
			this.name = name;
			this.age = age;
			this.sex = sex;
		}

		public String getName() {
			return name;
		}

	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(1);
		list.add(2);
		for (Integer i : list) {
			System.out.println(i);
		}
		// 按照自然顺序排序
		Collections.sort(list);
		for (Integer i : list) {
			System.out.println(i);
		}

		List<Person> listPerson = new ArrayList<Person>();
		Person p1 = new Person("sy", 1, 18);
		Person p2 = new Person("rr", 1, 19);
		Person p3 = new Person("xrr", 0, 19);
		listPerson.add(p1);
		listPerson.add(p2);
		listPerson.add(p3);

		// 对象实现了comparable接口,按照compareTo()方法比较的结果排序
		Collections.sort(listPerson);
		Collections.reverse(listPerson);
		for (Person p : listPerson) {
			System.out.println(p.getName());
		}

		List<Monkey> listMonkey = new ArrayList<Monkey>();
		Monkey m1 = new Monkey("monkey rr", 1, 6);
		Monkey m2 = new Monkey("monkey zz", 1, 7);
		Monkey m3 = new Monkey("monkey ff", 0, 3);
		listMonkey.add(m1);
		listMonkey.add(m2);
		listMonkey.add(m3);

		// 定义了Comparator比较器用来排序
		Comparator<Monkey> p = new Comparator<Monkey>() {
			@Override
			public int compare(Monkey o1, Monkey o2) {
				if (o1.sex > o2.sex) {
					return 1;
				} else {
					if (o1.age > o2.age) {
						return 1;
					}
				}
				return 0;
			}
		};
		Collections.sort(listMonkey, p);
		for (Monkey m : listMonkey) {
			System.out.println(m.getName());
		}

	}

}
