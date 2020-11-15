/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmnet_pro192_tqt;

import java.util.Comparator;

/**
 *
 * @author truon
 */
public class SortByTitle implements Comparator<Tour>{
    @Override
    public int compare(Tour o1, Tour o2){
        String title1 = o1.getTourTitle();
        String title2 = o2.getTourTitle();
        return title1.compareTo(title2);
    }
}
