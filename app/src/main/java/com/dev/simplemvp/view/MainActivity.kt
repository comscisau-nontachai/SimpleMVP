package com.dev.simplemvp.view

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import com.dev.simplemvp.R
import com.dev.simplemvp.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    lateinit var mainActivityPresenter: MainActivityPresenter
    lateinit var progressBar: ProgressBar

    override fun updateUseInfoTextView(info: String) {
        txt_show.text = info
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hindProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityPresenter = MainActivityPresenter(this)

        initProgressbar()

        //handle event
        edt_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                hindProgressBar()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mainActivityPresenter.updateFullName(p0.toString())
            }
        })

        edt_email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                hindProgressBar()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mainActivityPresenter.updateEmail(p0.toString())
            }
        })
    }

    private fun initProgressbar() {

        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleSmall)
        progressBar.isIndeterminate = true

        val params = RelativeLayout.LayoutParams(resources.displayMetrics.widthPixels, 250)
        params.addRule(RelativeLayout.CENTER_IN_PARENT)

        this.addContentView(progressBar, params)
        showProgressBar()

    }
}
