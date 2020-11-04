package com.test.сurrency.cbrf.list;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Valute {

    @JacksonXmlProperty(isAttribute = true)
    private String ID;

    @JacksonXmlProperty
    private String NumCode;

    @JacksonXmlProperty
    private String CharCode;

    @JacksonXmlProperty
    private String Nominal;

    @JacksonXmlProperty
    private String Name;

    @JacksonXmlProperty
    private String Value;

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNumCode(String numCode) {
        NumCode = numCode;
    }

    public void setCharCode(String charCode) {
        CharCode = charCode;
    }

    public void setNominal(String nominal) {
        Nominal = nominal;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getID() {
        return ID;
    }

    public String getNumCode() {
        return NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public String getNominal() {
        return Nominal;
    }

    public String getName() {
        return Name;
    }

    public String getValue() {
        return Value;
    }
}
