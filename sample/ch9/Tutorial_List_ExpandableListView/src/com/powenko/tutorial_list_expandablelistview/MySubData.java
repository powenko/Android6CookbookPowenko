package com.powenko.tutorial_list_expandablelistview;

import java.util.ArrayList;
import java.util.List;

public class MySubData {
	public String string;
	  public final List<String> children = new ArrayList<String>();

	  public MySubData(String string) {
	    this.string = string;
	  }
}
