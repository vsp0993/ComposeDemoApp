package com.composedemoapp.loginsignup

class FulNameState(fullName: String? = null) : TextFieldState(
    validator = ::isFullNameValid, errorFor = ::fulNameEmptyError
) {
    init {
        fullName?.let {
            text = it
        }
    }
}

private fun fulNameEmptyError(fullName: String): String {
    return "This filed can't be empty: $fullName"
}

private fun isFullNameValid(fullName: String): Boolean {
    return fullName.isNotEmpty()
}