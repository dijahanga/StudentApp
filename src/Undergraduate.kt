class Undergraduate(
    id: String,
    name: String,
    course: String,
    mark: Double
) : Student(id, name, course, mark) {

    override fun getGrade(): String {
        return when {
            mark >= 70 -> "Distinction"
            mark >= 60 -> "Merit"
            mark >= 40 -> "Pass"
            else -> "Fail"
        }
    }

    // Subclass version: reuses the superclass details and adds Undergraduate-specific info
    override fun toString(): String {
        return "[Undergraduate] " + super.toString() + " Grade: ${getGrade()} (pass mark 40)"
    }
}