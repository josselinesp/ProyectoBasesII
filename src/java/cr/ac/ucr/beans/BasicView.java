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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    private List<Car> cars;
    private List<String> keyList;
    private List<Table> tables;
    private String key;
    private List<HashMap<String, String>> dataFile;

    @ManagedProperty("#{carService}")
    private CarService service;

    @PostConstruct
    public void init() {
//        tables = new ArrayList<Table>();
//        tables.add(new Table("Id", "d5f4sd54f"));
//        tables.add(new Table("Id", "d4fsdf444"));
//        tables.add(new Table("Year", "2015"));
//        tables.add(new Table("Year", "2017"));
//        tables.add(new Table("Brand", "Toyota"));
//        tables.add(new Table("Brand", "Susuki"));
//
//        keyList = new ArrayList<>();
//
//        keyList.add("Id");
//        keyList.add("Year");
//        keyList.add("Brand");
//        
        //tenemos un arrayList de hashmap, que funcionan como objetos, parecido a los tables que estan comentados arriba
        dataFile = new ArrayList<HashMap<String, String>>();
        dataFile.add(new HashMap<String, String>());
        dataFile.get(0).put("Id", "1");
        dataFile.get(0).put("Year", "2015");
        dataFile.get(0).put("Brand", "Susuki");
        dataFile.add(new HashMap<String, String>());
        dataFile.get(1).put("Id", "2");
        dataFile.get(1).put("Year", "2014");
        dataFile.get(1).put("Brand", "Toyota");

    }

    public Set<String> getColumnNames() {
        /*Las columnas se interpretan por medio de un hashSet de string, 
        acá lo que se hace es devolver la lista de nombres de columnas(como el keyList que esta comentado en el init
        Si pudo ser un array pero si funciona asi, dejelo asi jaja)*/
        return dataFile.size() > 0 ? dataFile.get(0).keySet() : new HashSet<String>();
    }

    public List<HashMap<String, String>> getDataFile() {
        return dataFile;
    }

    public void setDataFile(List<HashMap<String, String>> dataFile) {
        this.dataFile = dataFile;
    }

    public void compararTabla(String tabla) {
//        for (int i = 0; i < tables.size(); i++) {
//            Table table = tables.get(i);
//            if (table.getNombre_columna().equalsIgnoreCase(tabla)) {
//                tables = new 
//             
//            }
//
//        }

    }

    public List<String> getKeyList() {
        return keyList;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setKeyList(List<String> keyList) {
        this.keyList = keyList;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setService(CarService service) {
        this.service = service;
    }
}
