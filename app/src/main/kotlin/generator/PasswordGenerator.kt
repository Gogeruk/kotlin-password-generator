package generator

class PasswordGenerator(
    private val maxLength: Short = 255,
    private val includeUppercase: Boolean = true,
    private val includeLowercase: Boolean = false,
    private val includeNumbers: Boolean = false,
    private val includeSpecial: Boolean = false
) {
    fun generatePassword(): String {
        val uppercaseChars = ('A'..'Z').toList()
        val lowercaseChars = ('a'..'z').toList()
        val numberChars = ('0'..'9').toList()
        val specialChars = listOf('!', '@', '#', '$', '%', '^', '&', '*')

        val charPool = mutableListOf<Char>()

        if (includeUppercase) charPool.addAll(uppercaseChars)
        if (includeLowercase) charPool.addAll(lowercaseChars)
        if (includeNumbers) charPool.addAll(numberChars)
        if (includeSpecial) charPool.addAll(specialChars)

        if (charPool.isEmpty()) {
            throw IllegalArgumentException("At least one character type must be selected!")
        }

        val range = 1..maxLength
        val randomChars = range.map { charPool.random() }
        return randomChars.joinToString("")
    }
}