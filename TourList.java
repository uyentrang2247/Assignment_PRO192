/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmnet_pro192_tqt;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TourList {
    private ArrayList<Tour> list = new ArrayList<>();
    
    public ArrayList<Tour> getList(){
        return list;
    }
    
    Scanner sc = new Scanner(System.in);
    
    public void menuAdd(){
        System.out.println("========================================");
        System.out.println("1. Add Domestic Tour");
        System.out.println("2. Add International Tour");
        System.out.println("3. Exit");
        System.out.println("========================================");
        System.out.print("Input choice: ");
       
    }
    
    public void addTour(){
        int choice;
        do{
           menuAdd(); 
           choice = sc.nextInt();
           switch(choice){
                case 1: 
                   DomesticTour domesTour = new DomesticTour();
                   list.add(domesTour.input());
                  break;
                case 2:
                    InternationalTour interTour = new InternationalTour();
                    list.add(interTour.input());
                    break;
                default: 
                    break;
           }
        } while (choice > 0 && choice < 3);
    }
    
    public ArrayList<Tour> DomesTourList() {
        ArrayList<Tour> m = new ArrayList<>();
        for (Tour v : list) {
            if (v instanceof DomesticTour) {
                m.add(v);
            }
        }
        return m;
    }
    public double averageInterToursCharge(){
        double average = 0;
        int count = 0;
        for (Tour v : list)
            if (v instanceof InternationalTour){
                count ++;
                average += ((InternationalTour) v).tourCharge();
            }
        return average/count;
    }
    public void searchTourMenu(){
        System.out.println("-----------------------");
        System.out.println("1.Search by tour's code");
        System.out.println("2.Search by title");
        System.out.println("3.earch by start date");
        System.out.println("4.Search by transport");
        System.out.println("5.Exit");
        System.out.println("----------------------");
        System.out.println("Input choice: ");
    }
    public void searchTour(){
        int choice;
        do {
            searchTourMenu();
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Input tourCode to search: ");
                    String tourCodeSearch = sc.nextLine();
                    Tour t = searchTourCode(tourCodeSearch);
                    if (t != null)
                        System.out.println(t);
                    else 
                        System.out.println("tourCode doesn't exist");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }while (choice < 5 && choice > 0);
    }
    public Tour searchTourCode (String tourCodeSearch){
        Tour t = null;
        for (Tour v : list)
            if (v.getTourCode().equals(tourCodeSearch)){
                t = v;
            }
            return t;             
    }
    
}
