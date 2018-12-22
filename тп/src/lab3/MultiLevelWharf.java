package lab3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MultiLevelWharf {
	ArrayList<Wharf<ITransport>> parkingStages;
    private  int countPlaces = 20; 
    private int pictureWidth;

	private int pictureHeight;
    public MultiLevelWharf(int countStages, int pictureWidth, int pictureHeight)
    {
        parkingStages = new ArrayList<Wharf<ITransport>>();
        for(int i =0; i< countStages; ++i)
        {
            parkingStages.add(new Wharf<ITransport>(countPlaces, pictureWidth, pictureHeight));
        }
    }
   

    public Wharf<ITransport> getWharf(int ind){
   	 if((ind>-1) && (ind < parkingStages.size()))
        {
            return parkingStages.get(ind);
        }
        return null;
    }
    public void saveData(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            writeToFile("ParkingStages:" + parkingStages.size() + System.lineSeparator(), bw);
            for (Wharf<ITransport> level : parkingStages) {
                writeToFile("Level" + System.lineSeparator(), bw);
                for (int i = 0; i < countPlaces; i++) {
                	try{
                		ITransport ship = level.getShip(i);                     
                        if (ship.getClass().getSimpleName().equals("SimpleShip")) {
                            writeToFile(i + ":SimpleShip:" + ship.getInfo(), bw);
                        }
                        if (ship.getClass().getSimpleName().equals("Ship")) {
                            writeToFile(i + ":Ship:" + ship.getInfo(), bw);
                        }
                        writeToFile(System.lineSeparator(), bw);
                	}catch(Exception ex){ }
                	finally { }

                }
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
 }
 
 private void writeToFile(String text, BufferedWriter writer) {
        try {
            char[] info = text.toCharArray();
            writer.write(info, 0, info.length);
        } catch (Exception e) {
            System.out.println(e);
        }
  }
 
 public void loadData(String filename) throws Exception{
        File file = new File(filename);
        if (!file.exists()) {
        	 throw new FileNotFoundException();
        }
        String bufferTextFromFile = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                bufferTextFromFile += line + "\n";
            }
            String[] strs = bufferTextFromFile.split("\n");
            if (strs[0].contains("ParkingStages")) {
                int count = Integer.parseInt(strs[0].split(":")[1]);
                if (parkingStages != null) {
                	parkingStages.clear();
                }
                parkingStages = new ArrayList<Wharf<ITransport>>(count);
            } else {
            	throw new Exception("Неверный формат файла");
            }
            int counter = -1;
            ITransport ship = null;
            for (int i = 1; i < strs.length; ++i) {
                if (strs[i].equals("Level")) {
                    counter++;
                    parkingStages.add(new Wharf<ITransport>(countPlaces, pictureWidth, pictureHeight));
                    continue;
                }
                if (strs[i].isEmpty() || strs[i] == null) {
                    continue;
                }
                if (strs[i].split(":")[1].equals("Ship")) {
                    ship = new Ship(strs[i].split(":")[2]);
                } else if (strs[i].split(":")[1].equals("SimpleShip")) {
                    ship = new SimpleShip(strs[i].split(":")[2]);
                }
                parkingStages.get(counter).setShip(Integer.parseInt(strs[i].split(":")[0]), ship);
            }
        } catch (Exception e) {
            throw e;        }
    }

}
