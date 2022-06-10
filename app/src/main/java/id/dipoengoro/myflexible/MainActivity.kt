package id.dipoengoro.myflexible

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragmentManager.findFragmentByTag(HomeFragment.SIMPLE_NAME)

        if (fragment !is HomeFragment) {
            Log.d(TAG, "Fragment Name: ${HomeFragment.SIMPLE_NAME}")
            fragmentManager.beginTransaction().add(R.id.frame_container, homeFragment, HomeFragment.SIMPLE_NAME)
                .commit()
        }
    }

    companion object {
        private const val TAG = "MyFlexible"
    }
}