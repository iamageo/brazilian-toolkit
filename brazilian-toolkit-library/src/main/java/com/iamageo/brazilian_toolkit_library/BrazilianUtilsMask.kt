package com.iamageo.brazilian_toolkit_library

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

object BrazilianUtilsMask {

    fun cpfAndCnpjMask(ediTxt: EditText): TextWatcher {
        var isUpdating: Boolean = false
        var mask = ""
        var old_str = ""
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val str = unmask(s.toString())
                var mascara = ""

                mask = when (str.length) {
                    in 0..11 -> "###.###.###-##"
                    else -> "##.###.###/####-##"
                }
                if (isUpdating) {
                    old_str = str
                    isUpdating = false
                    return
                }
                var i = 0
                for (m in mask.toCharArray()) {
                    if (m != '#' && str.length > old_str.length) {
                        mascara += m
                        continue
                    }
                    try {
                        mascara += str[i]
                    } catch (e: Exception) {
                        break
                    }
                    i++
                }
                isUpdating = true
                ediTxt.setText(mascara)
                ediTxt.setSelection(mascara.length)
            }
        }
    }

    fun unmask(s: String): String {
        return s.replace("-", "").replace("/", "").replace(".", "")
    }

}