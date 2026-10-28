class Masters(
    id: String,
    name: String,
    course: String,
    mark: Double
) : Student(id, name, course, mark) {

    override fun getGrade(): String {
        return when {
            mark >= 70 -> "Distinction"
            mark >= 60 -> "Merit"
            mark >= 50 -> "Pass"
            else -> "Fail"
        }
    }

    // Subclass version: reuses the superclass details and adds Masters-specific info
    override fun toString(): String {
        return "[Masters] " + super.toString() + " Grade: ${getGrade()} (pass mark 50)"
    }
}