package rqk.football.`interface`

import rqk.football.model.Detail
import rqk.football.model.Team

interface MainViewDetail {
    fun showLoading()
    fun hideLoading()
    fun showDetailMatch(data: Detail)
    fun showDetailTeam(data: Team, homeTeam: Boolean)
}