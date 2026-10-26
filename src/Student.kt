
abstract class Student(
    val id: String,
    val name: String,
    val course: String,
    val mark: Double
) {

    // Abstract function: no body here, every subclass MUST provide its own version
    abstract fun studentType(): String

    abstract fun getGrade(): String

    override fun toString(): String {
        return "${studentType()} - Name: $name Course: $course Mark: $mark Grade: ${getGrade()}"
    }
}

class Undergraduate(
    id: String,
    name: String,
    course: String,
    mark: Double
) : Student(id, name, course, mark) {

    override fun studentType(): String {
        return "Undergraduate"
    }

    override fun getGrade(): String {
        return when {
            mark >=70 -> "Distinction"
            mark >=60 -> "Merit"
            mark >=40 -> "Pass"
            else -> "Fail"
        }
    }
}

class Masters(
    id: String,
    name: String,
    course: String,
    mark: Double
) : Student(id, name, course, mark) {

    override fun studentType(): String {
        return "Masters"
    }

    override fun getGrade(): String {
        return when {
            mark >=70 -> "First"
            mark >=60 -> "2/1"
            mark >=50 -> "2/2"
            mark >=40 -> "Third"
            else -> "Fail"
        }
    }
}
