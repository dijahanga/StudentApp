class University {

    // Private list: only University can change it directly (aggregation + encapsulation)
    private val students = mutableListOf<Student>()

    // Adds a student to the university's list
    fun enrolStudent(student: Student) {
        students.add(student)
    }

    // Returns the student with the matching ID, or null if not found
    fun findStudentById(id: String): Student? {
        for (student in students) {
            if (student.id == id) {
                return student
            }
        }
        return null
    }

    // Returns all students whose name matches (ignoring upper/lower case)
    fun findStudentsByName(name: String): MutableList<Student> {
        val results = mutableListOf<Student>()
        for (student in students) {
            if (student.name.equals(name, ignoreCase = true)) {
                results.add(student)
            }
        }
        return results
    }
}