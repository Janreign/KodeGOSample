package ph.kodego.aragon.janreign.module_2.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context): SQLiteOpenHelper(context,DATABASENAME, null,DATABASEVERSION) {

    companion object {
        private val DATABASEVERSION = 7
        private val DATABASENAME = "studentdatabase"

        val tableStudents = "student_table"
        val studentId = "id"
        val studentFirstName = "firstname"
        val studentlastName = "lastname"
        var yearstarted = "year_started"
        var course = "course"

        //added January 31,2023
        val tableContacts = "student_contacts"
        val contactID = "id"
        val studentcontactID = "student_id"
        val contactType = "contact_type"
        val contactDetails = "contact_details"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATESTUDENTSTABLE =
                "CREATE TABLE $tableStudents " +
                "($studentId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$studentFirstName TEXT, " +
                "$studentlastName TEXT, " +
                "$yearstarted INTEGER, " +
                "$course TEXT)"
        db?.execSQL(CREATESTUDENTSTABLE)

        val CREATECONTACTSTABLE =
            "CREATE TABLE $tableContacts " +
                    "($contactID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$studentcontactID TEXT, " +
                    "$contactType TEXT, " +
                    "$contactDetails TEXT)"
//                    " FOREIGN KEY ($studentcontactID) REFERENCES $tableStudents ($studentId))"
        db?.execSQL(CREATECONTACTSTABLE)

        db?.execSQL("Insert into $tableStudents ($studentlastName, $studentFirstName) values ('Valmores', 'Marco')")
        db?.execSQL("Insert into $tableStudents ($studentlastName, $studentFirstName) values ('Dave', 'Navor')")
        db?.execSQL("Insert into $tableStudents ($studentlastName, $studentFirstName) values ('Victor', 'Yu')")
        db?.execSQL("Insert into $tableStudents ($studentlastName, $studentFirstName) values ('JP', 'Soriano')")
        db?.execSQL("Insert into $tableStudents ($studentlastName, $studentFirstName) values ('CJ', 'Tronco')")
        db?.execSQL("Insert into $tableStudents ($studentlastName, $studentFirstName) values ('Rene', 'Marco')")
        db?.execSQL("Insert into $tableStudents ($studentlastName, $studentFirstName) values ('Joni', 'James')")
        db?.execSQL("Insert into $tableStudents ($studentlastName, $studentFirstName) values ('Janreign', 'Aragon')")
        db?.execSQL("Insert into $tableStudents ($studentlastName, $studentFirstName) values ('Patricia', 'Leones')")
        db?.execSQL("Insert into $tableStudents ($studentlastName, $studentFirstName) values ('Matthew', 'Mottos')")


        db?.execSQL("Insert into $tableContacts ($studentcontactID, $contactType, $contactDetails) values (1, 'FACEBOOK', 'Mac Valmores')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $tableStudents")
        onCreate(db)
    }
}




