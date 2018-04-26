package com.techvisionworks.tree;
class Student implements Comparable<Student> {

    String name;
    String mar;

    public Student(String name) {
       this.name=name;

    }

    public String toString(){
       return name;
    }

   public int compareTo(Student gStudent) {
	   return this.name.compareTo(gStudent.getName());
       /*if(!this.name.compareTo(gStudent.getName())) 
          return 1;
       return 0;*/
   }

   private String getName() {
       return name;
   }
}