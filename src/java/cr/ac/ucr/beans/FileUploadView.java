/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.beans;

/**
 *
 * @author Josseline
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "fileUploadView")
public class FileUploadView {

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() throws IOException {
        if (file != null) {
            
           
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            OutputStream outputStream = null;
            String path = "C:\\Users\\Josseline\\Documents\\UCR\\Bases II\\ProyectoBasesII\\" + file.getFileName();

            try {

                outputStream = new FileOutputStream(new File(path));

                int read = 0;
                byte[] bytes = new byte[524];
                bucle1:
                while ((read = file.getInputstream().read(bytes)) != -1 ) {
 
                    outputStream.write(bytes, 0, read);
                    System.out.println(bytes.length+"Cinthya");
                    if(bytes.length<524){
  
  break bucle1;
  }
                    

                }

                System.out.println("Done!");

            } catch (IOException e) {

            } finally {
                if (file.getInputstream() != null) {
                    try {
                        file.getInputstream().close();
                        System.out.println("222222222222222222222222222222222222222222222");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (outputStream != null) {
                    try {
                        // outputStream.flush();
                        outputStream.close();
                        System.out.println("3333333333333333333333");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

//            Path from = Paths.get("C:\\Users\\Josseline\\Documents\\UCR\\Bases II\\logica\\modelo.csv");
//            Path to = Paths.get("C:\\Users\\Josseline\\Documents\\UCR\\Bases II\\ProyectoBasesII\\" + file.getFileName());
//
////Reemplazamos el fichero si ya existe
//            CopyOption[] options = new CopyOption[]{
//                StandardCopyOption.REPLACE_EXISTING,
//                StandardCopyOption.COPY_ATTRIBUTES
//            };
//            Files.copy(from, to, options);
        }
    }
}
