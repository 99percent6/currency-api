package com.test.сurrency.cbrf.range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValCurs {

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String currencyCode;

    @JacksonXmlProperty(localName = "DateRange1", isAttribute = true)
    private String dateFrom;

    @JacksonXmlProperty(localName = "DateRange2", isAttribute = true)
    private String dateTo;

    @JacksonXmlProperty(localName = "Record")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Record> records;

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public List<Record> getRecords() {
        return records;
    }
}
