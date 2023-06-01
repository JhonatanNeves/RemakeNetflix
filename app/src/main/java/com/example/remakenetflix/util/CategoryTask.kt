package com.example.remakenetflix.util


import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class CategoryTask {

    fun execute(url: String) {
        val executor = Executors.newSingleThreadExecutor()

        executor.execute {
            try {
                val requestURL = URL(url)
                val urlConnection = requestURL.openConnection() as HttpsURLConnection
                urlConnection.readTimeout = 2000
                urlConnection.connectTimeout = 2000

                val statusCode: Int = urlConnection.responseCode
                if (statusCode > 400) {
                    throw IOException("Erro na comunicação com o servidor!")
                }

                val stream = urlConnection.inputStream
                val buffer = BufferedInputStream(stream)
                val jsonAsString = toString(buffer)

                // val jsonAsString = stream.bufferedReader().use { it.readText() }

            } catch (e: IOException) {

            }
        }
    }

    private fun toString(stream: InputStream) : String {
        val bytes = ByteArray(1024)
        val baos = ByteArrayOutputStream()
        var read: Int
        while (true) {
            read = stream.read(bytes)
            if (read <= 0) {
                break
            }
            baos.write(bytes, 0 , read)

        }
        return String(baos.toByteArray())
    }

}