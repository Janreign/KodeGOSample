package ph.kodego.aragon.janreign.module_2.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException
import ph.kodego.aragon.janreign.module_2.model.Student

interface StudentDAO {
         fun addStudent(student: Student)
         fun getStudents() : ArrayList<Student>
}

class StudentDAOSQLImpl(var context: Context): StudentDAO{

    override fun addStudent(student: Student) {
        var databaseHandler:DatabaseHandler = DatabaseHandler(context) //declared to access database
        var db = databaseHandler.writableDatabase //actual access in database

        val contentValues = ContentValues() //to put on database table
        contentValues.put(DatabaseHandler.studentFirstName, student.firstName)
        contentValues.put(DatabaseHandler.studentlastName, student.lastName)
// to call database
        val success = db.insert(DatabaseHandler.tableStudents, null, contentValues) // actual insert to database
        db.close()
    }//ensure to close

    override fun getStudents(): ArrayList<Student> {
        val studentList: ArrayList<Student> = ArrayList()  //declared the data to be returned

        val selectQuery = "SELECT ${DatabaseHandler.studentlastName}, " +
                 "${DatabaseHandler.studentFirstName}, " +
                 "${DatabaseHandler.studentId} " +
                 "FROM ${DatabaseHandler.tableStudents}"

        var databaseHandler:DatabaseHandler = DatabaseHandler(context)
        var db = databaseHandler.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery, null)  //to retreive data
        }catch (e: SQLiteException) {
            db.close()
            return ArrayList()
        }

        var student = Student()
        if (cursor.moveToFirst()){
            do {
                student = Student()
                student.id = cursor.getInt(2)
                student.lastName = cursor.getString(0)
                student.firstName = cursor.getString(1)

                studentList.add(student)
            }while(cursor.moveToNext())
    }
    db.close()
    return studentList
}
}