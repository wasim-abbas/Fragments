package com.example.fragmentsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fragmentsapplication.fragemntUI.FragmentFour
import com.example.fragmentsapplication.fragemntUI.FragmentOne
import com.example.fragmentsapplication.fragemntUI.FragmentThree
import com.example.fragmentsapplication.fragemntUI.FragmentTwo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var frag = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        sendData()

    }

    fun init() {
        btnadd.setOnClickListener(this)
        btdelete.setOnClickListener(this)
        btnReplace.setOnClickListener(this)
        btBackStace.setOnClickListener(this)
    }


    fun setButtonAdd() {
        var fragment = Fragment()

        when (frag.backStackEntryCount) {
            0 -> fragment = FragmentOne()
            1 -> fragment = FragmentTwo()
            2 -> fragment = FragmentThree()
            3 -> fragment = FragmentFour()
        }
        if (fragment != null) {
            var fragTransaction = frag.beginTransaction()
            fragTransaction.add(R.id.framlayout, fragment)
            fragTransaction.addToBackStack(null)
            fragTransaction.commit()
        }

    }

    fun setButtonRemove() {
        var fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.framlayout)
        if (fragment != null) {
            var fragTrans = supportFragmentManager.beginTransaction()
            fragTrans.remove(fragment)
            fragTrans.commit()
        } else if (fragment == null) {
            setButtonAdd()
        }
    }

    fun setButtonReplace() {

        var fragment = Fragment()

        when (frag.backStackEntryCount) {
            0 -> fragment = FragmentOne()
            1 -> fragment = FragmentTwo()
            2 -> fragment = FragmentThree()
            3 -> fragment = FragmentFour()
        }
        var fragTransaction = frag.beginTransaction()
        fragTransaction.replace(R.id.framlayout, fragment)/// replace() = remove and add
        fragTransaction.addToBackStack(null)
        fragTransaction.commit()

    }

    fun setbButtonBackStack() {}

    fun  sendData()
    {
        val framentone= FragmentOne()
        val fragManager = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()

        val bundle = Bundle()
        bundle.putString("key","Hello wasim")

        framentone.arguments = bundle
        fragTransaction.add(R.id.framlayout, framentone).commit()


    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btnadd -> setButtonAdd()
                R.id.btdelete -> setButtonRemove()
                R.id.btnReplace -> setButtonReplace()
                R.id.btBackStace -> setbButtonBackStack()

            }
        }

    }
}

//    fun handleStateChange(stateChange: StateChange) {
//        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.disallowAddToBackStack()
//
//        // here you could animate based on direction
//        val previousKeys: List<Key> = stateChange.getPreviousKeys()
//        val newKeys: List<Key> = stateChange.getNewKeys()
//        for (oldKey in previousKeys) {
//            val fragment: Fragment? =
//                supportFragmentManager.findFragmentByTag(oldKey.getFragmentTag())
//            if (fragment != null) {
//                if (!newState.contains(oldKey)) {
//                    fragmentTransaction.remove(fragment)
//                } else if (!fragment.isDetached) {
//                    fragmentTransaction.detach(fragment)
//                }
//            }
//        }
//        for (newKey in newKeys) {
//            var fragment: android.app.Fragment? =
//                fragmentManager.findFragmentByTag(newKey.getFragmentTag())
//            if (newKey.equals(stateChange.topNewKey())) {
//                if (fragment != null) {
//                    if (fragment.isRemoving) {
//                        fragment = newKey.createFragment()
//                        fragmentTransaction.replace(containerId, fragment, newKey.getFragmentTag())
//                    } else if (fragment.isDetached) {
//                        fragmentTransaction.attach(fragment)
//                    }
//                } else {
//                    fragment = newKey.createFragment()
//                    fragmentTransaction.add(containerId, fragment, newKey.getFragmentTag())
//                }
//            } else {
//                if (fragment != null && !fragment.isDetached) {
//                    fragmentTransaction.detach(fragment)
//                }
//            }
//        }
//        fragmentTransaction.commitNow() // or commitAllowingStateLoss();
//
//    }
//}