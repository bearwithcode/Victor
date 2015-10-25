/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getimagebatch;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor
 */
public class DownloadImg {
    public void download(Vector<String> imgs){
        URL url;
        HttpURLConnection conn;
        InputStream inStream;
        FileOutputStream outStream;
        File imgFile;
        String fname = "img";
        String filetype;
        
        int count = 1;
        for(String img:imgs){
            try {
                filetype = checktype(img);
                url = new URL(img);
                conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET"); 
                conn.setConnectTimeout(10 * 1000);  
                inStream = conn.getInputStream();
                byte[] data = readInputStream(inStream); 
                String imgfname = fname + count + filetype;
                imgFile = new File(imgfname);
                outStream = new FileOutputStream(imgFile);
                outStream.write(data);
                outStream.close();
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            count ++;
        }
        System.out.println("All images download succeed");
    }
    
    public static byte[] readInputStream(InputStream inStream) throws Exception{  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        while( (len=inStream.read(buffer)) != -1 ){  
            outStream.write(buffer, 0, len);  
        }  
        inStream.close();  

        return outStream.toByteArray();  
    } 

    private String checktype(String img) {
        String type = null;
        if(img.indexOf("png") != -1 ||img.indexOf("PNG") != -1  ){
            type = ".png";
        }
        else if(img.indexOf("jpg") != -1||img.indexOf("JPG") != -1){
            type = ".jpg";
        }
        return type;
    }
}
