package com.test.сurrency.cbrf.list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValCurs {

    @JacksonXmlProperty(localName = "Date", isAttribute = true)
    private String date;

    @JacksonXmlProperty(localName = "Valute")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Valute> valutes;

    public void setDate(String date) {
        this.date = date;
    }

    public void setValutes(List<Valute> valutes) {
        this.valutes = valutes;
    }

    public String getDate() {
        return date;
    }

    public List<Valute> getValutes() {
        return valutes;
    }
}
