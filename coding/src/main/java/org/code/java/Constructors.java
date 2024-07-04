package org.code.java;

public class Constructors {
    public static void main(String[] args) {
    }

    class Parent {
        private String name;
        Parent(String name){
            this.name = name;
        }
    }

    class Child extends Parent {
        private String surName;

        Child(String surName){
            super(surName);
        }
    }
}
