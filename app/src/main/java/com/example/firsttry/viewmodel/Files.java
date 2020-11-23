package com.example.firsttry.viewmodel;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import android.content.Context;


import static android.content.Context.MODE_PRIVATE;


public class Files {
    private Context context;
    public  Files(Context context){
        this.context=context;
    }

    public   void writeFile(Integer data) {
        FileOutputStream fos=null;
        try {
           fos = context.openFileOutput("ServiceData.txt", MODE_PRIVATE);
          //  OutputStreamWriter osw = new OutputStreamWriter(fos);

            String testString=data.toString();
            fos.write(testString.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){
            }
        }
    }

    public   String readFile() {
        FileInputStream fin = null;
       String text="sorry buy princes in onther castle";
        try {
            fin = context.openFileInput("ServiceData.txt");
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            text = new String (bytes);
           System.out.println(text);
        }
        catch(IOException ex) {
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){
            }
        }
        return text;
    }
}
