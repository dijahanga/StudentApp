fun main() {

    // One University object that stores and manages all students
    val university = University()

    // String variable to store the user's menu choice
    var choice = ""

    while (choice != "4") {

        println("===== Student Menu =====")
        println("1. Add a student")
        println("2. Search for student by ID")
        println("3. Search for students by name")
        println("4. Quit")
        print("Enter your choice: ")
        choice = readln().trim()

        when (choice) {

            // Step 4 - Option 1: Add a student (polymorphism)
            "1" -> {
                // 1) Ask what type of student to add
                print("Enter u for Undergraduate or m for Masters: ")
                val type = readln().trim().lowercase()

                if (type != "u" && type != "m") {
                    println("Invalid type - student not added.")
                } else {
                    // 2) Read the common student information
                    print("Enter student ID: ")
                    val id = readln()

                    print("Enter student name: ")
                    val name = readln()

                    print("Enter course: ")
                    val course = readln()

                    print("Enter mark: ")
                    val mark = readln().toDouble()

                    // 3) Create the correct object, stored in a variable of type Student
                    val theStudent: Student = if (type == "u") {
                        Undergraduate(id, name, course, mark)
                    } else {
                        Masters(id, name, course, mark)
                    }

                    // 4) Add the student to the university
                    university.enrolStudent(theStudent)
                    println("Student added.")
                }
            }

            // Step 5 - Option 2: Search by ID
            "2" -> {
                print("Enter student ID: ")
                val id = readln()

                val foundStudent = university.findStudentById(id)

                if (foundStudent != null) {
                    println(foundStudent)
                } else {
                    println("Student not found.")
                }
            }

            // Step 6 - Option 3: Search by name
            "3" -> {
                print("Enter student name: ")
                val name = readln()

                val results = university.findStudentsByName(name)

                if (results.isEmpty()) {
                    println("No students found.")
                } else {
                    for (foundStudent in results) {
                        println(foundStudent)
                    }
                }
            }

            "4" -> println("Program finished.")

            else -> println("Invalid choice, please enter 1-4.")
        }

        println()
    }
}