package edu.umich.api.tester.service;

import edu.umich.api.tester.domain.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class APIClient {

   @Autowired
   private RestTemplate restTemplate;

   public API invoke(API api) {
      return api;
   }
}
