package com.test.сurrency.cbrf.range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Record {

    @JacksonXmlProperty(localName = "Date", isAttribute = true)
    private String date;

    @JacksonXmlProperty
    private String Nominal;

    @JacksonXmlProperty
    private String Value;

    public void setDate(String date) {
        this.date = date;
    }

    public void setNominal(String nominal) {
        Nominal = nominal;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getDate() {
        return date;
    }

    public String getNominal() {
        return Nominal;
    }

    public String getValue() {
        return Value;
    }
}
