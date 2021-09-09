package com.shao.fragmentexample.Fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.shao.fragmentexample.MainActivity
import com.shao.fragmentexample.R
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.fragment_home_page.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomePage.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomePage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mMainActivity:MainActivity

    private lateinit var mView:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mMainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home_page, container, false)

        // method 1:
//        mView.btn_Test.setOnClickListener { Log.d("Shao", "btn_test click") }
        // method 2:
//      mView.btn_Test.setOnClickListener( object :View.OnClickListener{
//                override fun onClick(v: View?) {
//                    Log.d("Shao", "btn_test click")
//                }
//            }
//        )
        // method 3:
//      mView.btn_Test.setOnClickListener(View.OnClickListener { view ->
//            Log.d("Shao", "btn_test click")
//        })
        // method 4:
      mView.btn_Test.setOnClickListener(listener)


        return mView
    }

    // method 4:
    val listener= View.OnClickListener { view ->
        when (view.getId()) {
            R.id.btn_Test -> {
                Log.d("Shao", "btn_test click")
                mMainActivity.mRecordPage.transmit(""+(Math.random()*49+1).toInt())
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomePage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}