package com.chl.webserver.catalina.startup;

import com.chl.webserver.catalina.connector.http.HttpConnector;

/**
 * 启动类，通过实例化HttpConnector类，调用其start()方法可以启动程序
 * @author chenhailong
 *
 */
public final class Bootstrap {
  public static void main(String[] args) {
    HttpConnector connector = new HttpConnector();
    connector.start();
  }
}