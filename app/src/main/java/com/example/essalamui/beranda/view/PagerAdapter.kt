package com.example.essalamui.beranda.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fa:FragmentActivity): FragmentStateAdapter(fa){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SampleFragment.newInstance("One", "desc 1")
            1 -> SampleFragment.newInstance("Two", "desc 2")
            2 -> SampleFragment.newInstance("One", "desc 3")

//            0 -> SampleFragment.newInstance("@drawable/umroh1")
//            1 -> SampleFragment.newInstance("@drawable/umroh2")
//            2 -> SampleFragment.newInstance("@drawable/umroh3")
            else -> throw Exception("No such position")
        }
    }
}