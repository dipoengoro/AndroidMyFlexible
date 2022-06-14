package id.dipoengoro.myflexible

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class DetailFragment : Fragment() {

    private lateinit var textCategoryName: TextView
    private lateinit var textCategoryDescription: TextView
    private lateinit var buttonProfile: Button
    private lateinit var buttonShowDialog: Button

    var description: String? = null

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        val TAG: String = DetailFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textCategoryName = view.findViewById(R.id.text_category_name)
        textCategoryDescription = view.findViewById(R.id.text_category_description)
        buttonProfile = view.findViewById(R.id.button_profile)
        buttonShowDialog = view.findViewById(R.id.button_show_dialog)

        savedInstanceState?.getString(EXTRA_DESCRIPTION)?.also { description = it }
        textCategoryName.text = arguments?.getString(EXTRA_NAME)
        textCategoryDescription.text = description


        buttonShowDialog.setOnClickListener {
            val optionDialogFragment = OptionFragment()
            val fragmentManager = childFragmentManager
            optionDialogFragment.show(fragmentManager, OptionFragment.TAG)
        }

        buttonProfile.setOnClickListener {
            val intent = Intent(requireActivity(), ProfileActivity::class.java)
            startActivity(intent)
        }
    }


    internal var optionDialogListener: OptionFragment.OnOptionDialogListener = object : OptionFragment.OnOptionDialogListener {
        override fun onOptionChosen(coach: String?) {
            Toast.makeText(requireContext(), coach, Toast.LENGTH_SHORT).show()
        }
    }
}