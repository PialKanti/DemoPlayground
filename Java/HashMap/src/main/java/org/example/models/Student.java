package org.example.models;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return id + name.hashCode() + age;
    }

    //if two objects are equal to each other based on equals() method,
    // then the hash code must be the same,
    // but if the hash code is the same, then equals() can return false.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Student student = (Student) obj;
        if (id != student.id) {
            return false;
        }
        if (!name.equals(student.getName())) {
            return false;
        }
        return age == student.getAge();
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name = '" + name + "', age = " + age + "}";
    }
}
