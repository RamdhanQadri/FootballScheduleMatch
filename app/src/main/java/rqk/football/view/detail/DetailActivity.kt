package rqk.football.view.detail

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import com.bumptech.glide.Glide
import com.google.gson.Gson
import org.jetbrains.anko.*
import rqk.football.R
import rqk.football.`interface`.MainViewDetail
import rqk.football.api.ApiRepository
import rqk.football.model.Detail
import rqk.football.model.Team
import rqk.football.presenter.MainPresenterDetail
import rqk.football.utils.formatDate
import rqk.football.utils.invisible
import rqk.football.utils.visible

class DetailActivity : AppCompatActivity(), MainViewDetail {
    private val presenterDetail: MainPresenterDetail = MainPresenterDetail(this, ApiRepository(), Gson())
    private lateinit var progressBarDetail: ProgressBar

    private lateinit var scrollV: ScrollView

    private lateinit var textViewDateDetail: TextView
    private lateinit var textViewHomeTeamDetail: TextView
    private lateinit var textViewHomeScoreDetail: TextView
    private lateinit var textViewAwayScoreDetail: TextView
    private lateinit var textViewAwayTeamDetail: TextView

    private lateinit var textViewGoolsHome: TextView
    private lateinit var textViewGoolsAway: TextView
    private lateinit var textViewShotsHome: TextView
    private lateinit var textViewShotsAway: TextView

    private lateinit var textViewGoolKeeperHome: TextView
    private lateinit var textViewGoolKeeperAway: TextView
    private lateinit var textViewDefenseHome: TextView
    private lateinit var textViewDefenseAway: TextView
    private lateinit var textViewMidfieldHome: TextView
    private lateinit var textViewMidfieldAway: TextView
    private lateinit var textViewForwardHome: TextView
    private lateinit var textViewForwardAway: TextView
    private lateinit var textViewSubstitutesHome: TextView
    private lateinit var textViewSubstitutesAway: TextView


    private lateinit var imageViewHomeTeamDetail: ImageView
    private lateinit var imageViewAwayTeamDetail: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {

            scrollV = scrollView {
                isVerticalScrollBarEnabled = false

                linearLayout {
                    orientation = LinearLayout.VERTICAL
                    lparams(matchParent, wrapContent)

                    //Grup 1
                    linearLayout {
                        backgroundColor = Color.GRAY
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.VERTICAL

                        textViewDateDetail = textView {
                            textColor = Color.BLACK
                            textSize = 14f
                            textColorResource = android.R.color.black
                        }.lparams(wrapContent, wrapContent)

                        //------------------------------------
                        linearLayout {
                            padding = dip(3)
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER
                            weightSum = 3F

                            linearLayout {
                                gravity = Gravity.CENTER
                                orientation = LinearLayout.VERTICAL

                                imageViewHomeTeamDetail = imageView {
                                }.lparams(dip(50), dip(50))

                                textViewHomeTeamDetail = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 16f
                                    typeface = Typeface.DEFAULT_BOLD
                                }.lparams(width = dip(80), height = wrapContent)

                            }.lparams {
                                topMargin = dip(5)
                                weight = 1F
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.CENTER
                                linearLayout {
                                    gravity = Gravity.CENTER

                                    textViewHomeScoreDetail = textView {
                                        textSize = 16f
                                        textColorResource = android.R.color.black
                                    }
                                }.lparams {
                                    topMargin = dip(5)
                                    weight = 0.1F
                                }

                                linearLayout {
                                    gravity = Gravity.CENTER

                                    textView {
                                        textResource = R.string.match
                                        textSize = 16f
                                    }
                                }.lparams {
                                    topMargin = dip(5)
                                    weight = 0.1F
                                }

                                linearLayout {
                                    gravity = Gravity.CENTER

                                    textViewAwayScoreDetail = textView {
                                        textSize = 16f
                                        textColorResource = android.R.color.black
                                    }
                                }.lparams {
                                    topMargin = dip(5)
                                    weight = 0.1F
                                }
                            }.lparams {
                                topMargin = dip(5)
                                weight = 1F
                            }

                            linearLayout {
                                gravity = Gravity.CENTER
                                orientation = LinearLayout.VERTICAL

                                imageViewAwayTeamDetail = imageView {
                                }.lparams(dip(50), dip(50))

                                textViewAwayTeamDetail = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 16f
                                    typeface = Typeface.DEFAULT_BOLD
                                }.lparams(width = dip(80), height = wrapContent)

                            }.lparams {
                                topMargin = dip(5)
                                weight = 1F
                            }
                        }.lparams(matchParent, matchParent)
                    }.lparams(matchParent, matchParent) {
                        setMargins(dip(5), dip(5), dip(5), dip(5))
                    }

                    //Grup 2
                    linearLayout {
                        backgroundColor = Color.GRAY
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.VERTICAL

                        //------------------------------------
                        linearLayout {
                            padding = dip(10)
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewGoolsHome = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textView {
                                    gravity = Gravity.CENTER
                                    textResource = R.string.gools
                                    textSize = 16f
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewGoolsAway = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }
                        }.lparams(width = matchParent, height = wrapContent)

                        //------------------------------------
                        linearLayout {
                            padding = dip(10)
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewShotsHome = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textView {
                                    gravity = Gravity.CENTER
                                    textResource = R.string.shots
                                    textSize = 16f
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewShotsAway = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }
                        }.lparams(width = matchParent, height = wrapContent)
                    }.lparams(matchParent, matchParent) {
                        setMargins(dip(5), dip(5), dip(5), dip(5))
                    }

                    linearLayout {
                        gravity = Gravity.CENTER

                        textView {
                            gravity = Gravity.CENTER
                            textResource = R.string.lineups
                            textSize = 16f
                            typeface = Typeface.DEFAULT_BOLD
                        }.lparams(width = wrapContent, height = wrapContent) {
                            setMargins(dip(2), dip(2), dip(2), dip(2))
                        }
                    }.lparams(matchParent, matchParent) {
                        setMargins(dip(5), dip(1), dip(5), dip(1))
                    }

                    //Grup 3
                    linearLayout {
                        backgroundColor = Color.GRAY
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.VERTICAL

                        //------------------------------------
                        linearLayout {
                            padding = dip(10)
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewGoolKeeperHome = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textView {
                                    gravity = Gravity.CENTER
                                    textResource = R.string.gool_keeper
                                    textSize = 16f
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewGoolKeeperAway = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }
                        }.lparams(width = matchParent, height = wrapContent)

                        //------------------------------------
                        linearLayout {
                            padding = dip(10)
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewDefenseHome = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textView {
                                    gravity = Gravity.CENTER
                                    textResource = R.string.defense
                                    textSize = 16f
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewDefenseAway = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }
                        }.lparams(width = matchParent, height = wrapContent)

                        //------------------------------------
                        linearLayout {
                            padding = dip(10)
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewMidfieldHome = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textView {
                                    gravity = Gravity.CENTER
                                    textResource = R.string.midfield
                                    textSize = 16f
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewMidfieldAway = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }
                        }.lparams(width = matchParent, height = wrapContent)

                        //------------------------------------
                        linearLayout {
                            padding = dip(10)
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewForwardHome = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textView {
                                    gravity = Gravity.CENTER
                                    textResource = R.string.forward
                                    textSize = 16f
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewForwardAway = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }
                        }.lparams(width = matchParent, height = wrapContent)

                        //------------------------------------
                        linearLayout {
                            padding = dip(10)
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewSubstitutesHome = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textView {
                                    gravity = Gravity.CENTER
                                    textResource = R.string.substitutes
                                    textSize = 16f
                                }.lparams(width = wrapContent, height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }

                            linearLayout {
                                gravity = Gravity.CENTER

                                textViewSubstitutesAway = textView {
                                    gravity = Gravity.CENTER
                                    textSize = 15f
                                }.lparams(width = dip(80), height = wrapContent) {
                                    setMargins(dip(2), dip(2), dip(2), dip(2))
                                }
                            }.lparams {
                                weight = 1f
                            }
                        }.lparams(width = matchParent, height = wrapContent)

                    }.lparams(matchParent, matchParent) {
                        setMargins(dip(5), dip(5), dip(5), dip(5))
                    }
                }
            }.lparams(matchParent, matchParent)

            progressBarDetail = progressBar {
            }
        }

        val matchId = intent.getStringExtra("match")
        val homeTeamId = intent.getStringExtra("home")
        val awayTeamId = intent.getStringExtra("away")

        presenterDetail.getDetailEvents(matchId)
        presenterDetail.getDetailTeams(homeTeamId)
        presenterDetail.getDetailTeams(awayTeamId, false)
    }


    override fun showLoading() {
        progressBarDetail.visible()
    }

    override fun hideLoading() {
        progressBarDetail.invisible()
    }

    override fun showDetailMatch(data: Detail) {
        textViewDateDetail.text = data.eventDate?.formatDate()
        textViewHomeTeamDetail.text = data.homeTeam
        textViewHomeScoreDetail.text = data.homeScore
        textViewAwayScoreDetail.text = data.awayScore
        textViewAwayTeamDetail.text = data.awayTeam
        textViewGoolsHome.text = data.homeGoalDetails
        textViewGoolsAway.text = data.awayGoalDetails
        textViewShotsHome.text = data.homeShots
        textViewShotsAway.text = data.awayShots
        textViewGoolKeeperHome.text = data.homeGoalKeeper
        textViewGoolKeeperAway.text = data.awayGoalKeeper
        textViewDefenseHome.text = data.homeDefense
        textViewDefenseAway.text = data.awayDefense
        textViewMidfieldHome.text = data.homeMidfield
        textViewMidfieldAway.text = data.awayMidfield
        textViewForwardHome.text = data.homeForward
        textViewForwardAway.text = data.awayForward
        textViewSubstitutesHome.text = data.homeSubstitutes
        textViewSubstitutesAway.text = data.awaySubstitutes
    }

    override fun showDetailTeam(data: Team, homeTeam: Boolean) {
        Glide.with(this).load(data.teamBadge).into(if (homeTeam) imageViewHomeTeamDetail else imageViewAwayTeamDetail)
    }
}
