package com.example.vikaslandge.list_view_custom

import android.Manifest
import android.content.pm.PackageManager
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.zip.Inflater

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var status = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (status == PackageManager.PERMISSION_GRANTED) {

            readfiles()
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),11)

        }
    }

    fun readfiles(){
        var path = "/storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
        var file = File(path)
        if (!file.exists()){
            path = "/storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
            file = File(path)
        }

        if(file.exists()) {

            var files = file.listFiles()

            /* var arrAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice,files)
        lsview.adapter =arrAdapter*/

            lsview.adapter = MyAdapter(files, this)
        }else {
            Toast.makeText(this, "Path not exists", Toast.LENGTH_LONG).show()
        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0]==PackageManager.PERMISSION_GRANTED) {

            readfiles()

        }else {

            Toast.makeText(this,
                    "U can't continue with App",
                    Toast.LENGTH_LONG).show()

        }
    }
}
