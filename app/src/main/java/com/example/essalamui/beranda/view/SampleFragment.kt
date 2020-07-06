package com.example.essalamui.beranda.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.essalamui.R

class SampleFragment : Fragment() {

    private var header: String? = null
    private var desc: String? = null
//    private var content: String? = null
    private var ARG_Header: String? = null
    private var ARG_Desc: String? = null
//    private var ARG_Content: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            header = it.getString(ARG_Header)
            desc = it.getString(ARG_Desc)
//            content = it.getString(ARG_Content)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sample, container, false)
        setView(view)
        return view
    }

    private fun setView(view:View){
        val headerText = view.findViewById<TextView>(R.id.txt_header)
        headerText.text = header
        val descText = view.findViewById<TextView>(R.id.txt_desc)
        descText.text = desc

//        val promoContent = view.findViewById<ImageView>(R.id.promo_content)
//        promoContent.setImageResource(getImageId(this, content))
    }

    private fun getImageId(context: Context, imageName: String): Int {
        return context.getResources()
            .getIdentifier("drawable/$imageName", null, context.getPackageName())
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SampleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_Header, param1)
                    putString(ARG_Desc, param2)
//                    putString(ARG_Content, param1)
                }
            }
    }
}