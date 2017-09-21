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
 * @author
 */
public class NewClass {

    public void sf() throws IOException {
        Path from = Paths.get("C:\\archivo.txt");
        Path to = Paths.get("D:\\Archivos\\archivo.txt");

//Reemplazamos el fichero si ya existe
        CopyOption[] options = new CopyOption[]{
            StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES
        };
        Files.copy(from, to, options);
    }
}
