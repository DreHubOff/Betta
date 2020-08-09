package com.studying.bettamovies.data

import android.net.Uri

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

fun validUri(init: String?):String{
    return if (init.isNullOrEmpty()){
        ""
    }else{
        init
    }
}