import generator.PasswordGenerator

fun main() {

    println("Welcome to my awesome Password Generator!")

    print("Enter max password length: ")
    val lengthInput = readlnOrNull() ?: "255"
    val maxLength = lengthInput.toIntOrNull() ?: 255

    print("Include uppercase letters? (y/n): ")
    val includeUppercase = readlnOrNull()?.equals("y", ignoreCase = true) ?: false

    print("Include lowercase letters? (y/n): ")
    val includeLowercase = readlnOrNull()?.equals("y", ignoreCase = true) ?: false

    print("Include numbers? (y/n): ")
    val includeNumbers = readlnOrNull()?.equals("y", ignoreCase = true) ?: false

    print("Include special characters? (y/n): ")
    val includeSpecial = readlnOrNull()?.equals("y", ignoreCase = true) ?: false

    try {
        val passwordGenerator = PasswordGenerator(
            maxLength = maxLength.toShort(),
            includeUppercase = includeUppercase,
            includeLowercase = includeLowercase,
            includeNumbers = includeNumbers,
            includeSpecial = includeSpecial
        )

        val password = passwordGenerator.generatePassword()
        println("Generated Password: $password")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}