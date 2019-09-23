package com.deep.app.jetpacknavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.deep.app.jetpacknavigation.Animal
import com.deep.app.jetpacknavigation.AnimalsRecyclerAdapter
import com.deep.app.jetpacknavigation.R
import com.deep.app.jetpacknavigation.fragment.AnimalDetailFragment.Companion.ARG_ANIMAL
import kotlinx.android.synthetic.main.fragment_animals.view.*

class AnimalsFragment : Fragment() {

    private val callbacks: AnimalsRecyclerAdapter.Callback =
        object : AnimalsRecyclerAdapter.Callback {
            override fun onClick(animal: Animal) {
                findNavController().navigate(R.id.action_details,
                    Bundle().apply {
                        putSerializable(ARG_ANIMAL, animal)
                    })
            }

        }
    private var animalFamily: String = ARG_DOGS

    companion object {

        const val ARG_ANIMAL_FAMILY = "animal_family"
        const val ARG_DOGS = "dogs"
        const val ARG_CATS = "cats"

        @JvmStatic
        fun newInstance(animalFamily: String) =
            AnimalsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ANIMAL_FAMILY, animalFamily)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            animalFamily = it.getString(ARG_ANIMAL_FAMILY, ARG_DOGS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val adapter = AnimalsRecyclerAdapter()
        adapter.addAll(0, list = Animal.getData(animalFamily))
        adapter.callbacks = callbacks

        view.recycler_view.layoutManager = lm
        view.recycler_view.adapter = adapter
    }
}
