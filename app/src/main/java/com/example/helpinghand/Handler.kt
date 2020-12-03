package com.example.helpinghand
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import kotlin.coroutines.coroutineContext
const val DATABASE_NAME:String="HELPING_HAND"
const val DATABASE_VERSION=1
const val TABLE_NAME:String="DETAILS"
const val COL_NAME:String="NAME"
const val COL_EMAIL ="EMAIL"
const val COL_PASS="PASSWORD"
const val COL_PHONE="PHONE"
class Handler(context:Context):SQLiteOpenHelper(context,DATABASE_NAME,null, DATABASE_VERSION)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        val table:String= "CREATE TABLE " + TABLE_NAME + "("  +
                COL_NAME + " TEXT, " +
                COL_EMAIL+ " TEXT, " +
                COL_PHONE + " TEXT, " + COL_PASS+" TEXT" +")"
        db?.execSQL(table)
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int)
    {
        TODO("Not yet implemented")
    }
    fun insert(obj:User):Long
    {
        val dbms=this.writableDatabase // a database which can read and write both//
        var cv=ContentValues()
        cv.put(COL_NAME,obj.name) //add info to partocular column //
        cv.put(COL_EMAIL,obj.email)
        cv.put(COL_PHONE,obj.no)
        cv.put(COL_PASS,obj.pass)
        var res=dbms.insert(TABLE_NAME,null,cv);//result is of type LONG//
        dbms.close()
        return res
    }
    fun getData() : ArrayList<User>
    {
        val dataList=ArrayList<User>() // this list will contain all the user data  for each user //
        val selectQuery="SELECT * FROM $TABLE_NAME" // sql statement we need to execute //
        val db=this.readableDatabase
        var cursor: Cursor?=null
        try {
            cursor=db.rawQuery(selectQuery,null)
        }
        catch(e:SQLException)
        {
            db?.execSQL(selectQuery)
            return ArrayList()
        }
        var name:String
        var email:String
        var contact:String
        var pass:String
        if(cursor.moveToFirst())
        {
            do {
                name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                email= cursor.getString(cursor.getColumnIndex(COL_EMAIL))
                contact=cursor.getString(cursor.getColumnIndex(COL_PHONE))
                pass = cursor.getString(cursor.getColumnIndex(COL_PASS))
                var obj:User=User(name,email,contact,pass)
                dataList.add(obj)
            }
            while(cursor.moveToNext())
        }
        return dataList
    }
    fun remove(name:String):Int
    {
        // to remove entries on the basis of name //
        var db=this.writableDatabase
        var ans=db.delete(TABLE_NAME, COL_NAME+"="+name,null)
        return ans
    }
}