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
    private String name_table;
    private List<String> items;

    public List<String> getItems() {
        return items;
    }
    @ManagedProperty("#{carService}")
    private CarService service;

    @PostConstruct
    public void init() {

        cars = service.createCars(2);
        items = new ArrayList<>();
        
        items.add("Id");
        items.add("Year");
        items.add("Brand");
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setService(CarService service) {
        this.service = service;
    }

    public String getName_table() {
        return name_table;
    }

    public void setName_table(String name_table) {
        this.name_table = name_table;
    }

}
