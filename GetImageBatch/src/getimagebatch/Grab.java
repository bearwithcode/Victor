/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getimagebatch;

import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author victor
 */
public class Grab {
    private String url = "";
    private int imagesnum = 0;

    public Grab(String url,int num) {
        this.url = url;
        this.imagesnum = num;
    }
    
    public Vector StartGrab(){
        Vector<String> ImgUrls = new Vector<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements hrefs = doc.select("img");
            int i = 0;
            for(Element href:hrefs){
                if(i >= imagesnum)
                    break;
                String iurl = href.attr("src").trim();
                ImgUrls.add(iurl);
                i++;
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return  ImgUrls;
    }
}
