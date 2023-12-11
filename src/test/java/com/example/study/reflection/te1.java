package com.example.study.reflection;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

public class te1 {

    // 클래스 정보
    @Test
    @DisplayName("클래스 정보")
    public void getClassInfo() throws ClassNotFoundException {
        Class aanimalClass = Animal.class;
        Assertions.assertEquals("Animal", aanimalClass.getSimpleName());

        Animal animal = new Dog("happy");
        aanimalClass = animal.getClass();
        Assertions.assertEquals("Dog", aanimalClass.getSimpleName());

        aanimalClass = Class.forName("com.example.study.reflection.Animal");
        Assertions.assertEquals("Animal", aanimalClass.getSimpleName());

        Class intClass = Integer.TYPE;
        Assertions.assertEquals("int", intClass.getSimpleName());

    }

    // 클래스 이름
    @Test
    @DisplayName("클래스 이름")
    public void getClassName() {
        Object dog = new Dog("Happy");
        Class<?> clazz = dog.getClass();

        Assertions.assertEquals("Dog", clazz.getSimpleName()); // 클래스의 간단한 이름, 유니크하지 않음
        Assertions.assertEquals("com.example.study.reflection.Dog", clazz.getName()); // Class.forName() 등으로 클래스를 동적으로 로드하는데 사용한 이름, ClassLoader 내에서 유니크함
        Assertions.assertEquals("com.example.study.reflection.Dog", clazz.getCanonicalName()); // import 구문에서 사용한 이름

    }
    

    // 클래스의 접근제어 정보
    @Test
    @DisplayName("클래스 접근제어 정보")
    public void getAccessModifier() {
        
        Class animalClass = Animal.class;
        int animalModifier = animalClass.getModifiers(); // 클래스의 접근 제어 정보 가져오기
        
        Class dogClass = Dog.class;
        int dogModifier = dogClass.getModifiers();
        
        Class eatingClass = Eating.class;
        int eatingModifier = eatingClass.getModifiers();
        
        // 접근 제어 정보 확인
        Assertions.assertTrue(Modifier.isPublic(animalModifier));
        Assertions.assertTrue(Modifier.isAbstract(animalModifier));
        Assertions.assertTrue(Modifier.isPublic(dogModifier));
        Assertions.assertTrue(Modifier.isInterface(eatingModifier));

    }


    // 클래스의 패키지 정보
    @Test
    @DisplayName("클래스 패키지 정보")
    public void getPakageInfo() {
        Class dogClass = Dog.class;
        Package pkg = dogClass.getPackage();

        Assertions.assertEquals("com.example.study.reflection", pkg.getName());
    }

    // 부모 클래스(Supperclass) 정보
    @Test
    @DisplayName("부모 클래스 정보")
    public void getSuperClass() {
        Dog dog = new Dog("Happy");
        String str = "This is dog";
        
        Class dogClass = dog.getClass();
        Class stringClass = str.getClass();
        
        Assertions.assertEquals("Animal", dogClass.getSuperclass().getSimpleName()); // Dog 클래스가 Animmal 클래스를 상속 구현
        Assertions.assertEquals("Object", stringClass.getSuperclass().getSimpleName()); // String 클래스의 Supperclass는 Object
    }

    // 인터페이스 구현 정보
    @Test
    @DisplayName("인터페이스 구현 정보")
    public void getInterface() {
        Class dogClass = Dog.class;
        Class[] dogInterfaces = dogClass.getInterfaces();

        Assertions.assertEquals(1, dogInterfaces.length); // 인터페이스 개수
        Assertions.assertEquals("Movable", dogInterfaces[0].getSimpleName());
        // 부모 클래스가 구현한 인터페이스 정보는 들어있지 않음
        
    }
}
