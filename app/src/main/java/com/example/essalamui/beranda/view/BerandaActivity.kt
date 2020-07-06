package com.example.essalamui.beranda.view

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.essalamui.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import com.synnapps.carouselview.ViewListener


class BerandaActivity : AppCompatActivity() {

    var slideImages = intArrayOf(
        R.drawable.umroh1,
        R.drawable.umroh2,
        R.drawable.umroh3
    )
    val slideCards = intArrayOf(
        R.layout.slide1,
        R.layout.slide2,
        R.layout.slide3
    )


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        val carouselView = findViewById(R.id.carouselView) as CarouselView;
        carouselView.setPageCount(slideImages.size);
//        carouselView.setImageListener(imageListener);
        carouselView.setViewListener(viewListener);
//        setupViewPager2()
    }

    val imageListener : ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, ImageView: ImageView) {
            ImageView.setImageResource(slideImages[position])
        }
    }

    val viewListener = ViewListener { //set view attributes here
            layoutInflater.inflate(R.layout.card_promo, null)
        }
    /*
   private fun setupViewPager2(){
       val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2_promo_slider)
       val dotsIndicator = findViewById<WormDotsIndicator>(R.id.dots_indicator)

       viewPager2.adapter = PagerAdapter(this)
       dotsIndicator.setViewPager2(viewPager2)
   }

    */
}