/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author developer
 */
@Component(value = "languageBean")
@Scope(value = "session")
public class LanguageBean implements Serializable {

    private String localeCode;

    private static List languages;

    public List getLanguages() {
        if (languages == null) {
            languages = new ArrayList();
            languages.add("ar");
            languages.add("en");
        }
        return languages;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    //value change event listener
    public void localeCodeChanged() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(localeCode));
    }

}
