/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coba1;

public class Coba1 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] A = new int[4];
        int x=1;
        for(int i=0;i<4;i++){
            A[i]=x;
            x*=2;
            System.out.println(x);
        }
        System.out.println(Math.ceil(10.56));
        int y=Hitung.jumlah(x,3);
        System.out.println(y);
        Animal dog = new Animal();
        dog.bark();
    }
    
}
