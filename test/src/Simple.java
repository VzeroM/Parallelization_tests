/*
  Created by Varun Menon on 19/12/2016.
 */
import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.util.*;
import java.util.stream.IntStream;


/**
 *
 */
class Simple
{

    public static void main(String args[]) throws ParseException {
        List< Asset> fDlist=new ArrayList();
        Scanner sc=new Scanner(System.in);
        int numberOfUsers; int numberOfFD;
        Calc_interest CI=new Calc_interest();
        Createfdlist CfdL=new Createfdlist();


        System.out.println("enter number of users ");
        numberOfUsers=sc.nextInt();
        System.out.println("enter number of assets ");
        numberOfFD=sc.nextInt();
        Date d = new Date();


        System.out.println("Time before start of creation of FD is " + new Date());
        IntStream.range(0,numberOfUsers/2).forEach(i->CfdL.assign(numberOfFD,fDlist));// half list with Fixed depostits
        IntStream.range(numberOfUsers/2,numberOfUsers).forEach(i->CfdL.createShareslist(numberOfFD,fDlist));// half list with shares


        System.out.println("Time after of creation of FD is " + new Date());

        IntStream.range(0,numberOfUsers).parallel().forEach(i->CI.compute_sum(numberOfFD,fDlist,i,d));
        System.out.println("Time after of computation of FD is " + new Date());
        System.out.println(java.lang.Thread.activeCount());


        System.out.println(ManagementFactory.getThreadMXBean().getThreadCount());


        /*

        Time after of creation of FD is Thu Dec 22 12:42:02 IST 2016

        Time after of computation of FD is Thu Dec 22 12:57:14 IST 2016 */
    }

}
