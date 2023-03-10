package ph.kodego.aragon.janreign.module_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        dao = StudentDAOSQLImpl(applicationContext)
        students = dao.getStudents()
//        init()

        studentAdapter = StudentAdapter(students)
        binding.list.layoutManager = LinearLayoutManager(applicationContext)
//        binding.list.layoutManager = GridLayoutManager(applicationContext, 2)
        binding.list.adapter = studentAdapter

        binding.addStudentButton.setOnClickListener{
            studentAdapter.addStudent(Student(
                    binding.studentFirstname.text.toString(),
                    binding.studentLastname.text.toString(),
                    R.drawable.placeholder))
        }

        var swipeCallback = SwipeCallback (0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        swipeCallback.studentAdapter = studentAdapter
        itemTouchHelper = ItemTouchHelper(swipeCallback)
        itemTouchHelper.attachToRecyclerView(binding.list)
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