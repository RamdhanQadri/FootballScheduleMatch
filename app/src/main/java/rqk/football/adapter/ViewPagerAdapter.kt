package rqk.football.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import rqk.football.view.activity.fragment.LastMatchFragment
import rqk.football.view.activity.fragment.NextMatchFragment

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){
    override fun getItem(p0: Int): Fragment {
        return when(p0){
            0->{
                LastMatchFragment()
            }else ->{
                NextMatchFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0->"Last Match"
            else->{
                "Next Match"
            }
        }
    }
}