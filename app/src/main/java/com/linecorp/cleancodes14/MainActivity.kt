package com.linecorp.cleancodes14

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.linecorp.cleancodes14.refactored2.Args
import com.linecorp.cleancodes14.refactored2.ArgsException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val schema = "l,p#,d*"
            val args = arrayOf("-p", "10", "-d", "Hi", "-l", "true")
            val arg = Args(schema, args)
            val logging = arg.getBoolean('l')
            val port = arg.getInt('p')
            val directory = arg.getString('d')

            Log.d("TAG", "onCreate: $logging $port $directory")
            // executeApplication(logging, port, directory);
        } catch (e: ArgsException) {
            try {
                System.out.printf("Argument error: %s\n", e.errorMessage())
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }
}
