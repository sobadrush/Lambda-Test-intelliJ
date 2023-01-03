package com.cathaybk.functionalInterfaceTest;

/**
 * @author RogerLo
 * @date 2023/1/3
 */
public class Car {

    public <T> void showCarInfo(BuildInCarAI<T> ai) {
        System.out.println("====================================================");
        System.out.println("My Brand is: " + ai.get());
    }

    @FunctionalInterface
    public interface BuildInCarAI<T> {
        T get();
    }

    public static void main(String[] args){
        Car myCar = new Car();
        myCar.showCarInfo(() -> "Ferrari");
    }

}
