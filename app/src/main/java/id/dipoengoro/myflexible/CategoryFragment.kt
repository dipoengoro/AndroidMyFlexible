package id.dipoengoro.myflexible

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CategoryFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonDetailCategory: Button = view.findViewById(R.id.button_detail_category)
        buttonDetailCategory.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.button_detail_category) {
            val detailFragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString(DetailFragment.EXTRA_NAME, "Lifestyle")
            val description = "Kategori ini akan berisi produk-produk lifestyle"
            detailFragment.arguments = bundle
            detailFragment.description = description

            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, detailFragment, DetailFragment.TAG)
                addToBackStack(null)
                commit()
            }
        }
    }

    companion object {
        val TAG: String = CategoryFragment::class.java.simpleName
    }
}