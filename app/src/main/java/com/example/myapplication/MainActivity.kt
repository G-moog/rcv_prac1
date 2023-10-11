package com.example.myapplication
import android.net.Uri
import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fooAdapter by lazy {
        FooAdapter {

        }
    }

    val projection = arrayOf(
        MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
        MediaStore.Images.Media._ID
    )
    private fun findAllDeviceImage() {
        val externalUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        contentResolver.query(
            externalUri,
            arrayOf(
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
                MediaStore.Images.Media._ID
            ),
            null,
            null,
            "${MediaStore.Video.VideoColumns.DATE_ADDED} DESC"
        )?.apply { // this : Cursor
            val folderNameColumn = getColumnIndexOrThrow(projection[0])
            val columnIndexID = getColumnIndexOrThrow(projection[1])

            while (moveToNext()) {
                // 폴더명
                val folderName = getString(folderNameColumn)
                // 이미지 Uri
                val imageUri = Uri.withAppendedPath(externalUri, "" + getLong(columnIndexID))
            }

            close()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        // lateinit
        // fooAdapter = FooAdapter {}
        binding.recyclerView.adapter = fooAdapter
        fooAdapter.addItems(Foo.createSamples(0))

        val list = listOf("킹냥이","댕댕이")

        binding.spinner.adapter = ArrayAdapter(
            this, // context
            android.R.layout.simple_spinner_item, // 기본
            list // items
        )

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


    }
}