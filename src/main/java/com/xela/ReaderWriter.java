package com.xela;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriter {
    private char mode; //'r' = read, 'w' = write
    private BufferedReader reader;
    private BufferedWriter writer;

    public ReaderWriter(String fileName, char mode)throws IOException{
        if(mode == 'W' || mode == 'w'){
            this.mode = 'W';
            writer = new BufferedWriter(new FileWriter(fileName, true));
        }else if (mode == 'R' || mode == 'r'){
            this.mode = 'R';
            reader = new BufferedReader(new FileReader(fileName));
        }
    }

    public void toFile(String line) throws IOException, FileException{
        if(this.mode == 'R'){
            throw new FileException("File aperto in lettura!");
        }
        writer.write(line);
        writer.newLine();
    }

    public String fromFile() throws IOException, FileException{
        String tmp;
        if(this.mode == 'W'){
            throw new FileException("File aperto in scrittura!");
        }
        tmp = reader.readLine();
        if (tmp == null) {
            throw new FileException("Raggiunta la fine del file!");
        }
        return tmp;
    }

    public void closeFile() throws IOException{
        if(this.mode  == 'W'){
            writer.close();
        }else if (this.mode == 'R'){
            reader.close();
        }
    }
}
