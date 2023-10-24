package com.yakuphanyar.week03;

import javax.swing.*;
import java.util.Random;

public class Main {
}

/*-------------------------------------------------------------------------------------------------

SORU1: Yazılımda oluşabilecek kaç türlü hata vardır? Bunları açıklayınız. En az hata ile kod
yazmak için ne yapılmalıdır?

Yazılımda oluşabilecek yaygın hata türleri; fonksiyonel hatalar, syntax hataları, run time
hataları, mantık hatalarıdır.

-Fonksiyonel hatalar yazılan kodun istenildiği gibi çalışmadığı genel bir hata türüdür.
-Syntax hataları, kod yazma sırasında oluşan yazım hatalarından kaynaklanır. Genelde yazım hataları
editör tarafından onarılır.
-Run time hataları, kodu derleyip çalıştırdıktan sonra ortaya çıkan ve syntax hataları gibi direkt
belli olmayan her şeyin normal gözüktüğü hatalardır.
-Mantık hataları, yazılımın derlenme esnasında değil çalışırken hata vermesine neden olur.
Verilen sonuçlar hatalı olabileceği gibi programın çökmesine de neden olabilir.(sonsuz döngü gibi.)

En az hata ile kod yazmak için, öncelikli olarak problem iyi anlaşılmalı ve çözüm için doğru algoritma
hazırlanmalıdır. Yazılan kodları bir bütün olarak değil metodlar şeklinde yazmak hatayı minimuma çekmeye
yardımcı olur. Aynı zamanda belli aralıklar ile yazılan kodların debug ile kontrol edilmesi ve kod blokları
uzamadan hatanın nerede olduğunun bulunması önemlidir.


 -----------------------------------------------------------------------------------------------------*/

/* SORU2: Çift zar simülasyonu gerçekleştiriniz. Tavla da iki zar ile oynanır. 1-6 sayıları iki zar
üzerindedir. Zarı programa artıran java programını yazınız. Ama gelen sayıları zar
resmini gösterecek şekil de ekranda gösteriniz. (Zar resimleri internetten alabilirsiniz.)  */

    class DoubleDice {


    }

/*-----------------------------------------------------------------------------------------------------*/

/* SORU3: 1-100 arasında rastgele sayı türeten ve kullanıcı tarafından tahmin edilmeye çalışan
programı java programı yazınız. Kullanıcı girişlerini Joptionpane.showmessagedialog,
joptionpane.showinputdialog yapılarını kullanınız. (try-catch yapısını kullanınız) */

    class FindNumber {
        public static void main(String[] args) {

            Random rand = new Random(); //We define a random number variable that the computer will assign
            int a = (rand.nextInt(100)) + 1;
            //We bring our random number between 1 and 100 and define it into variable a
            System.out.println(a);
            //We added this code as an extra to see the number. the user cannot normally see it.

            String guess = JOptionPane.showInputDialog(null, "Enter your number prediction.(1-100):");
            //We want number input from the user
            int num = Integer.parseInt(guess); //We convert our number to int value

            if (num > 100 || num < 0) {
                JOptionPane.showMessageDialog(null, "Incorrect number entry.");
                //If our number is not in the desired range, we indicate that there is an incorrect number entry.
            } else { //If it is not faulty, it will perform the following operations:

                while (num != a) {//The loop will continue until the predicted user input equals the random number.

                    if (num < a) {
                        //If our guess is greater than the random number, we want a lower number to be entered.
                        String guess2 = JOptionPane.showInputDialog(null, "Please enter a higher value.");
                        num = Integer.parseInt(guess2);

                    } else if (num > a) {
                        //If our guess is less than the random number, we want a larger number entered.
                        String guess2 = JOptionPane.showInputDialog(null, "Please enter a lower value.");
                        num = Integer.parseInt(guess2);
                    }
                }
                JOptionPane.showMessageDialog(null, "Your prediction is correct.");
                /*If we exit the loop,
                the condition is met and the user receives the message that the number is entered correctly.*/

            }
        }
    }

/*-----------------------------------------------------------------------------------------------------*/

/* SORU4: abc üç basamaklı bir tamsayıdır ve aşağıdaki koşulları sağlamaktadır:
koşul 1 cba > abc olacak
koşul 2 abc asal sayı olacak
koşul 3 cba asal sayı olacak
koşul 4 ab asal sayı olacak
koşul 5 bc asal sayı olacak
koşul 6 cb asal sayı olacak
koşul 7 ba asal sayı olacak
Yukarıdaki koşulların hepsini sağlayan tüm abc sayılarını bulan programı yazınız. */

    class ThreeDigitsPrimeNum {
        public static void main(String[] args)
        {
            int o = 0; //We created a variable for the ones digit. (o)nes
            int t = 0; //We created a variable for the tens digit. (t)ens
            int h = 0; //We created a variable for the hundreds digit. (h)undreds
            int i = 100; //We defined our lowest 3-digit number with the variable "i".

            while (i <= 999) //Our loop will loop up to our largest 3-digit number, 999.
            {
                while (i <= 999) //In this loop, we will separate our number into its digits.
                {
                    int num = i;
                    o = num % 10; //the ones digit of our number
                    num = num / 10;
                    t = num % 10; //the tens digit of our number
                    num = num / 10;
                    h = num; //the hundreds digit of our number
                    break;
                }

                boolean[] control = new boolean[7]; //We create a condition array.
                control[0] = cond1(h,t,o,i);
                control[1] = cond2(i);
                control[2] = cond3(h,t,o);
                control[3] = cond4(h,t);
                control[4] = cond5(t,o);
                control[5] = cond6(t,o);
                control[6] = cond7(h,t);
                //We create 7 different conditions.
                if (control[0] && control[1] && control[2] && control[3] && control[4] && control[5] && control[6])
                    System.out.println(i);
                //When all 7 different conditions result in true, i.e. 1, we print that number.
                i++; //We increase our number by one for the loop.
            }
        }

        public static boolean cond1 (int h, int t, int o, int i)
        {
            int num = o * 100 + t * 10 + h;
            //In our first condition, we reverse the number and check if it is larger than our normal number.
            if (num > i) {
                return true; //If it is greater, we return true.
            }
            else {
                return false;
            }
        }

        public static boolean isPrime (int num)
        //For our remaining conditions, we write the method that checks whether there are prime numbers.
        {
            for (int i = 2; i * i <= num; i++)
                //A number is prime if it is not divisible by the numbers from 2 to itself.
                if (num % i == 0) {
                    return false;
                }
            return true;
        }
        //We can write our other conditions depending on this.

        public static boolean cond2 (int i)
        {
            return isPrime(i); //Our second condition will be true if our number is prime.
        }

        public static boolean cond3 (int h, int t, int o)
        {
            int num = o * 100 + t * 10 + h;
            return isPrime(num); //Our 3rd condition is true if our "o,t,h" number is prime.
        }

        public static boolean cond4 (int h, int t)
        {
            int num = h * 10 + t; //Our 4th condition is true if our "ht" number is prime.
            return isPrime(num);
        }

        public static boolean cond5 (int t, int o)
        {
            int num = t * 10 + o; //Our 5th condition is true if our "to" number is prime.
            return isPrime(num);
        }

        public static boolean cond6 (int t, int o)
        {
            int num = o * 10 + t; //Our 6th condition is true if our "ot" number is prime.
            return isPrime(num);
        }

        public static boolean cond7 (int h, int t)
        {
            int num = t * 10 + h; //Our 7th condition is true if our "th" number is prime.
            return isPrime(num);
        }

    }

/*----------------------------------------------------------------------------------------------------*/

/* SORU5: Aşağıda açıklanan isPrimeX isimli metodu yazınız:
isPrimeX metodu içerisinde, gönderilen argumanın asal olup olmadığı test edilecek, eğer
sayı asal ise bu kez sayının basamak değerleri toplanarak elde edilen sayının asal olup
olmadığı test edilecektir. Bu işlem sonuçta tek basamaklı bir sayı kalana kadar devam
edilecektir. Eğer en son elde edilen tek basamaklı sayı dahil tüm sayılar asal ise isPrimeX
metodu true değerine geri dönecektir. Eğer herhangi bir kademede asal olmayan bir sayı
elde edilirse metot false değerine geri dönecektir. */

    class isPrimeX{

        public static void main(String[] args) {

            java.util.Scanner inp = new java.util.Scanner(System.in);
            //We will save the input received from the user with the scanner command.
            System.out.println("Enter your number:"); //We are asking for input from the user.
            int num = Integer.parseInt(inp.nextLine()); //We assign the received input to the int num variable

            if (num <= 1) { //Since prime numbers start from 2, we return numbers 1 and less as false.
                System.out.println("false");
            } else {

                boolean control = true;
                //We create a boolean command and if the result is true, we insert it into other methods.

                while (num != 0) { //The loop will continue until our number equals 0.

                    control = isPrimeX(num); //We assign the result from the method to the "control" variable.

                    if (control && num >= 10) {
                        num = sumPrime(num);
                        //If our variables are larger than 10, we insert the num variable into the sumPrime method.
                    } else
                        break;
                }

                System.out.println(control); //We print the result to the console.
            }
        }
         public static boolean isPrimeX(int num) { //Here we check whether our number is prime or not.

            for(int i=2; i<num; i++){
                //We divide our number by numbers starting from 2 until it reaches its own value.
                //If the result of one of them is 0, our number is not prime.
                if(num%i == 0 ){
                    return false; //As a result we return false.
                }
            }

            return true; //If it exits the loop without being equal to zero, we return true.

         }

         public static int sumPrime(int prime) {
            //In this method, we add the place values of our prime number.

            int sum=0;
            int j=0;
            int a= prime; //We define the sum, counter and temporary variable.

            while(a != 0){  //The loop will continue until our prime number matches zero
                a = a / 10;
                j++;
            }
            for(int i=0; i<j; i++){ //We add the digits and assign them to the sum variable

                sum= sum + prime %10;
                prime= prime / 10;
            }
            return sum;
         }
    }

