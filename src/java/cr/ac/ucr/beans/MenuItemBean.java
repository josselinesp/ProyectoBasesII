/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Josseline
 */
@ManagedBean(name = "menu")
@SessionScoped
public class MenuItemBean {

    private List<String> items;
    private String item;

    public MenuItemBean() {
        items = new ArrayList<>();
        items.add("shirt");
        items.add("skirt");
        items.add("trouser");
    }

    public List<String> getItems() {
        return items;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void enviarTabla() {
        FacesMessage msg;
        System.out.println("item1" + item);
        if (item != null) {
            //cargarTabla(item)
            System.out.println("item2" + item);
            msg = new FacesMessage("Carga correcta");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalido", "Tabla no seleccionada");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
