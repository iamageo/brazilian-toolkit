package com.iamageo.brazilian_toolkit_library

import kotlin.math.abs

fun String.isCpf(charactersToIgnore: List<Char> = listOf('.', '-')): Boolean {
    val cleanCpf = this.filterNot { it in charactersToIgnore }
    if (cleanCpf.containsInvalidCPFChars() || cleanCpf.isInvalidCpfSize() || cleanCpf.isBlacklistedCpf()) return false
    return cleanCpf.hasValidVerificationDigits()
}

fun Long.isCpf(): Boolean {
    val absNumber = abs(this)
    return absNumber.toString().isCpf()
}

private fun String.containsInvalidCPFChars() = this.any { !it.isDigit() }
private fun String.isInvalidCpfSize() = this.length != 11
private fun String.isBlacklistedCpf() = this in blacklistedCpfs

private fun String.hasValidVerificationDigits(): Boolean {
    val firstNineDigits = substring(0..8)
    val digits = substring(9..10)

    return firstNineDigits.calculateDigits() == digits
}

private fun String.calculateDigits(): String {
    val numbers = map { it.toString().toInt() }
    val firstDigit = numbers.calculateFirstVerificationDigit()
    val secondDigit = numbers.calculateSecondVerificationDigit(firstDigit)

    return "$firstDigit$secondDigit"
}

private fun List<Int>.calculateFirstVerificationDigit(): Int {

    val firstNineDigits = this
    val weights = (10 downTo 2).toList()
    val sum = firstNineDigits.withIndex().sumOf { (index, element) -> weights[index] * element }

    val remainder = sum % 11
    return if (remainder < 2) 0 else 11 - remainder
}

private fun List<Int>.calculateSecondVerificationDigit(firstDigit: Int): Int {

    val firstTenDigits = this + firstDigit
    val weights = (11 downTo 2).toList()
    val sum = firstTenDigits.withIndex().sumOf { (index, element) -> weights[index] * element }

    val remainder = sum % 11
    return if (remainder < 2) 0 else 11 - remainder
}

private val blacklistedCpfs = listOf(
    "00000000000",
    "11111111111",
    "22222222222",
    "33333333333",
    "44444444444",
    "55555555555",
    "66666666666",
    "77777777777",
    "88888888888",
    "99999999999"
)
