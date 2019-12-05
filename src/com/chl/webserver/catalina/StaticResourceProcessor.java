package com.chl.webserver.catalina;

import java.io.IOException;

import com.chl.webserver.catalina.connector.http.HttpRequest;
import com.chl.webserver.catalina.connector.http.HttpResponse;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
