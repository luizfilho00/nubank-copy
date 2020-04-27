package br.com.nubankcopy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.nubankcopy.databinding.ActivitySplashBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        setupUi()
    }

    private fun setupUi() {
        Observable.just(true)
            .delay(500, TimeUnit.MILLISECONDS)
            .subscribe {
                binding.rootLayout.transitionToEnd()
            }
            .let(disposables::add)
        Observable.just(true)
            .delay(1700, TimeUnit.MILLISECONDS)
            .subscribe {
                finish()
                startActivity(Intent(this, MainActivity::class.java))
            }
            .let(disposables::add)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}