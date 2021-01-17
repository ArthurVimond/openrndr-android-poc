package fr.arthurvimond.openrndr.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import fr.arthurvimond.openrndr.android.Application

class ORFragment : Fragment() {

    companion object {

        fun newInstance(): ORFragment {
            val myFragment = ORFragment()
            val args = Bundle()
            myFragment.arguments = args
            return myFragment
        }

    }

    private lateinit var orView: ORView
    private lateinit var application: Application

    fun setView(view: View, activity: FragmentActivity) {
        val manager: FragmentManager = activity.supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(view.id, this)
        transaction.commit()
    }

    fun setApplication(application: Application) {
        this.application = application
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        orView = context?.let { ORView(it) }!!
        orView.setApplication(application)
        return orView
    }

    override fun onPause() {
        super.onPause()
        orView.pause()
    }

    override fun onResume() {
        super.onResume()
        orView.resume()
    }
}