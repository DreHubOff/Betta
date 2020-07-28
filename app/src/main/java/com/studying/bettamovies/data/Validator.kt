package com.studying.bettamovies.data

fun validateInputData(inData: Any?): String {
    val retStr = inData.toString()
    if (retStr.isNullOrEmpty() || retStr == "0") {
        return "no information"
    }
    return retStr
}

fun validateInputData(inData: Any?, addStr: String): String {
    val retStr = inData.toString()
    if (retStr.isNullOrEmpty() || retStr == "0") {
        return "no information"
    }
    return "$retStr $addStr"
}