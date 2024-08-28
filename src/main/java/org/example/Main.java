package org.example;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        System.out.println("Main Thread Started");

        Thread th1 = new Thread(()->{
            System.out.println("Thread1 calling produce method");
            resource.produce();
        });

        th1.start();

        //add 1 sec deley for main thread so that thread 1 executes first
        try{
            Thread.sleep(1000);
            System.out.println("Main thread is waiting for thread 1 to finish");
            //this make sures that thread 1 is completed then only main thread terminates
            th1.join();
        }catch(Exception e){
            //some exception handling
        }

        System.out.println("Main thread completed its task");


    }
}