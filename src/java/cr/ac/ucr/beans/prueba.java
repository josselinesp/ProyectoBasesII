/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.beans;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Path from = Paths.get("C:\\Users\\Josseline\\Documents\\UCR\\Bases II\\logica\\modelo.csv");
        Path to = Paths.get("C:\\Users\\Josseline\\Documents\\UCR\\Bases II\\ProyectoBasesII\\modelo.csv");

//Reemplazamos el fichero si ya existe
        CopyOption[] options = new CopyOption[]{
            StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES
        };
        Files.copy(from, to, options);
    }

}
