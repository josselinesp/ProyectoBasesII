package cr.ac.ucr.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author josseline
 */
import static com.sun.faces.facelets.util.Path.context;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {

    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
    private String country;
    private String city;
    private Map<String, String> countries;
    private Map<String, String> cities;

    @PostConstruct
    public void init() {
        countries = new HashMap<String, String>();
        countries.put("USA", "USA");
        countries.put("Germany", "Germany");
        countries.put("Brazil", "Brazil");

        Map<String, String> map = new HashMap<String, String>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        data.put("USA", map);

        map = new HashMap<String, String>();
        map.put("Berlin", "Berlin");
        map.put("Munich", "Munich");
        map.put("Frankfurt", "Frankfurt");
        data.put("Germany", map);

        map = new HashMap<String, String>();
        map.put("Sao Paolo", "Sao Paolo");
        map.put("Rio de Janerio", "Rio de Janerio");
        map.put("Salvador", "Salvador");
        data.put("Brazil", map);
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void onCountryChange() {
        if (country != null && !country.equals("")) {
            cities = data.get(country);
        } else {
            cities = new HashMap<String, String>();
        }
    }

    public void displayLocation() {
        FacesMessage msg;
        if (city != null && country != null) {
            msg = new FacesMessage("Selected", city + " of " + country);
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}

//@ManagedBean
//@ViewScoped
//public class DropdownView implements Serializable {
//
//    private List<String> items;
//    private List<String> colums;
//    private String item;
//    private String colum;
//
//    @PostConstruct
//    public void init() {
//        items = new ArrayList<>();
//
//        items.add("shirt");
//        items.add("skirt");
//        items.add("trouser");
//    }
//
//    public List<String> getItems() {
//        return items;
//    }
//
//    public void setItems(List<String> items) {
//        this.items = items;
//    }
//
//    public String getItem() {
//        return item;
//    }
//
//    public void setItem(String item) {
//        this.item = item;
//    }
//
//    public List<String> getColums() {
//        return colums;
//    }
//
//    public void setColums(List<String> colums) {
//        this.colums = colums;
//    }
//
//    public String getColum() {
//        return colum;
//    }
//
//    public void setColum(String colum) {
//        this.colum = colum;
//    }
//
//    public void onColumsChange() {
//        //  colums = new listCinthya(item);
//        
//        System.out.println("pasoooooooo");
//        colums = new ArrayList<>();
//
//        colums.add("hola");
//        colums.add("ola");
//        colums.add("la");
//         
//
//    }
//
//    public void displayLocation() throws IOException {
//        RequestContext context = RequestContext.getCurrentInstance();
//        FacesMessage msg;
//        boolean valor = false;
//        if (item != null) {
//            msg = new FacesMessage("Selected", item);
//            valor = true;
//        } else {
//            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");
//            valor = false;
//        }
//
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//        context.addCallbackParam("valor", valor);
//
//        if (valor) {
//            //cargartabla(item);
//            ExternalContext eContext = FacesContext.getCurrentInstance().getExternalContext();
//            eContext.redirect("faces/tabla.xhtml");
//        }
//    }
//}
