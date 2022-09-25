package com.example.class8

fun validate (str: String): Boolean {

    if (str == null) return false
    if (str.length >= 11 || str.length <= 14) {
        var newStr = str
                        .replace(".", "")
                        .replace(".", "")
                        .replace("-", "")
                        .replace(" ", "")


        if(!newStr.split("").all{ it == newStr[0].toString() }) {
            try {
                var d1: Int = 0
                var d2: Int = 0
                var dg1: Int = 0
                var dg2: Int = 0
                var rest: Int = 0
                var digit: Any
                var nDigResult: Any

                var index = 1
                while (index < newStr.length-1) {
                    digit = Integer.parseInt(newStr.substring(index-1, index))
                    d1 += (11 - index) * digit
                    d2 += (12 - index) * digit
                    index++
                }

                rest = (d1%11)

                dg1 = if (rest < 2) 0 else 11 - rest
                d2 += 2 * dg1
                rest = (d2%11)

                if (rest < 2) {
                    dg2 = 0
                } else {
                    dg2 = 11 - rest
                }

                var nDigVerific = newStr.substring(newStr.length-2, newStr.length)
                nDigResult = "" + dg1 + "" + dg2
                return nDigVerific == nDigResult
            } catch (error: Exception) {
                println(error)
                return false
            }
        }   else return false
    } else return false
    return false
}