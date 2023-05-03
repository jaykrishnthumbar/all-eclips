package com.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortingInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Number
		ArrayList<Integer> list1  =new ArrayList<Integer>();
		
		list1.add(12);
		list1.add(2);
		list1.add(32);
		list1.add(146);
		list1.add(46);
		
		System.out.println(list1);
		
		list1.stream().sorted().forEach(System.out::println);
		
		
		//Alphabet
		List<String> list2 = List.of("Queen","Jacky","Ronak","Preet","Gracy");
		
		list2.stream().sorted().forEach(System.out::println);
		
		
		//Dublicate
		LinkedList<Integer>list3 = new LinkedList<Integer>();
		
		list3.add(12);
		list3.add(2);
		list3.add(32);
		list3.add(146);
		list3.add(46);
		list3.add(146);
		list3.add(46);
		
		Set<Integer> sort = list3.stream().collect(Collectors.toSet());
		System.out.println("After removing dublicate: "+sort);
		
		//remove duplicates
		Set<Integer> num1 = list3.stream().filter(i->(list3.indexOf(i)==list3.lastIndexOf(i))).collect(Collectors.toSet());
		System.out.println("Remove All Dublicate: "+num1);
		
		//print only duplicates
		Set<Integer> num2 = list3.stream().filter(i->!(list3.indexOf(i)==list3.lastIndexOf(i))).collect(Collectors.toSet());
		System.out.println("Duplicates: "+num2);
		
		//print biggest number
		Set<Integer> num4 = list3.stream().collect(Collectors.toSet());
		System.out.println("Maximum number is: "+num4);
		
		//reverse order
		List<Integer> num5 = list3.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("In Reverse order: "+num5);

	}

}
