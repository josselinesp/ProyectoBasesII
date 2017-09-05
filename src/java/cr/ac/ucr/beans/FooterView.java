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
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean
public class FooterView {

    /**
     * Valida que los datos ingresados de usuario y contraseña sean corrector y
     * envia un mensaje de acuerdo al resultado
     *
     * @param event Accion por el boton Iniciar sesión
     * @throws IOException
     */
    public void accesoFacebook(ActionEvent event) throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();

        boolean loggedIn = true;

        context.addCallbackParam("loggedIn", loggedIn);

        ExternalContext eContext = FacesContext.getCurrentInstance().getExternalContext();
        eContext.redirect("https://www.facebook.com/UniversidadCostaRica/?fref=ts");

    }
}
