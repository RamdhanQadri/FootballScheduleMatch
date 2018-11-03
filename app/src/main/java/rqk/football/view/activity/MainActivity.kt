package rqk.football.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import rqk.football.R
import rqk.football.adapter.ViewPagerAdapter
import rqk.football.model.Event
import rqk.football.view.activity.fragment.LastMatchFragment
import rqk.football.view.activity.fragment.NextMatchFragment
import rqk.football.view.detail.DetailActivity


class MainActivity : AppCompatActivity(), LastMatchFragment.interactionListenerLast,
    NextMatchFragment.interactionListenerNext {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragAdapter = ViewPagerAdapter(supportFragmentManager)
        pager.adapter = fragAdapter
        tabLayout.setupWithViewPager(pager)

        LastMatchFragment.newInstanceLast(true)
        NextMatchFragment.newInstanceNext(true)

    }

    override fun itemClickLast(match: Event) {
        startActivity<DetailActivity>(
            "match" to match.eventId,
            "home" to match.homeTeamId,
            "away" to match.awayTeamId
        )
    }

    override fun itemClickNext(match: Event) {
        startActivity<DetailActivity>(
            "match" to match.eventId,
            "home" to match.homeTeamId,
            "away" to match.awayTeamId
        )
    }
}
