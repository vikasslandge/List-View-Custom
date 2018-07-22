package com.example.vikaslandge.list_view_custom

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.vikaslandge.list_view_custom.R.layout.*
import kotlinx.android.synthetic.main.indiview.view.*
import java.io.File
import java.nio.file.Files

class MyAdapter : BaseAdapter{

    var files :Array<File>? = null
    var activity : MainActivity? = null

    constructor(files: Array<File>,activity: MainActivity){
        this.files = files
        this.activity = activity

    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
     var inflater = LayoutInflater.from(activity)
        var v = inflater.inflate(indiview,null)

        var  file = files!![position]
       //v.iv1.setImageURI(Uri.fromFile(file))

        var b = BitmapFactory.decodeFile(file.path)
        var bmp = ThumbnailUtils.extractThumbnail(b,50,50)
        v.iv1.setImageBitmap(bmp)
        v.tv1.text = file.name
        v.tv2.text = file.length().toString()
        v.b1.setOnClickListener {

            file.delete()
            activity!!.readfiles()
        }
        return v
     }

    override fun getCount(): Int {

        return files!!.size
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(position: Int): Any {
        return 0
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        return 0
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}