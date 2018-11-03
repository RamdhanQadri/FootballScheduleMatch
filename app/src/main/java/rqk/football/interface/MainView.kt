package rqk.football.`interface`

import rqk.football.model.Event

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showEventMatch(data: List<Event>)
}