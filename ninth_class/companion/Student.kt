class Student (
    val id: String,
    val name: String,
    val year: Int
) {

    constructor(
        _name: String,
        _year: Int,
        _id: String  = Student.generateStudentId()
    ): this(_id, _name, _year)

    companion object {
        
        private var totalStudents: Int = 0
        fun getTotalCounts(): Int = totalStudents
        private fun generateStudentId(): String = "STU-%03d".format(++totalStudents)   
    }

    fun getInfo(): String = "Студент $name (ID: $id), $year курс"
}