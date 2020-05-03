package br.com.nubankcopy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.nubankcopy.databinding.ActivitySplashBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
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
        Observable.just(Unit)
            .delay(500, TimeUnit.MILLISECONDS)
            .flatMap { playAnimation() }
            .delay(1500, TimeUnit.MILLISECONDS)
            .flatMap { goToMain() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {  }
            .let(disposables::add)
    }

    private fun playAnimation(): Observable<Unit> {
        return Observable.just(binding.rootLayout.transitionToEnd())
    }

    private fun goToMain(): Observable<Unit> {
        return Observable.fromCallable {
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}