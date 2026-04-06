package org.shev4ik.rockjvm.advanced_scala.type_members;

public class AbstractTypeMembersVsTypeParameters {
    public static void main(String[] args) {
        abstract class Food {}
        class Grass extends Food {}
        abstract class Animal<E extends Food>{
            abstract void eat(E food);
        }

        class Cow extends Animal<Grass> {
            @Override
            void eat(Grass food) {
            }
        }
    }
}
