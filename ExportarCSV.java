/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.Archivos;
/**
 *
 * @author Gollo
 */
import com.csvreader.CsvReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import com.csvreader.CsvWriter;

 
public class ExportarCSV {
 
 
    
    public static void ArchivoNombres(String nombre){
        
         
     
         
        String outputFile = "Nombres.csv";
        boolean alreadyExists = new File(outputFile).exists();
         
     
        try {
            
             CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
           
               
            System.out.println(!alreadyExists);
                 if(!alreadyExists){
            File ArchivoEmpleados = new File(outputFile);
        csvOutput.write("Nombre");
        }   
              CsvReader nombres_import = new CsvReader("Nombres.csv");
            nombres_import.readHeaders();
            int cont = 0;
            while (nombres_import.readRecord()) {

                
            }

           

 
           
   
            csvOutput.endRecord();
 
    

     
                csvOutput.write(nombre);
                                  
            
              nombres_import.close();
            csvOutput.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    
    }


    
 
}