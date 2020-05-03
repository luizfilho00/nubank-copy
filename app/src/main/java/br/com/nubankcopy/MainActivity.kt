package br.com.nubankcopy

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.databinding.DataBindingUtil
import br.com.nubankcopy.databinding.ActivityMainBinding

class MainActivity : TransparentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragment = ProfileInfoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupSideBar()
        setupRecyclerView()
        setupFragment()
    }

    private fun setupSideBar() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenHeight = displayMetrics.heightPixels
        setupRewardsInfo(screenHeight)
        setupCreditCardInfo(screenHeight)
        setupAccountInfo(screenHeight)
    }

    private fun setupRewardsInfo(screenHeight: Int) {
        binding.view.includedRewardsInfo.rootLayout.layoutParams.height = screenHeight * 40 / 100
    }

    private fun setupCreditCardInfo(screenHeight: Int) {
        with(binding.view.includedCreditCardInfo) {
            viewCosts.layoutParams.height = screenHeight * 5 / 100
            viewCurrent.layoutParams.height = screenHeight * 10 / 100
            viewLimit.layoutParams.height = screenHeight * 20 / 100
        }
    }

    private fun setupAccountInfo(screenHeight: Int) {
        with(binding.view.includedAccountInfo) {
            rootLayout.layoutParams.height = screenHeight * 40 / 100
            var toggleOn = false
            imageViewToggle.setOnClickListener {
                toggleOn = if (toggleOn) {
                    imageViewToggle.setImageDrawable(getDrawable(R.drawable.ic_hide))
                    ObjectAnimator.ofFloat(viewToggle, "alpha", 1f).apply {
                        duration = 200
                        start()
                    }
                    false
                } else {
                    imageViewToggle.setImageDrawable(getDrawable(R.drawable.ic_eye))
                    ObjectAnimator.ofFloat(viewToggle, "alpha", 0f).apply {
                        duration = 200
                        start()
                    }
                    true
                }
            }
        }
    }

    private fun setupRecyclerView() {
        with(binding.recyclerView) {
            addItemDecoration(
                MarginItemDecoration(
                    resources.getDimension(R.dimen.default_padding).toInt()
                )
            )
            adapter = MenuAdapter().apply {
                submitList(MenuItem.getMenu())
            }
        }
    }

    private fun setupFragment() {
        supportFragmentManager.beginTransaction()
            .replace(binding.frameLayout.id, fragment)
            .commit()
    }
}
