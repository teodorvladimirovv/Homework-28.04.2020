package Homework;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Zadacha1 {

    public static void main(String[] args){

        boolean IsRobotOn=true;
        int BatteryLeft=10;

        while(IsRobotOn){
        PrintObj();
        ChooseObj();
        if(BatteryLeft!=0){
            if(IsMouseDetected() && IsFurnitureDestroyed()){
                BatteryLeft--;
                System.out.println("Nice shot! \n You killed the mouse!");
            }else{
                System.out.println("The mouse is still alive!");
            }
        }else{
            System.out.println("There is no charge left! ");
            BatteryCharge(BatteryLeft);
        }
        IsRobotOn=!TurnOffRobot();
        }
        Communicate();
    }

    static void PrintObj(){
        System.out.println("Choose object: " + " Chair C[1]" +" Wall [2]"+ " Nothing [3]");
        System.out.print("Enter the object you choose");

    }

    static void ChooseObj(){
        Scanner input=new Scanner(System.in);
        int obj =input.nextInt();

        switch(obj){
            case 1:
                System.out.println("Jump");
                break;
            case 2:
                System.out.println("Go Sideways");
                break;
            case 3:
                System.out.println("Forward");
                break;
            default:
                System.out.println("Try Again!");
                ChooseObj();
        }
    }

    public static int BatteryCharge(int BatteryLeft ){
        while(BatteryLeft==0){
            if(BatteryLeft==0){
                BatteryLeft=10;
                System.out.println("Battery is charged");
            }else{
                System.out.println("Battery is not charged yet.");
            }
        }
        return BatteryLeft;
    }

    public static int NearbyPixels(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the amount of the nearby pixels: ");
        int pixels=input.nextInt();
        return pixels;
    }

    public static boolean  IsMouseDetected(){
        if(NearbyPixels()%2==0){
            System.out.println("Mouse detected! ");
            return true;
        }else{
            System.out.println("Mouse is not detected! ");
            return false;
        }
    }

    public static boolean IsFurnitureDestroyed(){
        int Number= ThreadLocalRandom.current().nextInt(1,10+1);
        if(Number !=5){
            System.out.println("Everything will be fine.");
            return true;
        }else{
            System.out.println("The furniture got destroyed.");
            return false;
        }
    }

    public static boolean TurnOffRobot(){
        System.out.print("Stop the robot?" + "YES = 1 "+ "NO = 0");
        System.out.print("Enter your response.");
        Scanner input=new Scanner(System.in);
        int response=input.nextInt();
        return response==1;
    }

    public static void Communicate(){
        for(int i=10; i>1;i-=2){
            System.out.println("I`m a robot"+i);
        }
    }
}
