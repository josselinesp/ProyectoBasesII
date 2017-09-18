/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Josseline
 */
@ManagedBean(name = "menu")
@SessionScoped
public class MenuItemBean {

    private List<String> items;

    public MenuItemBean() {
        items = new ArrayList<>();
        items.add("shirt");
        items.add("skirt");
        items.add("trouser");
    }

    public List<String> getItems() {
        return items;
    }
}
