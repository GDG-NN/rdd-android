package lv.rigadevday.android.ui.schedule

import android.view.View
import kotlinx.android.synthetic.main.fragment_my_schedule.view.*
import lv.rigadevday.android.R
import lv.rigadevday.android.ui.base.BaseFragment
import lv.rigadevday.android.ui.base.ViewPagerAdapter
import lv.rigadevday.android.ui.schedule.day.DayScheduleFragment
import lv.rigadevday.android.utils.BaseApp
import lv.rigadevday.android.utils.showMessage

class MyScheduleFragment : BaseFragment() {

    override val layoutId = R.layout.fragment_my_schedule

    private var adapter: ViewPagerAdapter? = null

    override fun inject() {
        BaseApp.graph.inject(this)
    }

    override fun viewReady(view: View) {
        setupActionBar(R.string.title_schedule)
        adapter = ViewPagerAdapter(childFragmentManager)

        dataFetchSubscription = repo.schedule().subscribe(
            { adapter?.addFragment(DayScheduleFragment.newInstance(it.date), it.dateReadable) },
            { view.showMessage(R.string.error_message) },
            {
                view.schedule_pager.offscreenPageLimit = 2
                view.schedule_pager.adapter = adapter
                view.schedule_tabs.setupWithViewPager(view.schedule_pager)
            }
        )
    }

}