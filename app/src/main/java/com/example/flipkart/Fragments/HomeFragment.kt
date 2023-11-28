package com.example.flipkart.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkart.Adapter.FirstRecAdapter
import com.example.flipkart.Adapter.SecondRecAdapter
import com.example.flipkart.Adapter.ThirdRecAdapter
import com.example.flipkart.ModelClass.FirstRecModel
import com.example.flipkart.ModelClass.SecondRecModel
import com.example.flipkart.ModelClass.ThirdModelClass
import com.example.flipkart.R
import com.example.flipkart.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arrFirstRec = ArrayList<FirstRecModel>()
        arrFirstRec.add(FirstRecModel(R.drawable.super_coin,"SuperCoin"))
        arrFirstRec.add(FirstRecModel(R.drawable.plus_member,"Plus"))
        arrFirstRec.add(FirstRecModel(R.drawable.personal_loan,"Personal Loan"))
        arrFirstRec.add(FirstRecModel(R.drawable.prepaid_recharge,"Prepaid Recharge"))
        arrFirstRec.add(FirstRecModel(R.drawable.spoyl,"Spoyl"))
        arrFirstRec.add(FirstRecModel(R.drawable.reward,"Gift Card"))
        arrFirstRec.add(FirstRecModel(R.drawable.brands,"NextGen Brands"))
        arrFirstRec.add(FirstRecModel(R.drawable.game_zone,"Game Zone"))
        arrFirstRec.add(FirstRecModel(R.drawable.emi,"EMI"))
        arrFirstRec.add(FirstRecModel(R.drawable.camera,"Camera"))

        binding.firstRecLayout.layoutManager =   LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        val recyclerAdapter = FirstRecAdapter(binding.root.context,arrFirstRec)

        binding.firstRecLayout.adapter = recyclerAdapter

        val arrSecondRec = ArrayList<SecondRecModel>()

        arrSecondRec.add(SecondRecModel(R.drawable.offer1,"Vistara Flights","From Rs1,299"))
        arrSecondRec.add(SecondRecModel(R.drawable.offer2,"Prepaid Recharge","Get 15% Off"))
        arrSecondRec.add(SecondRecModel(R.drawable.offer3,"Sonata Watches","Flat 15% Off"))

        binding.seconRecLayout.layoutManager =   LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        val recSecondAdapter = SecondRecAdapter(binding.root.context,arrSecondRec)
        binding.seconRecLayout.adapter = recSecondAdapter

        val arrThirdRec = ArrayList<ThirdModelClass>()

        arrThirdRec.add(ThirdModelClass(R.drawable.washing_machine,"Washing Machine","Special Offer"))
        arrThirdRec.add(ThirdModelClass(R.drawable.sweatshirt,"Men's Sweatshirts","Special Offer"))
        arrThirdRec.add(ThirdModelClass(R.drawable.tablet,"Tablets","Special Offer"))
        arrThirdRec.add(ThirdModelClass(R.drawable.mobile,"Mobile Phone","Special Offer"))

        binding.thirdRecView.layoutManager = GridLayoutManager(binding.root.context,2)

        val recThirdAdapter = ThirdRecAdapter(binding.root.context,arrThirdRec)
        binding.thirdRecView.adapter = recThirdAdapter



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}