abstract class Student(
    val id: String,
    val name: String,
    val course: String,
    val mark: Double
) {

    abstract fun getGrade(): String

    // Superclass version: common details shared by all students
    override fun toString(): String {
        return "ID: $id Name: $name Course: $course Mark: $mark"
    }
}