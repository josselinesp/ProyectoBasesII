/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Josseline
 */
public class Archivo {

    private String nombreArchivo;
    private File archivo;

    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Lee cada linea del archivo y verifica la cantidad de productos produccido
     * de cada tipo
     *
     * @return int[]
     * @throws java.io.IOException
     */
    public int[] mostrarNumeroProductos() throws IOException {
        int contA = 0, contB = 0;
        int salida[] = new int[2];
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String registroActual = br.readLine();

            while (registroActual != null) {

                StringTokenizer st = new StringTokenizer(registroActual, "-");
                String hora = "", tipo = "", producto = "", tiempo = "";
                int HORA = 1, TIPO = 2, PRODUCTO = 3, TIEMPO = 4;

                int contador = 1;

                while (st.hasMoreTokens()) {

                    if (contador == HORA) {
                        hora = st.nextToken();
                    } else if (contador == TIPO) {
                        tipo = st.nextToken();
                    } else if (contador == PRODUCTO) {
                        producto = st.nextToken();
                    } else if (contador == TIEMPO) {
                        tiempo = st.nextToken();
                    }
                    contador++;
                }

                if (tipo.equalsIgnoreCase("A")) {
                    contA++;
                } else if (tipo.equalsIgnoreCase("B")) {
                    contB++;
                }
                registroActual = br.readLine();

            }//fin while

            salida[0] = contA;
            salida[1] = contB;
        }
        return salida;
    }

    /**
     * Lee cada linea del archivo y da el valor de la velocidad promedio en la
     * que se produccion ambos tipos de productos
     *
     * @return int
     * @throws IOException
     */
    public int mostrarVelocidadPromedio() throws IOException {
        int sumaVelocidad = 0, produccionTotal = 0, salida = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String registroActual = br.readLine();

            while (registroActual != null) {

                StringTokenizer st = new StringTokenizer(registroActual, "-");
                String hora = "", tipo = "", producto = "", tiempo = "";
                int HORA = 1, TIPO = 2, PRODUCTO = 3, TIEMPO = 4;

                int contador = 1;

                while (st.hasMoreTokens()) {

                    if (contador == HORA) {
                        hora = st.nextToken();
                    } else if (contador == TIPO) {
                        tipo = st.nextToken();
                    } else if (contador == PRODUCTO) {
                        producto = st.nextToken();
                    } else if (contador == TIEMPO) {
                        tiempo = st.nextToken();
                    }
                    contador++;
                }

                if (tiempo.equalsIgnoreCase("3")) {
                    sumaVelocidad = sumaVelocidad + 3;
                } else if (tiempo.equalsIgnoreCase("5")) {
                    sumaVelocidad = sumaVelocidad + 5;
                } else if (tiempo.equalsIgnoreCase("7")) {
                    sumaVelocidad = sumaVelocidad + 7;
                }
                produccionTotal++;

                registroActual = br.readLine();

            }//fin while

            salida = sumaVelocidad / produccionTotal;
        }
        return salida;
    }

    /**
     * Lee cada linea del archivo y da la cantidad de conflictos por Cola Llena
     * de cada uno de los tipos de productos
     *
     * @return int[]
     * @throws IOException
     */
    public int[] mostrarCantidadConflictos() throws IOException {
        int contA = 0, contB = 0;
        int salida[] = new int[2];
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String registroActual = br.readLine();

            while (registroActual != null) {

                StringTokenizer st = new StringTokenizer(registroActual, "-");
                String id = "", tipo = "", razon = "", hora = "";
                int ID = 1, TIPO = 2, RAZON = 3, HORA = 4;

                int contador = 1;

                while (st.hasMoreTokens()) {

                    if (contador == ID) {
                        id = st.nextToken();
                    } else if (contador == TIPO) {
                        tipo = st.nextToken();
                    } else if (contador == RAZON) {
                        razon = st.nextToken();
                    } else if (contador == HORA) {
                        hora = st.nextToken();
                    }
                    contador++;
                }

                if (tipo.equalsIgnoreCase("A") && razon.equalsIgnoreCase("Cola Llena")) {
                    contA++;
                } else if (tipo.equalsIgnoreCase("B") && razon.equalsIgnoreCase("Cola Llena")) {
                    contB++;
                }
                registroActual = br.readLine();

            }//fin while
            salida[0] = contA;
            salida[1] = contB;
        }
        return salida;
    }

    /**
     * Lee cada linea del archivo y da la cantidad de conflictos por
     * Manenimiento y pausa de cada uno de los tipos de productos
     *
     * @return int[]
     * @throws IOException
     */
    public int[] mostrarConflictosMantenimiento() throws IOException {
        int contA = 0, contB = 0, contAA = 0, contBB = 0;
        int salida[] = new int[4];
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String registroActual = br.readLine();

            while (registroActual != null) {

                StringTokenizer st = new StringTokenizer(registroActual, "-");
                String id = "", tipo = "", razon = "", hora = "";
                int ID = 1, TIPO = 2, RAZON = 3, HORA = 4;

                int contador = 1;

                while (st.hasMoreTokens()) {

                    if (contador == ID) {
                        id = st.nextToken();
                    } else if (contador == TIPO) {
                        tipo = st.nextToken();
                    } else if (contador == RAZON) {
                        razon = st.nextToken();
                    } else if (contador == HORA) {
                        hora = st.nextToken();
                    }
                    contador++;
                }

                if (tipo.equalsIgnoreCase("A") && razon.equalsIgnoreCase("Mantenimiento")) {
                    contA++;
                } else if (tipo.equalsIgnoreCase("B") && razon.equalsIgnoreCase("Mantenimiento")) {
                    contB++;
                } else if (tipo.equalsIgnoreCase("A") && razon.equalsIgnoreCase("Pausa")) {
                    contAA++;
                } else if (tipo.equalsIgnoreCase("B") && razon.equalsIgnoreCase("Pausa")) {
                    contBB++;
                }
                registroActual = br.readLine();

            }//fin while
            salida[0] = contA;
            salida[1] = contB;
            salida[2] = contAA;
            salida[3] = contBB;
        }
        return salida;
    }

    /**
     * Metodo que lee el archivo
     *
     * @return Buffered Reader
     */
    public BufferedReader getBufferedReader() {
        BufferedReader br = null;
        try {
            File archivo = new File(nombreArchivo);

            FileInputStream fis = new FileInputStream(archivo);

            InputStreamReader isr = new InputStreamReader(fis);

            br = new BufferedReader(isr);
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "Problemas en el archivo");
        }
        return br;
    }//fin getBufferedReader()
}
