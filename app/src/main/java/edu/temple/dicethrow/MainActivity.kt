package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), BlankFragment.ButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dieFragment = DieFragment.newInstance(100)

        supportFragmentManager.beginTransaction().add(R.id.dieContainer, dieFragment).commit()


    }

    override fun buttonClicked() {
        (supportFragmentManager.findFragmentById(R.id.dieContainer) as DieFragment).throwDie()
    }
}