package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

const val DIESIDE = "sidenumber"
const val DIEROLL = "prev_roll"

class DieFragment : Fragment() {

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    var rollValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.run{
            rollValue = getInt(DIEROLL)
        }

        if(rollValue < 0){
            throwDie()
        }else{
            dieTextView.text = rollValue.toString()
        }

        view.setOnClickListener{
            throwDie()
        }
    }

    fun throwDie() {
        dieTextView.text = (Random.nextInt(dieSides) + 1).toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(sides: Int) : DieFragment {
            val fragment = DieFragment()
            val bundle = Bundle()
            bundle.putInt(DIESIDE, sides)
            fragment.arguments = bundle
            return fragment
        }

    }

}