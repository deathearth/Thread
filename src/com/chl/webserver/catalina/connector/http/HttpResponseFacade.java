package com.chl.webserver.catalina.connector.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class HttpResponseFacade implements HttpServletResponse {
  private HttpServletResponse response;
  public HttpResponseFacade(HttpResponse response) {
    this.response = response;
  }

  /** implementation of HttpServletResponse  */
  public void addCookie(Cookie cookie) {
    response.addCookie(cookie);
  }

  public void addDateHeader(String name, long value) {
    response.addDateHeader(name, value);
  }

  public void addHeader(String name, String value) {
    response.addHeader(name, value);
  }

  public void addIntHeader(String name, int value) {
    response.addIntHeader(name, value);
  }

  public boolean containsHeader(String name) {
    return response.containsHeader(name);
  }

  public String encodeRedirectURL(String url) {
    return response.encodeRedirectURL(url);
  }

  public String encodeRedirectUrl(String url) {
    return response.encodeRedirectUrl(url);
  }

  public String encodeUrl(String url) {
    return response.encodeUrl(url);
  }

  public String encodeURL(String url) {
    return response.encodeURL(url);
  }

  public void flushBuffer() throws IOException {
     response.flushBuffer();
  }

  public int getBufferSize() {
    return response.getBufferSize();
  }

  public String getCharacterEncoding() {
    return response.getCharacterEncoding();
  }

  public Locale getLocale() {
    return response.getLocale();
  }

  public ServletOutputStream getOutputStream() throws IOException {
    return response.getOutputStream();
  }

  public PrintWriter getWriter() throws IOException {
    return response.getWriter();
  }

  public boolean isCommitted() {
    return response.isCommitted();
  }

  public void reset() {
    response.reset();
  }

  public void resetBuffer() {
    response.resetBuffer();
  }

  public void sendError(int sc) throws IOException {
    response.sendError(sc);
  }

  public void sendError(int sc, String message) throws IOException {
    response.sendError(sc, message);
  }

  public void sendRedirect(String location) throws IOException {
    response.sendRedirect(location);
  }

  public void setBufferSize(int size) {
    response.setBufferSize(size);
  }

  public void setContentLength(int length) {
    response.setContentLength(length);
  }

  public void setContentType(String type) {
    response.setContentType(type);
  }

  public void setDateHeader(String name, long value) {
    response.setDateHeader(name, value);
  }

  public void setHeader(String name, String value) {
    response.setHeader(name, value);
  }

  public void setIntHeader(String name, int value) {
    response.setIntHeader(name, value);
  }

  public void setLocale(Locale locale) {
    response.setLocale(locale);
  }

  public void setStatus(int sc) {
    response.setStatus(sc);
  }

  public void setStatus(int sc, String message) {
    response.setStatus(sc, message);
  }

@Override
public String getContentType() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void setCharacterEncoding(String charset) {
	// TODO Auto-generated method stub
	
}

@Override
public void setContentLengthLong(long len) {
	// TODO Auto-generated method stub
	
}

@Override
public int getStatus() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public String getHeader(String name) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Collection<String> getHeaders(String name) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Collection<String> getHeaderNames() {
	// TODO Auto-generated method stub
	return null;
}
}