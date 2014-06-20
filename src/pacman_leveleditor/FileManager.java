/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_leveleditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Marinus
 */
public class FileManager {


    public void safeLevel(char[][] levelMap) {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            try{
                FileWriter fw = new FileWriter(fileChooser.getSelectedFile()+".txt");
                for(char[] line : levelMap){
                    fw.write(line);
                    fw.write("\n");
                }
                fw.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
            
        }
    }
    
    public char[][] loadLevel() throws IOException{
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            return openMap(file);
        }
        return null;
    }
    
        /**
     * Opens a text file and reads all lines and puts then in a String array.
     * @param file
     * @return String[] of all lines in the text file.
     * @throws IOException 
     */
    public String[] openFile(File file) throws IOException {
        
        FileReader fr = new FileReader(file);
        BufferedReader textReader = new BufferedReader(fr);
        
        int lines = readLines(file);
        String[] textData = new String[lines];
        
        for(int i = 0; i < lines; i++){
            textData[i] = textReader.readLine();
        }
        
        textReader.close();
        return textData;
        
    }
    
    /**
     * Opens a file using openFile() and parses the string array to a 
     * 2D array of characters. 
     * @param file
     * @return elementMap
     * @throws IOException 
     */
    public char[][] openMap(File file) throws IOException {
        String[] textData = openFile(file);
        
        int mapWidth = textData[0].length();
        int mapHeight = textData.length;
      
        char[][] map = new char[mapHeight][mapWidth];
        
        for(int i = 0; i < mapHeight; i++){
            for(int j = 0; j < mapWidth; j++){
                map[i][j] = textData[i].charAt(j);
            }
        }
        
        return map;        
    }
    
    /**
     * Counts the number of lines in a textFile. This is used to create the
     * String array in openFile() with the correct size.
     * @return number of lines
     * @throws IOException 
     */
    int readLines(File file) throws IOException {
        FileReader file_to_read = new FileReader(file);
        BufferedReader bf = new BufferedReader(file_to_read);
        
        String line;
        int numberOfLines = 0;
        
        while((line = bf.readLine()) != null){
            numberOfLines++;
        }
        bf.close();
        
        return numberOfLines;
    }

}
