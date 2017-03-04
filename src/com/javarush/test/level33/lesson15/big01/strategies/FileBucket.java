package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("tmp", null);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize(){
        return path.toFile().length();
    }

    public void putEntry(Entry entry){
        try {
            FileOutputStream fos = new FileOutputStream(path.toFile());
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(entry);
            fos.close();
            ous.close();
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry(){
        Entry entry = null;
        if (path.toFile().length() > 0)
        {
            try {
                FileInputStream fis = new FileInputStream(path.toFile());
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object object = ois.readObject();
                fis.close();
                ois.close();
                entry = (Entry) object;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return entry;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
