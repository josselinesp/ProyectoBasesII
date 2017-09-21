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
import java.util.List;
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

    @ManagedProperty("#{carService}")
    private CarService service;

    @PostConstruct
    public void init() {
        tables = new ArrayList<Table>();
        tables.add(new Table("Id", "d5f4sd54f"));
        tables.add(new Table("Id", "d4fsdf444"));
        tables.add(new Table("Year", "2015"));
        tables.add(new Table("Year", "2017"));
        tables.add(new Table("Brand", "Toyota"));
        tables.add(new Table("Brand", "Susuki"));

        keyList = new ArrayList<>();

        keyList.add("Id");
        keyList.add("Year");
        keyList.add("Brand");

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
