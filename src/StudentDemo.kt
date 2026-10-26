
fun main() {

    // Create a mutable list to store all students entered by the user.
    // Its type is Student, so it can hold both Undergraduate and Masters objects.
    val students = mutableListOf<Student>()

    while (true) {

        // Display prompt and read the student's ID from console input
        print("Enter student ID (or quit to stop): ")
        val id = readln()

        // Stop the loop when the user types "quit"
        if (id == "quit") {
            break
        }

        // Display prompt and read the student's name from console input
        print("Enter student name: ")
        val name = readln()

        // Display prompt and read the course from console input
        print("Enter course: ")
        val course = readln()

        // Display prompt and read the mark from console input
        print("Enter mark: ")
        val mark = readln().toDouble()

        // Ask whether the student is Undergraduate or Masters
        print("Is the student Undergraduate or Masters? (U/M): ")
        val type = readln().trim().uppercase()

        // Create the appropriate object (Student is abstract, so it can't be created directly)
        val student: Student = when (type) {
            "U" -> Undergraduate(id, name, course, mark)
            "M" -> Masters(id, name, course, mark)
            else -> {
                println("Invalid type - student not added.")
                println()
                continue   // skip back to the start of the loop
            }
        }

        // Immediately add the new object to the list
        students.add(student)

        println("Student added.")
        println()
    }

    // Second loop: go through the list and print each student.
    // println(student) automatically calls toString().
    println("All students entered:")
    for (student in students) {
        println(student)
    }

    // After the loop ends, display "Program finished"
    println("Program finished.")
}