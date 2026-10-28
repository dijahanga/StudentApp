fun main() {

    // Step 4 - One University object that stores and manages all students
    val university = University()

    // Step 6 - String variable to store the user's menu choice
    var choice = ""

    // Keep running until the user enters "4"
    while (choice != "4") {

        // Step 5 - Display the menu
        println("===== Student Menu =====")
        println("1. Add a student")
        println("2. Search for student by ID")
        println("3. Search for students by name")
        println("4. Quit")
        print("Enter your choice: ")
        choice = readln().trim()

        // Step 7 - Handle the menu options
        when (choice) {

            "1" -> {
                // Read student details
                print("Enter student ID: ")
                val id = readln()

                print("Enter student name: ")
                val name = readln()

                print("Enter course: ")
                val course = readln()

                print("Enter mark: ")
                val mark = readln().toDouble()

                print("Is the student Undergraduate or Masters? (U/M): ")
                val type = readln().trim().uppercase()

                // Create the Student object (Student is abstract, so Undergraduate or Masters)
                val student: Student? = when (type) {
                    "U" -> Undergraduate(id, name, course, mark)
                    "M" -> Masters(id, name, course, mark)
                    else -> null
                }

                if (student == null) {
                    println("Invalid type - student not added.")
                } else {
                    university.enrolStudent(student)
                    println("Student enrolled.")
                }
            }

            "2" -> {
                print("Enter student ID to search: ")
                val id = readln()

                val found = university.findStudentById(id)

                if (found == null) {
                    println("No student found with ID $id.")
                } else {
                    println(found)
                }
            }

            "3" -> {
                print("Enter student name to search: ")
                val name = readln()

                val results = university.findStudentsByName(name)

                if (results.isEmpty()) {
                    println("No students found with the name $name.")
                } else {
                    for (student in results) {
                        println(student)
                    }
                }
            }

            "4" -> println("Program finished.")

            else -> println("Invalid choice, please enter 1-4.")
        }

        println()
    }
}