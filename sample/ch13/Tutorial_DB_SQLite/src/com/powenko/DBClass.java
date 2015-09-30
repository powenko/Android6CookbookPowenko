package com.powenko;




import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

//public class exchangeRateDB extends SQLiteOpenHelper
public class DBClass extends SQLiteOpenHelper
{
	  private List<News> li=new ArrayList<News>();
private final static String DATABASE_NAME = "powenko.sqlite";
//////////////////////////////////////////
//The Android's default system path of your application database.
private static String DB_PATH = "/data/data/com.powenko/databases/";

private static String DB_NAME = DATABASE_NAME; //"myDBName";

private SQLiteDatabase myDataBase; 

private Context myContext;
/////////////////////////////////////////
private final static int DATABASE_VERSION = 1;
//private final static String TABLE_NAME = "exchangeRate_table";
public String TABLE_NAME = "powenkotable";




public DBClass(Context context) {
	//super(context);

	  super(context, DATABASE_NAME, null, DATABASE_VERSION);
	// TODO Auto-generated constructor stub
	  this.myContext = context;
}


@Override
public void onCreate(SQLiteDatabase db)
{
  /*
  String sql = "CREATE TABLE " + TABLE_NAME + " (" + FIELD_id
      + " INTEGER primary key autoincrement, " + " " +
      FIELD_TEXT + " text, " + " " +
      FIELD_lastBuildDate + " text , " +FIELD_sort + " INTEGER "+
      		")";
  db.execSQL(sql);
  */
}
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
{
  String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
  db.execSQL(sql);
  onCreate(db);
}


public Cursor doSQL(String i_sql)
{

	 SQLiteDatabase sqliteDB = this.getReadableDatabase();
	Cursor cursor = sqliteDB.rawQuery(i_sql, null);
	
	return cursor;
	/*
	 SQLiteDatabase db = this.getReadableDatabase();
	//  Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, FIELD_sort);
	  Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
	  return cursor;
	  */
}
public Cursor select()
{
  SQLiteDatabase db = this.getReadableDatabase();
  Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
  return cursor;
}

/*
public void delete(int id)
{
  SQLiteDatabase db = this.getWritableDatabase();
  String where = FIELD_id + " = ?";
  String[] whereValue =
  { Integer.toString(id) };
  db.delete(TABLE_NAME, where, whereValue);
}
*/
/*
public void update(int id, 
		String text,
		String textdynamicRate,
		String textlastBuildDate,
		int intFIELD_sort)
{
  SQLiteDatabase db = this.getWritableDatabase();
  String where = FIELD_id + " = ?";
  String[] whereValue =
  { Integer.toString(id) };
  
  
  ContentValues cv = new ContentValues();
  cv.put(FIELD_TEXT, text);
  cv.put(FIELD_dynamicRate , textdynamicRate);

  cv.put(FIELD_sort, intFIELD_sort); 
  db.update(TABLE_NAME, cv, where, whereValue);
}*/

public void onDropTable()
{
  SQLiteDatabase db = this.getWritableDatabase();
  String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
  db.execSQL(sql);
  onCreate(db);
}
public void setTableName(String iTableName)
{
  //super(context, DATABASE_NAME, null, DATABASE_VERSION);
	TABLE_NAME=iTableName;
}

/////////////////////////////////////////////////////

public void createDataBase() throws IOException{
	boolean dbExist = checkDataBase();
	
	if(dbExist){
	//do nothing - database already exist
	}else{
		this.getReadableDatabase();
		
		try {
		
		copyDataBase();
		dbExist = checkDataBase();
		
		
	
	} catch (IOException e) 
	{
	throw new Error("Error copying database");
	}
	
	}
}
/**
* Check if the database already exist to avoid re-copying the file each time you open the application.
* @return true if it exists, false if it doesn't
*/
private boolean checkDataBase(){

SQLiteDatabase checkDB = null;

try{
String myPath = DB_PATH + DB_NAME;
checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

}catch(SQLiteException e){

//database does't exist yet.

}

if(checkDB != null){

checkDB.close();

}

return checkDB != null ? true : false;
}

/**
* Copies your database from your local assets-folder to the just created empty database in the
* system folder, from where it can be accessed and handled.
* This is done by transfering bytestream.
* */
private void copyDataBase() throws IOException{
	
	//Open your local db as the input stream
	InputStream myInput = myContext.getAssets().open(DB_NAME);
	
	// Path to the just created empty db
	String outFileName = DB_PATH + DB_NAME;
	
	//Open the empty db as the output stream
	OutputStream myOutput = new FileOutputStream(outFileName);
	
	//transfer bytes from the inputfile to the outputfile
	byte[] buffer = new byte[1024];
	int length;
	while ((length = myInput.read(buffer))>0){
	myOutput.write(buffer, 0, length);
	}
	
	//Close the streams
	myOutput.flush();
	myOutput.close();
	myInput.close();

}

public void openDataBase() throws SQLException{
	
	//Open the database
	String myPath = DB_PATH + DB_NAME;
	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
			//SQLiteDatabase.OPEN_READONLY);

}

@Override
public synchronized void close() {
	
	if(myDataBase != null)
	myDataBase.close();
	
	super.close();

}

public long insert(String title,String info)
{
  SQLiteDatabase db = this.getWritableDatabase();
 
  ContentValues cv = new ContentValues();
  cv.put("info", info);
  cv.put("title", title);
  long row = db.insert(TABLE_NAME, null, cv);
  return row;
}

public List<News> FunGetNewsInfo(Cursor myCursor)
{
	List<News> data2=new ArrayList<News>();
    String a1="";
    if (myCursor.moveToFirst()) 
    {
  	  data2 = new ArrayList<News>(); 
  	  do
  	  {    		      		 
  		  News news=new News();
    		news._title=myCursor.getString(myCursor.getColumnIndex("title"));
      		news._info=myCursor.getString(myCursor.getColumnIndex("info"));
      	  data2.add(news);
      	  
  	  }while(myCursor.moveToNext() );
    }
    myCursor.close();      
    return data2;
}


}
