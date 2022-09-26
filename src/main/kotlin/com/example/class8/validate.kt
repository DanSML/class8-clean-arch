package com.example.class8

const val DIGIT_1_FACTOR = 10
const val DIGIT_2_FACTOR = 11
fun clearMask(cpf: String): String {
    val pattern = "\\D+".toRegex()
    return cpf.replace(pattern, "")
}

fun calculateDigit(cpf: String, factor: Int): Int {
    var total = 0
    var newFactor = factor
    for (value in cpf) {
        if (newFactor > 1) {
            total += Integer.parseInt(value.toString()) * newFactor--
        }
    }
    val rest = total%11
    return if (rest < 2) 0 else 11 - rest
}

fun hasValidLength(cpf: String): Boolean {
    return cpf.length == 11
}

fun hasAllDigitsEquals(cpf: String): Boolean {
    val firstDigit = cpf[0].toString()
    return cpf.split("").all{ it == firstDigit }
}

fun extractCheckDigit(cpf: String): String {
    return cpf.slice(cpf.length-2 until cpf.length)
}

fun validate (cpf: String): Boolean {
    if (cpf == "") return false
    val newStr = clearMask(cpf)
    if (!hasValidLength(newStr)) return false
    if (hasAllDigitsEquals(newStr)) return false
    val digit1 = calculateDigit(newStr, DIGIT_1_FACTOR)
    val digit2 = calculateDigit(newStr, DIGIT_2_FACTOR)
    val checkDigit = extractCheckDigit(newStr)
    val calculatedCheckDigit = "$digit1$digit2"
    return checkDigit == calculatedCheckDigit
}