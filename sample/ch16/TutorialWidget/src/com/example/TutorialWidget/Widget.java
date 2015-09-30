/*
 * Copyright (C) 2009 nEx.Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.TutorialWidget;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.widget.RemoteViews;

public class Widget extends AppWidgetProvider
{    

	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
	int[] appWidgetIds) {
	Timer timer = new Timer();
	timer.scheduleAtFixedRate(new MyTime(context, appWidgetManager), 
			1, 1000);
	}
    
    private class MyTime extends TimerTask {
    	RemoteViews remoteViews;
    	AppWidgetManager appWidgetManager;
    	ComponentName thisWidget;
    	
  	
    	public MyTime(Context context, AppWidgetManager appWidgetManager) {
    	this.appWidgetManager = appWidgetManager;
    		remoteViews = new RemoteViews(context.getPackageName(), 
    				R.layout.widgetlayout );
    		thisWidget = new ComponentName(context, Widget.class);
    	}
    	@Override
    	public void run() {
    		
    		Calendar cal=Calendar.getInstance();
        	String tY=String.valueOf(cal.get(Calendar.YEAR));
        	String tM=String.valueOf(cal.get(Calendar.MONTH));
        	if (tM.length()<2){ tM="0"+tM;  }
        	String tD=String.valueOf(cal.get(Calendar.DATE));
        	if (tD.length()<2){ tD="0"+tD;  }
        	String tH=String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
        	if (tH.length()<2){ tH="0"+tH;  }
        	String tMin=String.valueOf(cal.get(Calendar.MINUTE));
        	if (tMin.length()<2){ tMin="0"+tMin;  }        	
        	String tSec=String.valueOf(cal.get(Calendar.SECOND  ));
        	if (tSec.length()<2){ tSec="0"+tSec;  }
        	String t_allCurrentTime=tY+":"+tM+":"+tD+"\n"+tH+":"+tMin+":"+tSec+"";
        	
    	remoteViews.setTextViewText(R.id.TextView01,"Time:\n"+ t_allCurrentTime);
    	appWidgetManager.updateAppWidget(thisWidget, remoteViews);
    	}
    	}
}
