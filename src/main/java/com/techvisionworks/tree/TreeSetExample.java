/**
 * 
 */
package com.techvisionworks.tree;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author nkakki
 *
 */
public class TreeSetExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student s = new Student("nikhil");
		Student s1 = new Student("Aadvika");
		Student s2 = new Student("nikhil");
		Student s3 = new Student("afafa");
		Student s4 = new Student("nikfafafafafl");
		Set<Student> nsss = new TreeSet<>();
		nsss.add(s);
		nsss.add(s1);
		nsss.add(s2);
		nsss.add(s3);
		nsss.add(s4);
		System.out.println(nsss.size());
		for(Student saa : nsss)
			System.out.println(saa);
	}

}
