package com.deep.app.jetpacknavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import coil.api.load
import com.deep.app.jetpacknavigation.Animal
import com.deep.app.jetpacknavigation.R
import kotlinx.android.synthetic.main.animal_detail_fragment.view.*

class AnimalDetailFragment : Fragment() {

    private var animal: Animal? = null

    companion object {

        const val ARG_ANIMAL = "animal"

        @JvmStatic
        fun newInstance(animal: Animal) =
            AnimalsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_ANIMAL, animal)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        animal = arguments?.getSerializable(ARG_ANIMAL) as? Animal
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.animal_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.text_view.text = animal?.name
        view.image_view.load(animal?.imgURL)

    }

    override fun onResume() {
        super.onResume()
        view?.findViewById<Toolbar>(R.id.toolbar)?.title = animal?.name
    }
}