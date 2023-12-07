package com.example.flipkart.Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkart.Adapter.PostsAdapter
import com.example.flipkart.ModelClass.PostsModel
import com.example.flipkart.R
import com.example.flipkart.Repository.PostsRepository
import com.example.flipkart.Retrofit.ApiInterface
import com.example.flipkart.Retrofit.RetrofitInstance
import com.example.flipkart.ViewModel.PostsViewModel
import com.example.flipkart.ViewModel.PostsViewModelFactory
import com.example.flipkart.databinding.FragmentAccountBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {
    private lateinit var binding: FragmentAccountBinding
    private lateinit var postsViewModel: PostsViewModel
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater, container, false)

        // Then set the layout manager
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())

        // Set up the ViewModel and observe data
        val apiInterface = RetrofitInstance.getInstance().create(ApiInterface::class.java)
        val repository = PostsRepository(apiInterface)

        postsViewModel = ViewModelProvider(this, PostsViewModelFactory(repository)).get(PostsViewModel::class.java)



        postsViewModel.posts.observe(viewLifecycleOwner, Observer { posts ->
            Log.e("posts", "${posts}")

            // Check if posts is not null and contains data
            if (posts != null && posts.isNotEmpty()) {
                val adapter = PostsAdapter(requireContext(), posts)
                binding.rcView.adapter = adapter
            } else {
                Log.e("posts", "Posts list is empty or null")
            }
        })



        setButton()
        binding.customView.setOnClickListener {
            binding.customView.setBackgroundResource(R.drawable.empty_button_stroke)
            binding.customView.showLoader()

            Handler(Looper.getMainLooper()).postDelayed({
                binding.customView.setText("Success")
                binding.customView.hideLoader()
                binding.customView.setBackgroundResource(R.drawable.bt_enable_bg)
            }, 3000)


        }
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setButton() {
        binding.customView.isEnabled = true
        binding.customView.setText("Continue")
        binding.customView.setBackgroundResource(R.drawable.empty_button_stroke)
        binding.customView.hideLoader()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}