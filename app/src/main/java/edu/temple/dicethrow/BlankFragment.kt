package edu.temple.dicethrow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class BlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_blank, container, false).apply {
            findViewById<Button>(R.id.button).setOnClickListener {
                (requireActivity() as ButtonInterface).buttonClicked()
            }
        }

    }

    interface ButtonInterface{
        fun buttonClicked()
    }


}