package rqk.football.presenter

import com.google.gson.Gson
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import rqk.football.`interface`.MainViewDetail
import rqk.football.api.ApiRepository
import rqk.football.api.TheSportDBApi
import rqk.football.model.DetailResponse
import rqk.football.model.TeamResponse

class MainPresenterDetail(
    private val view: MainViewDetail,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) : AnkoLogger {

    fun getDetailEvents(eventId: String) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getDetailEvent(eventId)),
                DetailResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showDetailMatch(data.events.get(0))
            }
        }
    }

    fun getDetailTeams(teamId: String, homeTeam: Boolean = true) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getDetailTeam(teamId)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showDetailTeam(data.teams.get(0), homeTeam)
            }
        }
    }
}