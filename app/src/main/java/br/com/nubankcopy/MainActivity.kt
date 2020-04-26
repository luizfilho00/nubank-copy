package br.com.nubankcopy

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.res.ResourcesCompat
import br.com.nubankcopy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragment = ProfileInfoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setWindowTransparent()
        setupRecyclerView()
        setupFragment()
        setupUi()
    }

    private fun setWindowTransparent() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        window.navigationBarColor =
            ResourcesCompat.getColor(resources, android.R.color.transparent, theme)
    }

    private fun setupRecyclerView() {
        with(binding.recyclerView) {
            addItemDecoration(
                MarginItemDecoration(resources.getDimension(R.dimen.default_padding).toInt())
            )
            adapter = MenuAdapter().apply {
                submitList(listOf("a", "b", "c", "d", "e", "f", "g"))
            }
        }
    }

    private fun setupFragment() {
        supportFragmentManager.beginTransaction()
            .replace(binding.frameLayout.id, fragment)
            .commit()
    }

    private fun setupUi() {
        binding.motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                fragment.toggleButton()
            }
        })
//        binding.
    }
}
