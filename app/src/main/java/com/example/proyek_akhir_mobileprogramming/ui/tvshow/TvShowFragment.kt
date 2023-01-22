package com.example.proyek_akhir_mobileprogramming.ui.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyek_akhir_mobileprogramming.databinding.FragmentTvShowBinding
import com.example.proyek_akhir_mobileprogramming.ui.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel


class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private lateinit var binding: FragmentTvShowBinding

    private lateinit var adapter: TvShowAdapter

    private val viewModel: TvShowViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        if (_binding == null){
            _binding = FragmentTvShowBinding.inflate(inflater, container, false)
            binding = _binding as FragmentTvShowBinding
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TvShowAdapter().apply {
            onClick { data ->
                Intent(activity, DetailActivity::class.java).also { intent ->
                    intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.data[1])
                    intent.putExtra(DetailActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
            }
        }

        getTvShow()
    }

    private fun getTvShow() {

    }

    private fun showLoading(state: Boolean){
        binding.apply {
            if (state){
                progressBar.visibility = View.VISIBLE
                rvTvshow.visibility = View.GONE
            }else{
                progressBar.visibility = View.GONE
                rvTvshow.visibility = View.VISIBLE
            }
        }
    }

}