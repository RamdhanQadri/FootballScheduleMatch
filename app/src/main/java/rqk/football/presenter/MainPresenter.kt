package rqk.football.presenter

import com.google.gson.Gson
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import rqk.football.`interface`.MainView
import rqk.football.api.ApiRepository
import rqk.football.api.TheSportDBApi
import rqk.football.model.EventResponse

class MainPresenter(
    private val view: MainView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) : AnkoLogger {
    fun getLastEvents(leagueId: Int?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLastEvents(leagueId)),
                EventResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showEventMatch(data.events)
            }
        }
    }

    fun getNextEvents(leagueId: Int?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNextEvents(leagueId)),
                EventResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showEventMatch(data.events)
            }
        }
    }
}