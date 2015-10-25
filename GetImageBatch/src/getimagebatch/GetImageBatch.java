/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getimagebatch;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author victor
 */
public class GetImageBatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input website URL");
        System.out.print(">");
        String url = sc.next();
        
        System.out.println("how many images you want download in this page");
        System.out.print(">");
        
        int num = sc.nextInt();
        Grab grab = new Grab(url, num);
        Vector<String> isrcs = grab.StartGrab();
        isrcs.forEach((p) -> System.out.println(p));
        DownloadImg downloadImg = new DownloadImg();
        downloadImg.download(isrcs);
    }
    
}
