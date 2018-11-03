package rqk.football.view.activity.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.google.gson.Gson
import org.jetbrains.anko.support.v4.onRefresh
import rqk.football.`interface`.MainView
import rqk.football.model.Event
import rqk.football.R
import rqk.football.adapter.MainAdapter
import rqk.football.api.ApiRepository
import rqk.football.presenter.MainPresenter
import rqk.football.utils.invisible
import rqk.football.utils.visible


private const val LAST_MATCH = "lastMatch"
private const val leagueId: Int = 4332

class LastMatchFragment : Fragment(), MainView {
    private var events: MutableList<Event> = mutableListOf()
    private var listener: interactionListenerLast? = null
    private var match: Boolean = true

    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            match = it.getBoolean(LAST_MATCH)
        }
        presenter = MainPresenter(this, ApiRepository(), Gson())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_match, container, false)

        progressBar = rootView.findViewById(R.id.progressBar)
        swipeRefresh = rootView.findViewById(R.id.swipeRefresh)
        swipeRefresh.onRefresh {
            presenter.getLastEvents(leagueId)
        }

        adapter = MainAdapter(events) {
            val match = events.get(events.indexOf(it))
            listener?.itemClickLast(match)
        }

        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getLastEvents(leagueId)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is interactionListenerLast) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + "must implement InteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showEventMatch(data: List<Event>) {
        swipeRefresh.isRefreshing = false
        events.clear()
        events.addAll(data)
        adapter.notifyDataSetChanged()
    }

    interface interactionListenerLast {
        fun itemClickLast(match: Event)
    }

    companion object {
        @JvmStatic
        fun newInstanceLast(match: Boolean) =
            LastMatchFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(LAST_MATCH, match)
                }
            }
    }
}
