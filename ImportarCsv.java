/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.Archivos;

import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.csvreader.CsvReader;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author Gollo
 */
public class ImportarCsv {
        public JTable cargarTabla(String nombre) {
        String encabezados[] = null;
        JTable tablaM = new JTable();
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<String> nombres = new ArrayList<>();
        nombres = cargarNombres();
        try {
            if (!nombres.isEmpty()) {

                for (int i = 0; i < nombres.size(); i++) {
                    String nombreLis = nombres.get(i);

                    if (nombreLis.equalsIgnoreCase(nombre)) {

                        CsvReader modelos_import = new CsvReader(nombre + ".csv");

                        int cont = 0;
                        Object datos[][] = new Object[contarDatos(nombre)][cargarColumnas(nombre)];

                        int cont2 = 0;

                        encabezados = new String[modelos_import.getColumnCount()];
                        while (modelos_import.readRecord()) {
                            encabezados = new String[modelos_import.getColumnCount()];
                            if (cont >= 1) {

                                encabezados = new String[modelos_import.getColumnCount()];
                                for (int j = 0; j < modelos_import.getColumnCount(); j++) {
                                    if (cont2 < datos.length) {
                                        Object casteo = null;
                                        String dato = modelos_import.get(j);
                                       
                                          if (esNumero(dato)) {
if (dato.contains(".")) {
                                            casteo = Float.parseFloat(dato);

                                        }else
    
    if(dato.equalsIgnoreCase("")){
    casteo=null;
    }else{
    casteo = Integer.parseInt(dato);
    }
                                            
                                        } else {
                                              if(dato.equalsIgnoreCase("")){
    casteo=null;
    }else{
    casteo = dato;
    }
                                           

                                        }

                                        datos[cont2][j] = casteo;

                                    }

                                }
                                cont2++;

                            } else if (cont == 0) {

                                for (int j = 0; j < modelos_import.getColumnCount(); j++) {

                                    String dato = modelos_import.get(j);

                                    encabezados[j] = dato;

                                }

                            }

                            cont++;

                        }

                        Object informacion[] = new Object[datos.length];
                        for (int j = 0; j < datos[0].length; j++) {
                            for (int m = 0; m < datos.length; m++) {

                                informacion[m] =  datos[m][j];

                            }
                            modelo.addColumn(encabezados[j], informacion);

                        }
                        modelos_import.close();

                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tablaM.setModel(modelo);
        tablaM.setName(nombre);
        JTableHeader th = null;
        for (int i = 0; i < tablaM.getColumnCount(); i++) {

            th = tablaM.getTableHeader();
            TableColumnModel tcm = th.getColumnModel();

// se obtiene la posición de la columna que queremos conocer y con getheadervalue se obtiene el
// titulo de la columna para hacer las validaciones
            TableColumn tcmn = tcm.getColumn(i);
            tcmn.setHeaderValue(encabezados[i]);

        }

        tablaM.setTableHeader(th);
        return tablaM;
    }

    

    private static boolean esNumero(String datos) {
        datos = datos.trim();
        char dat[] = datos.toCharArray();
        for (int i = 0; i < dat.length; i++) {
            if (dat[i] == '1' || dat[i] == '2' || dat[i] == '3' || dat[i] == '4' || dat[i] == '5' || dat[i] == '6' || dat[i] == '7' || dat[i] == '8' || dat[i] == '9' || dat[i] == '0' || dat[i] == '.') {

            } else {

                return false;
            }

        }

        return true;
    }

    public static boolean esLetra(String datos) {

        char dat[] = datos.toCharArray();

        String d = dat[0] + "";
        String d2 = dat[dat.length - 1] + "";
        if (d.equalsIgnoreCase("'") && d2.equalsIgnoreCase("'")) {

        } else {

            return false;
        }

        return true;
    }

    public static int contarDatos(String nombre) {
        int cont = 0;

        try {

            CsvReader modelos_import = new CsvReader(nombre + ".csv");
            modelos_import.readHeaders();

            while (modelos_import.readRecord()) {

                cont++;

            }

            modelos_import.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cont;

    }

    public ArrayList<String> cargarNombres() {

        ArrayList<String> nombres = new ArrayList<String>();
        try {

            CsvReader nombres_import = new CsvReader("Nombres.csv");
            nombres_import.readHeaders();
            int cont = 0;
            while (nombres_import.readRecord()) {

                if (cont != 1) {
                    String nombre = nombres_import.get(0);

                    nombres.add(nombre);
                }
                cont++;
            }

            nombres_import.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nombres;

    }

    public int cargarColumnas(String nombre) {
        int cont = 0;

        try {

            CsvReader nombres_import = new CsvReader(nombre + ".csv");
            nombres_import.readHeaders();

            while (nombres_import.readRecord()) {

                cont = nombres_import.getColumnCount();
            }

            nombres_import.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cont;

    }

}
