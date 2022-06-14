package id.dipoengoro.myflexible

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class OptionFragment : DialogFragment() {

    private lateinit var buttonChoose: Button
    private lateinit var buttonClose: Button
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioOption1: RadioButton
    private lateinit var radioOption2: RadioButton
    private lateinit var radioOption3: RadioButton
    private lateinit var radioOption4: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_option, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonChoose = view.findViewById(R.id.button_choose)
        buttonClose = view.findViewById(R.id.button_close)
        radioGroup = view.findViewById(R.id.radio_group_option)
        radioOption1 = view.findViewById(R.id.radio_option_1)
        radioOption2 = view.findViewById(R.id.radio_option_2)
        radioOption3 = view.findViewById(R.id.radio_option_3)
        radioOption4 = view.findViewById(R.id.radio_option_4)

        buttonChoose.setOnClickListener {
            val checkedRadioButtonId = radioGroup.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                val coach: String? = when (checkedRadioButtonId) {
                    R.id.radio_option_1 -> radioOption1.text.toString().trim()
                    R.id.radio_option_2 -> radioOption2.text.toString().trim()
                    R.id.radio_option_3 -> radioOption3.text.toString().trim()
                    R.id.radio_option_4 -> radioOption4.text.toString().trim()
                    else -> null
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }
        buttonClose.setOnClickListener {
            dialog?.cancel()
        }
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(coach: String?)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        val fragment = parentFragment

        if (fragment is DetailFragment) {
            this.optionDialogListener = fragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }


    companion object {
        val TAG: String = OptionFragment::class.java.simpleName
    }
}