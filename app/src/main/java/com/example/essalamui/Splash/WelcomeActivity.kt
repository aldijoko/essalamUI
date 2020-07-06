package com.example.essalamui.Splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.essalamui.R
import com.example.essalamui.beranda.view.BerandaActivity
import java.text.FieldPosition

class WelcomeActivity : AppCompatActivity() {

    lateinit var mPager : ViewPager

    var layouts: IntArray = intArrayOf(R.layout.intro_screen1,R.layout.intro_screen2,R.layout.intro_screen3)

    lateinit var dotsLayout: LinearLayout

    lateinit var dots: Array<ImageView>

    lateinit var mAdapter: MyViewPagerAdapter

    private lateinit var prefManager: ApplicationPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        init()
        setAdapter()
    }

    private fun init(){
        prefManager = ApplicationPrefs()
        if (prefManager.isNotFirstTime()) {
            openMainScreen()
        }
        mPager = findViewById(R.id.view_pager) as ViewPager
        dotsLayout = findViewById(R.id.layoutDots) as LinearLayout
        addBottomdots(0)
    }

    private var viewPagerPageChangeListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageSelected(position: Int){
            addBottomdots(position)
        }

        override fun onPageScrollStateChanged(state: Int) {
            TODO("Not yet implemented")
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            TODO("Not yet implemented")
        }
    }

    fun addBottomdots(position: Int){

        if(dotsLayout!=null){
            dotsLayout.removeAllViews()
        }
        dots = Array(layouts.size, {i-> ImageView(this)})
        for (i in 0..layouts.size-1){
            dots[i] = ImageView(this)
            if(i == position){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots))
            }
            else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive_dots))
            }

            var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)

            params.setMargins(4,0,4,0)
            dotsLayout.addView(dots[i],params)
        }
    }

    private fun setAdapter(){
        mAdapter = MyViewPagerAdapter(layouts, this)
        mPager!!.adapter = mAdapter
//        mPager!!.addOnPageChangeListener(viewPagerPageChangeListener)



    }

//    private fun dotselect(){
//        mPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
//            override fun onPageScrollStateChanged(state: Int) {
//
//            }
//
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onPageSelected(position: Int) {
//                addBottomdots(position)
//            }
//        })
//    }

    private fun openMainScreen() {
        val intent = Intent(this, BerandaActivity::class.java)
        startActivity(intent)
        finish()
    }





//    inner class MyViewPagerAdapter : PagerAdapter {
//        lateinit var  layouts: IntArray
//
//        lateinit var inflater: LayoutInflater
//
//        lateinit var con: Context
//
//        constructor(layouts: IntArray, con: Context) : super() {
//            this.layouts = layouts
//            this.con = con
//            inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        }
//
//
//        override fun isViewFromObject(view: View, `object`: Any): Boolean {
//
//            return view == `object`
//
//        }
//
//        override fun getCount(): Int {
//
//            return layouts.size
//        }
//
//        override fun instantiateItem(container: ViewGroup, position: Int): Any {
//            var view: View = inflater.inflate(layouts[position],container,false)
//            container!!.addView(view)
//            return view
//        }
//
//        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//            var view: View = `object` as View
//            container.removeView(view)
//        }
//
//
//    }


}