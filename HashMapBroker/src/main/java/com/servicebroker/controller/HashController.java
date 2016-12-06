package com.servicebroker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.servicebroker.service.HashingService;

/**
 * 
 * @author Yoga Chandran
 * This class acts as the controller for the service broker
 */
@RestController
public class HashController {

    @Autowired
    HashingService service;

/**
 *  This method adds or updates and entry in to the custom map
 * @param key
 * @param value
 * @return
 */
    @RequestMapping(value = "/addEntry/{key}/{value}", method = RequestMethod.POST)
    public ResponseEntity<String> put(@PathVariable("key") String key,
                                      @PathVariable("value") String value) {
        service.put(key, value);
        return new ResponseEntity<>("{Success: Key Added}", HttpStatus.OK);
    }

    /**
     * This controller method returns the value for the key
     * @param key
     * @return
     */
    @RequestMapping(value = "/getEntry/{key}", method = RequestMethod.GET)
    public ResponseEntity<Object> get(@PathVariable("key") String key) {
        Object result = service.get(key);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("{}", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This method deletes the key value pair from the map
     * @param key
     * @return
     */
    @RequestMapping(value = "/deleteEntry/{key}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("key") String key) {
        Object result = service.get(key);
        String output = null;
        if (result != null) {
            service.delete(key);
            output = "{Key Deleted}";
        } else {
        	output = "{Key does not exist}";
        }
        return new ResponseEntity<String>(output, HttpStatus.OK);
    }
}
