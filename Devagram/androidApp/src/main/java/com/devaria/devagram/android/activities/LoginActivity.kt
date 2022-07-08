package com.devaria.devagram.android.activities

import android.Manifest
import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.devaria.devagram.android.R

class LoginActivity : AppCompatActivity() {
    val REQUEST_CODE = 200
    lateinit var imageView: ImageView

    @TargetApi(Build.VERSION_CODES.M)
    private fun requestPermissions(){
        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

        if(permission != PackageManager.PERMISSION_GRANTED){
            this.requestPermissions(arrayOf(Manifest.permission.CAMERA), REQUEST_CODE)
        }
    }

    fun capturarImagem () {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            startActivityForResult(this, REQUEST_CODE)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        requestPermissions()
        var botao : Button = findViewById(R.id.capturar_imagem)
        imageView = findViewById(R.id.imageView)
        botao.setOnClickListener {
           capturarImagem()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE && data != null){
            imageView.setImageBitmap (data.extras?.get("data") as Bitmap)
        }
    }
}