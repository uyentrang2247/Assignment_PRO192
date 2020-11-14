/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmnet_pro192_tqt;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Assignmnet_PRO192_TQT {
    
    
    /**
     * @param args the command line arguments
     */
    public static void showMenu(){
        System.out.println("--------------------------------");
        System.out.println("1.Add new tours to the list");
        System.out.println("2.List all domestic tours in the system");
        System.out.println("3.Compute the average tour charge of all international tours");
        System.out.println("4.Search tour");
        System.out.println("5.Search the first occurrence of the tour having minimum tour charge ");
        System.out.println("6.Remove the tour having given code");
        System.out.println("7.Remove tours with start date after the specified date");
        System.out.println("8.Sort all tours of list by multiple levels in descending order of tour's price and then in ascending order of tour's title");
        System.out.println("9.Update tour information");
        System.out.println("10.Save tours from file");
        System.out.println("11.Load tours from file");
        System.out.println("12.Quit");
        System.out.println("----------------------------------");
        System.out.print("Please enter your choice: ");
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        TourList tourlist = new TourList();
        int choice;
        do {
            showMenu();
            choice = sc.nextInt();
            switch(choice){
                case 1: 
                    tourlist.addTour();
                    break;
                case 2:
                    System.out.println("All domestic tours in the system: ");
                    for (int i = 0; i <tourlist.DomesTourList().size(); i++)
                        System.out.println(tourlist.DomesTourList().get(i));
                    break;
                case 3:
                    System.out.print("Average tour charge of all international tours is: " + tourlist.averageInterToursCharge());
                    break;
                case 4:
                    tourlist.searchTour();
                    break;
                case 5: 
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                default : 
                    System.out.println("Goodbye!");
                    break;
            } 
        }while (choice < 12 && choice > 0);
    }
    
}
