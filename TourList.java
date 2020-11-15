/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmnet_pro192_tqt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TourList {

    private ArrayList<Tour> list = new ArrayList<>();

    public ArrayList<Tour> getList() {
        if(list.size() > 0){
        return list;
        }else {
            System.out.println("This list is null");
            return null;
        }
    }

    Scanner sc = new Scanner(System.in);

    public void menuAdd() {
        System.out.println("========================================");
        System.out.println("1. Add Domestic Tour");
        System.out.println("2. Add International Tour");
        System.out.println("3. Exit");
        System.out.println("========================================");
        System.out.print("Input choice: ");

    }

    public void addTour() {
        int choice;
        do {
            menuAdd();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    DomesticTour domesTour = new DomesticTour();
                    String tourCode;
                    int flag;
                    sc.nextLine();
                    do {
                        flag = 1;
                        System.out.print("Input tourCode: ");
                        tourCode = sc.nextLine();
                        if (checkTourCode(tourCode)) {
                            System.out.println("tourCode is already exist.");
                            flag = 0;
                        }
                    } while (flag == 0);
                    list.add(domesTour.input(tourCode));
                    break;
                case 2:
                    InternationalTour interTour = new InternationalTour();
                    sc.nextLine();
                    do {
                        flag = 1;
                        System.out.print("Input tourCode: ");
                        tourCode = sc.nextLine();
                        if (checkTourCode(tourCode)) {
                            System.out.println("tourCode is already exist.");
                            flag = 0;
                        }
                    } while (flag == 0);
                    list.add(interTour.input(tourCode));
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

    public double averageInterToursCharge() {
        double average = 0;
        int count = 0;
        for (Tour v : list) {
            if (v instanceof InternationalTour) {
                count++;
                average += ((InternationalTour) v).tourCharge();
            }
        }
        return average / count;
    }

    public void tourMenuSearch() {
        System.out.println("-----------------------");
        System.out.println("1.Search by tour's code");
        System.out.println("2.Search by title");
        System.out.println("3.Search by start date");
        System.out.println("4.Search by transport");
        System.out.println("5.Exit");
        System.out.println("----------------------");
        System.out.println("Input choice: ");
    }

    public void searchTour() {
        int choice;
        do {
            tourMenuSearch();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Input tourCode to search: ");
                    String tourCodeSearch = sc.nextLine();
                    Tour t = searchTourCode(tourCodeSearch);
                    if (t != null) {
                        System.out.println("There is one tour that match your search:");
                        System.out.println(t);
                    } else {
                        System.out.println("tourCode doesn't exist.");
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Input tourTtile to search: ");
                    String tourTitleSearch = sc.nextLine();
                    ArrayList<Tour> arrListTourTitle = searchTourTitle(tourTitleSearch);
                    if (!arrListTourTitle.isEmpty()) {
                        System.out.println("These are tours that match your search:");
                        System.out.println(arrListTourTitle);
                    } else {
                        System.out.println("tourTitle doesn't exist.");
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Input tourStartDate to search: ");
                    String tourStartDateSearch = sc.nextLine();
                    ArrayList<Tour> arrListTourStartDate = searchTourStartDate(tourStartDateSearch);
                    if (!arrListTourStartDate.isEmpty()) {
                        System.out.println("These are tours that match your search:");
                        System.out.println(arrListTourStartDate);
                    } else {
                        System.out.println("tourStartDate doesn't exist.");
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.print("Input (true= aircraft, flase= car) to search: ");
                    boolean tourTransportSearch = sc.nextBoolean();
                    ArrayList<Tour> arrListTourTransport = searchTourTransport(tourTransportSearch);
                    if (!arrListTourTransport.isEmpty()) {
                        System.out.println("These are tours that match your search:");
                        System.out.println(arrListTourTransport);
                    } else {
                        System.out.println("tourTransport doesn't exist.");
                    }
                    break;
                default:
                    break;
            }
        } while (choice < 5 && choice > 0);
    }

    public Tour searchTourCode(String tourCodeSearch) {
        Tour t = null;
        for (Tour v : list) {
            if (v.getTourCode().equals(tourCodeSearch)) {
                t = v;
            }
        }
        return t;
    }

    public ArrayList<Tour> searchTourTitle(String tourTitleSearch) {
        ArrayList<Tour> arrListTourTitle = new ArrayList<>();
        for (Tour v : list) {
            if (v.getTourTitle().equals(tourTitleSearch)) {
                arrListTourTitle.add(v);
            }
        }
        return arrListTourTitle;
    }

    public ArrayList<Tour> searchTourStartDate(String tourStartDateSearch) {
        ArrayList<Tour> arrListTourStartDate = new ArrayList<>();
        for (Tour v : list) {
            if (v.getStartDate().equals(tourStartDateSearch)) {
                arrListTourStartDate.add(v);
            }
        }
        return arrListTourStartDate;
    }

    public ArrayList<Tour> searchTourTransport(boolean tourTransportSearch) {
        ArrayList<Tour> arrListTourTransport = new ArrayList<>();
        for (Tour v : list) {
            if (v.isTourTransport() == tourTransportSearch) {
                arrListTourTransport.add(v);
            }
        }
        return arrListTourTransport;
    }

    public Tour searchFirstOccurHavingMimTourCharge() {
        int i, flag = 0;
        double minTourCharge = list.get(0).tourCharge();
        for (i = 1; i < list.size(); i++) {
            if (list.get(i).tourCharge() > minTourCharge) {
                minTourCharge = list.get(i).tourCharge();
                flag = i;
            }
        }
        return list.get(flag);
    }

    public void removeTourCode(String tourCode) {
        for (Tour v : list) {
            if (v.getTourCode().equals(tourCode)) {
                list.remove(v);
            }
        }
    }

    public boolean checkTourCode(String tourCode) {
        int i = 0;
        for (Tour v : list) {
            if (v.getTourCode().equals(tourCode)) {
                i++;
            }
        }
        return i == 1; //Code checkTourCode nay nó luôn check lại cái đã có
        //nên i == 1 thì duy nhất, i == 2 trở lên thì ko duy nhất
    }

    public int removeTourDate(String date) {
        int i = 0;
        for (Tour v : list) {
            if (daysBetween(v.getStartDate(), date) > 0) {
                list.remove(v);
                i++;
            }
        }
        return i;
    }

    public long daysBetween(String date1, String date2) {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate d1 = LocalDate.parse(date1, sdf);
        LocalDate d2 = LocalDate.parse(date2, sdf);

        long daysBetween = ChronoUnit.DAYS.between(d1, d2);

        return daysBetween;
    }

    public void sortTour() {
        ArrayList<Tour> temp = new ArrayList<>();
        temp.addAll(list);
        System.out.println("Sort in descending order of Tour's price: ");
        Collections.sort(temp, new SortByPrice());
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
        System.out.println("Sort in ascending order of tour's title: ");
        Collections.sort(temp, new SortByTitle());
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
            
        }
        
    }
}
