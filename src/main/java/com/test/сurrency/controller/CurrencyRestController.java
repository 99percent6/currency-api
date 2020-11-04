package com.test.сurrency.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.test.сurrency.cbrf.list.ValCurs;
import com.test.сurrency.config.CbrfConfigProperties;
import com.test.сurrency.rest.RestClient;
import com.test.сurrency.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RestController
@RequestMapping(value = "/v1/currency", produces = "application/json")
public class CurrencyRestController {

    @Autowired
    private RestClient restClient;

    @Autowired
    private CbrfConfigProperties cbrfConfigProperties;

    @Autowired
    private JsonUtils jsonUtils;

    private String regex = "\\d{2}[./]\\d{2}[./]\\d{4}";

    @GetMapping("/list")
    public ResponseEntity<String> handleSingleDay(@RequestParam String day) {

        // validate request param
        Pattern pattern = Pattern.compile(regex);
        Matcher dayMatcher = pattern.matcher(day);

        if (!dayMatcher.find()) {
            String errorResponse = jsonUtils.makeJsonStringError("Check request param 'day'. The value must match the pattern " + regex);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // fetch currency list
        String url = cbrfConfigProperties.getApiUrl() + "/XML_daily.asp?date_req=" + day;
        ResponseEntity<String> responseEntity = restClient.get(url);
        ValCurs valCurs;
        String jsonResult = "";

        // convert xml to json
        try {
            XmlMapper xmlMapper = new XmlMapper();
            valCurs = xmlMapper.readValue(responseEntity.getBody(), ValCurs.class);
            ObjectMapper mapper = new ObjectMapper();
            jsonResult = mapper.writeValueAsString(valCurs);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            String errorResponse = jsonUtils.makeJsonStringError("Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

        return ResponseEntity.ok().body(jsonResult);
    }

    @GetMapping("/range")
    public ResponseEntity<String> handleRange(@RequestParam String dateFrom, @RequestParam String dateTo, @RequestParam String currencyCode) {

        // validate request params
        Pattern pattern = Pattern.compile(regex);
        Matcher dateFromMatcher = pattern.matcher(dateFrom);
        Matcher dateToMatcher = pattern.matcher(dateTo);

        if (!dateFromMatcher.find() | !dateToMatcher.find()) {
            String errorResponse = jsonUtils.makeJsonStringError("Check request params 'dateFrom' and 'dateTo'. The value must match the pattern " + regex);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // fetch currency range
        String urlTail = "/XML_dynamic.asp?date_req1=" + dateFrom + "&date_req2=" + dateTo + "&VAL_NM_RQ=" + currencyCode;
        String url = cbrfConfigProperties.getApiUrl() + urlTail;
        ResponseEntity<String> responseEntity = restClient.get(url);

        com.test.сurrency.cbrf.range.ValCurs valCurs;
        String jsonResult = "";

        // convert xml to json
        try {
            XmlMapper xmlMapper = new XmlMapper();
            valCurs = xmlMapper.readValue(responseEntity.getBody(), com.test.сurrency.cbrf.range.ValCurs.class);
            ObjectMapper mapper = new ObjectMapper();
            jsonResult = mapper.writeValueAsString(valCurs);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            String errorResponse = jsonUtils.makeJsonStringError("Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

        return ResponseEntity.ok().body(jsonResult);
    }
}
