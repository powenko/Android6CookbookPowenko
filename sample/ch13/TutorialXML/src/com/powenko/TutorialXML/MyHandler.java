package com.powenko.TutorialXML; 


import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes; 
import org.xml.sax.SAXException; 
import org.xml.sax.helpers.DefaultHandler; 

public class MyHandler extends DefaultHandler
{ 

  private boolean in_item = false;
  private boolean in_title = false;
  private boolean in_link = false;
  private boolean in_desc = false;
  private boolean in_date = false;
  private boolean in_mainTitle = false;
  private List<News> li;
  private News news;
  private String title="";
  private StringBuffer buf=new StringBuffer();

  public List<News> getParsedData()
  { 
    return li; 
  }
  public String getRssTitle()
  { 
    return title; 
  }
  @Override 
  public void startDocument() throws SAXException
  { 
    li = new ArrayList<News>(); 
  } 
  @Override 
  public void endDocument() throws SAXException
  {
  } 
  @Override 
  public void startElement(String namespaceURI, String localName, 
               String qName, Attributes atts) throws SAXException
  { 
    if (localName.equals("item"))
    { 
      this.in_item = true;
      news=new News();
    }
    else if (localName.equals("title"))
    { 
      if(this.in_item)
      {
        this.in_title = true;
      }
      else
      {
        this.in_mainTitle = true;
      }
    }
    else if (localName.equals("link"))
    { 
      if(this.in_item)
      {
        this.in_link = true;
      }
    }
    else if (localName.equals("description"))
    { 
      if(this.in_item)
      {
        this.in_desc = true;
      }
    }
    else if (localName.equals("pubDate"))
    { 
      if(this.in_item)
      {
        this.in_date = true;
      }
    } 
  }
  @Override 
  public void endElement(String namespaceURI, String localName,
                         String qName) throws SAXException
  { 
    if (localName.equals("item"))
    { 
      this.in_item = false;
      li.add(news);
    }
    else if (localName.equals("title"))
    { 
      if(this.in_item)
      {
        news._title=buf.toString().trim();
        buf.setLength(0);
        this.in_title = false;
      }
      else
      {
        title=buf.toString().trim();
        buf.setLength(0);
        this.in_mainTitle = false;
      }
    }
    else if (localName.equals("link"))
    { 
      if(this.in_item)
      {
        news._link=buf.toString().trim();
        buf.setLength(0);
        this.in_link = false;
      }
    }
    else if (localName.equals("description"))
    { 
      if(in_item)
      {
        news._desc=buf.toString().trim();
        buf.setLength(0);
        this.in_desc = false;
      }
    }
    else if (localName.equals("pubDate"))
    { 
      if(in_item)
      {
    	news._date=buf.toString().trim();
    	buf.setLength(0);
        this.in_date = false;
      }
    }else{
    	buf.setLength(0);
    }
  } 
  @Override 
  public void characters(char ch[], int start, int length)
  { 
    if(this.in_item||this.in_mainTitle)
    {
      buf.append(ch,start,length);
    }
  } 
}