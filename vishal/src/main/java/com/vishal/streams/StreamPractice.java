package com.vishal.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		System.out.println("hello world");
		seOddandEvenNo();
	}
	
	
	public static void seOddandEvenNo() {
		
		//1)seperateoddand even numbers
		List<Integer> inList = List.of(1,2,3,4,5,6,7,8,89,95,74,85,85,98);
		Map<Boolean, List<Integer>> list = inList.stream().collect(Collectors.partitioningBy(i->i%2==0));
		System.out.println(list);
		
		//2)remove duplicate
		List<Integer> distinct = inList.stream().distinct().collect(Collectors.toList());
		System.out.println(distinct);
		
		//3)freq of each char in string
		String s="malayalam";
		Map<Object, Long> map = s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy((x->x),Collectors.counting()));
		System.out.println(map);
		
		//4)freq of each element in array
		Integer[] arr = new Integer[] {1,2,3,4,5,6,2,3,1,4,52,3,6,78,4,56,1};
		Integer[] arrt = new Integer[] {45,789,1126,3,6,78,4,56,1};
		Map<Object,Long> op =  Arrays.stream(arr).collect(Collectors.groupingBy((x->x),Collectors.counting()));
		System.out.println(op);
		
		
		//5)sorting  a map by pavan  done
		Map<Object, Object>map1=op.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(a,b)->a,LinkedHashMap::new));
	System.out.println(map1);
		
		//6)sorting in reverse order using streams
		List<Integer> collect = Arrays.stream(arr).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(collect);
		
		//7)join strings with , and add suffix ] and prefix [
		String ss = "my name is 1vishal";
		
		String collect2 = Arrays.stream(ss.split(" ")).collect(Collectors.joining(",", "[", "]"));
		System.out.println(collect2);
		
		//8 print multiples of 5 in the list
		Arrays.stream(arr).filter(x->x%5==0).forEach(System.out::println);
		
		//10 max and min in the list
		Integer max = Arrays.stream(arr).max(Comparator.naturalOrder()).get();
		Integer min = Arrays.stream(arr).max(Comparator.reverseOrder()).get();
		System.out.println(max+"--max-------min---"+min);
		
		//11 merge two unsorted arrays to sorted array
		Stream.concat(Arrays.stream(arr), Arrays.stream(arrt)).sorted().collect(Collectors.toList()).forEach(System.out::println);
		
		//12 anagram program same alphabets and count with order mismatch
		
		String a = "bangalore";
		String b = "erolagnab";
		String ar = Stream.of(a.split("")).map(x->x.toUpperCase()).sorted().collect(Collectors.joining());
		String br = Stream.of(b.split("")).map(x->x.toUpperCase()).sorted().collect(Collectors.joining());
		String re = (ar.equals(br))?"anagram":"not a anagram";
		System.out.println(re);
		
		//13 merge two unsorted arrays to sorted array without duplicates
		Stream.concat(Arrays.stream(arr), Arrays.stream(arrt)).sorted().distinct().collect(Collectors.toList()).forEach(System.out::println);
				
		//14 sum of all digits of a number
		Integer sum = Arrays.stream("123456".split("")).map(Integer::valueOf).collect(Collectors.summingInt(x->x*3));
		Integer summ = Arrays.stream("123456".split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sum);
		System.out.println(summ);
		
		//15 three max and three min
		Arrays.stream(arr).sorted().limit(3).forEach(System.out::println);
		Arrays.stream(arr).sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		
		//16 second largest number in array
		Integer sl = Arrays.stream(arr).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(sl);
		
		//17 sort list of strings based on their length
		List<String> lenlist = Arrays.stream(ss.split(" ")).sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
		System.out.println(lenlist);
		
		//18 common elements between two arrays
		List<Integer> inList2 = List.of(1,2,3,4,5,6,7,8,3,5,7,89,95,74,85,85,98);
		inList.stream().filter(inList2::contains).forEach(System.out::println);
		
		//19 sum and average of all elements in array
		System.out.println(Arrays.toString(arr));
		Double avg = Arrays.stream(arr).collect(Collectors.averagingInt(z->z));
		Integer summm = Arrays.stream(arr).collect(Collectors.summingInt(z->z));
		System.out.println(avg+"  dfsdf  "+summm);
		int sum2 = Arrays.stream(new int[] {1,2,3,4,5,6}).sum();
		double avgd = Arrays.stream(new int[] {1,2,3,4,5,6}).average().getAsDouble();
		System.out.println(sum2+"  dfsdf  "+avgd);
		
		//20 reverse each word in a asentence
		String reverse = Arrays.stream(ss.split(" ")).map(x->new StringBuffer(x).reverse()).collect(Collectors.joining(" "));
		System.out.println(reverse);
		
		//21 reverse an integer array
		int[] revarr = IntStream.range(1,inList2.size()+1).map(x->inList2.get(inList2.size()-x)).toArray();
		System.out.println(Arrays.toString(revarr));
		
		//22 sum of first ten natural numbers
		int gsum = IntStream.range(1, 11).sum();
		System.out.println(gsum);
		
		//23 find strings which start with number
		List<String> nustr = Arrays.stream(ss.split(" ")).filter(str->Character.isDigit(str.charAt(0))).collect(Collectors.toList());
		System.out.println(nustr);
		
		//24 polindrome program
		boolean noneMatch = IntStream.range(0,s.length()/2).noneMatch(i->s.charAt(i)!=s.charAt(s.length()-i-1));
		boolean allMatch = IntStream.range(0,s.length()/2).allMatch(i->s.charAt(i)==s.charAt(s.length()-i-1));
		System.out.println(noneMatch?"polindrome":"not a polindrome");
		System.out.println(allMatch?"polindrome":"not a polindrome");
		
		//25 find the duplicate elements in integer array
		HashSet<Integer> set = new HashSet<>();
		List<Integer> dup = inList2.stream().filter(i->!set.add(i)).collect(Collectors.toList());
		System.out.println(dup);
		
		//26 last element of an array
		Integer le = inList2.stream().skip(inList2.size()-1).findFirst().get();
		System.out.println(le);
		
		//27 fibonacci series
		Stream.iterate(new int[] {0,1}, x->new int[] {x[1],x[0]+x[1]}).limit(10).map(x->x[0]).forEach(n->System.out.print(" "+n));
		
		
		
	}
	
	
	
}
