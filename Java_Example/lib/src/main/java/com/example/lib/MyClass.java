package com.example.lib;

import java.util.Scanner;

public class MyClass {
    //Chuyen doi tu he 10 sang he thap phan
//    public static void main(String[] args) {
//        int n, i = 1;
//        int arr[] = new  int[100];
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap n: ");
//        n = sc.nextInt();
//        while (n != 0){
//            arr[i++] = n%2;
//
//            n = n/2;
//        }
//        for(int j = i-1; j > 0; j--){
//            System.out.print(arr[j]);
//        }
//    }
//Dem ky tu
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String input_String = sc.nextLine();
//        count(input_String);
//
//    }
//    public static void count(String x){
//        char[] ch = x.toCharArray(); //Chuyen cac ky tu tu chuoi vao mang
//        int letter = 0, space = 0, number = 0, other = 0;
//        for(int i = 0; i < x.length(); i++){
//            if(Character.isLetter(ch[i])){
//                letter++;
//            }
//            else if(Character.isDigit(ch[i])){
//                number++;
//            }
//            else if(Character.isSpaceChar(ch[i])){
//                space++;
//            }
//            else{
//                other++;
//            }
//        }
//        System.out.println("Letter: "+letter);
//        System.out.println("Number: "+number);
//        System.out.println("Space: "+space);
//        System.out.println("Other: "+other);
//    }
    //Dao nguoc chuoi
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String input_String;
//        input_String = sc.nextLine();
//        reverse(input_String);
//    }
//    public static void reverse(String x){
//        char[] ch = x.toCharArray();
//        for(int i = x.length()-1; i >= 0; i--){
//            System.out.print(ch[i]);
//        }

    //Exercise 8
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n;
//        System.out.print("Nhap n: ");
//        n = sc.nextInt();
//        int arr[][] = new int[n][n];
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j <= i; j++){
//                arr[i][j] = i + 1;
//            }
//        }
//        for(int i = 0; i <n; i++){
//            for(int j= 0; j <= i; j++){
//                System.out.print(" "+arr[i][j]);
//            }
//            System.out.print("\n");
//        }
//    }
    //Exercise 9
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n, i, j;
//        System.out.print("Please enter a number: ");
//        n = sc.nextInt();
//        int arr1[][] = new int[n][n];
//        int arr2[][] = new int[n][n];
//        //arr1
//        for(i = 0; i < n; i++){
//            for(j = 0; j < n; j++){
//                System.out.print("Nhap phan tu: ");
//                arr1[i][j] = sc.nextInt();
//            }
//        }
//        //arr2
//        for(i = 0; i < n; i++){
//            for(j = 0; j < n; j++){
//                System.out.print("Nhap phan tu: ");
//                arr2[i][j] = sc.nextInt();
//            }
//        }
//        int arr3[][] = new int[n][n];
//        for(i = 0; i < n; i++){
//            for(j = 0; j < n; j++){
//                arr3[i][j] = arr1[i][j] + arr2[i][j];
//            }
//        }
//        for(i = 0; i < n; i++){
//            for(j = 0; j < n; j++){
//                System.out.print(" "+arr1[i][j]);
//            }
//            System.out.print("\n");
//        }
//        System.out.println(" + ");
//        for(i = 0; i < n; i++){
//            for(j = 0; j < n; j++){
//                System.out.print(" "+arr2[i][j]);
//            }
//            System.out.print("\n");
//        }
//        System.out.println(" = ");
//        for(i = 0; i < n; i++){
//            for(j = 0; j < n; j++){
//                System.out.print(" "+arr3[i][j]);
//            }
//            System.out.print("\n");
//        }
//    }
}