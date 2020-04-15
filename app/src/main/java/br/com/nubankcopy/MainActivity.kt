package br.com.nubankcopy

import android.graphics.Point
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.nubankcopy.databinding.ActivityMainBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupDragAndDrop()
    }

    private fun setupDragAndDrop() {
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
    }

    override fun onStop() {
        Toast.makeText(this, "disposabes clear!", Toast.LENGTH_SHORT).show()
        super.onStop()
        disposables.clear()
    }

    override fun onDestroy() {
        Toast.makeText(this, "disposabes dispose!", Toast.LENGTH_SHORT).show()
        super.onDestroy()
        disposables.dispose()
    }
}
