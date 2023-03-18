package ph.kodego.aragon.janreign.module_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import ph.kodego.aragon.janreign.module_2.adapter.StudentAdapter
import ph.kodego.aragon.janreign.module_2.dao.StudentDAO
import ph.kodego.aragon.janreign.module_2.dao.StudentDAOSQLImpl
import ph.kodego.aragon.janreign.module_2.databinding.ActivityMainBinding
import ph.kodego.aragon.janreign.module_2.model.Student


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var studentAdapter: StudentAdapter
    private var students: ArrayList<Student> = ArrayList()
    private lateinit var itemTouchHelper: ItemTouchHelper
    private lateinit var dao:StudentDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            dao = StudentDAOSQLImpl(applicationContext) // OUTPUT when you run the app, the last line will be shown
            students = dao.getStudents()
            students = dao.getStudentsByLastNameAndFirstName("Marco","Valmores") //last line will be shown

//            var studentContacts = dao.getStudentsWithContacts()
//        init()

        studentAdapter = StudentAdapter(students, this)
        binding.list.layoutManager = LinearLayoutManager(applicationContext)
//        binding.list.layoutManager = GridLayoutManager(applicationContext, 2)
        binding.list.adapter = studentAdapter

        binding.addStudentButton.setOnClickListener{
            var student = Student()

            student.firstName = binding.studentFirstname.text.toString()
            student.lastName = binding.studentLastname.text.toString()

            dao.addStudent(student)
            students = dao.getStudents()
            studentAdapter.updateStudents(students)

//            binding.addStudentButton.setOnClickListener{
//            studentAdapter.addStudent(Student(
//                    binding.studentFirstname.text.toString(),
//                    binding.studentLastname.text.toString(),
//                    R.drawable.placeholder))
        }

        var swipeCallback = SwipeCallback (0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        swipeCallback.studentAdapter = studentAdapter
        itemTouchHelper = ItemTouchHelper(swipeCallback)
        itemTouchHelper.attachToRecyclerView(binding.list)

        //Search
        binding.searchStudentRecords.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
//                studentAdapter.filter.filter(newText)  // comment out Jan 26,2023
                students = dao.searchStudentByLastName(newText!!) // added Jan 26,2023
                studentAdapter.updateStudents(students)// added Jan 26,2023
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {

            studentAdapter.filter.filter(query)
             return false
           }
        })
    }

    fun init (){
        students.add(Student("Dave","Navor",R.drawable.placeholder))
        students.add(Student("Victor","Yu",R.drawable.placeholder))
        students.add(Student("JP","Soriano",R.drawable.placeholder))
        students.add(Student("CJ","Tronco",R.drawable.placeholder))
        students.add(Student("Rene","Palma",R.drawable.placeholder))
        students.add(Student("Joni","James",R.drawable.placeholder))
        students.add(Student("Janreign","Aragon",R.drawable.placeholder))
        students.add(Student("John Rey","Balais",R.drawable.placeholder))
        students.add(Student("James Nico","Rara",R.drawable.placeholder))
        students.add(Student("Pat Ivee","Lee",R.drawable.placeholder))
        students.add(Student("Rene","Palma",R.drawable.placeholder))
        students.add(Student("Matthew","Mottos",R.drawable.placeholder))
    }

}