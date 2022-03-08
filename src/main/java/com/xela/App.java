package com.xela;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App 
{
    public static void main( String[] args )
    {
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num_mona;
        String line;
        boolean condition = false;
        String mona = "mona";
        do {
            try {
            
                ReaderWriter write = new ReaderWriter("mona.txt", 'W');
                System.out.println("inserire il numero di mona da scrivere:");
                line = input.readLine();
                num_mona = Integer.parseInt(line);
                for (int i = 0; i < num_mona; i++) {
                    write.toFile(mona);
                }
                write.closeFile(); 
            } catch (IOException e) {
                System.out.println("errore generico");
            } catch (FileException e){
                System.out.println(e.getMatter());
            }catch (NumberFormatException e){
                System.out.println("inserire un numero valido");
            }

            condition = true;
        } while (condition);
        
    }
}
