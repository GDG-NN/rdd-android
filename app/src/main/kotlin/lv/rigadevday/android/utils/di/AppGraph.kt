package lv.rigadevday.android.utils.di

import dagger.Component
import lv.rigadevday.android.ui.schedule.MyScheduleFragment
import lv.rigadevday.android.ui.schedule.day.DayScheduleFragment
import lv.rigadevday.android.ui.schedule.day.adapter.ScheduleAdapter
import lv.rigadevday.android.ui.schedule.sessions.SessionsActivity
import lv.rigadevday.android.ui.speakers.SpeakerDialogActivity
import lv.rigadevday.android.ui.speakers.SpeakerListFragment
import lv.rigadevday.android.utils.BaseApp
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppGraph {

    // App
    fun inject(app: BaseApp)

    // Activity
    fun inject(activity: SpeakerDialogActivity)
    fun inject(activity: SessionsActivity)

    // Fragments
    fun inject(fragment: SpeakerListFragment)
    fun inject(fragment: MyScheduleFragment)
    fun inject(fragment: DayScheduleFragment)

    // Adapters
    fun inject(adapter: ScheduleAdapter)

}
