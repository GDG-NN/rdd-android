package lv.rigadevday.android.utils.di

import dagger.Component
import lv.rigadevday.android.ui.orginizers.PartnersFragment
import lv.rigadevday.android.ui.schedule.MyScheduleFragment
import lv.rigadevday.android.ui.schedule.day.DayScheduleFragment
import lv.rigadevday.android.ui.schedule.day.adapter.ScheduleAdapter
import lv.rigadevday.android.ui.schedule.details.SessionDetailsActivity
import lv.rigadevday.android.ui.schedule.sessions.SessionsActivity
import lv.rigadevday.android.ui.speakers.SpeakerDialogActivity
import lv.rigadevday.android.ui.speakers.SpeakerListFragment
import lv.rigadevday.android.ui.splash.SplashActivity
import lv.rigadevday.android.utils.BaseApp
import lv.rigadevday.android.utils.push.CustomMessagingService
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppGraph {

    // App
    fun inject(app: BaseApp)

    // Activity
    fun inject(activity: SplashActivity)
    fun inject(activity: SpeakerDialogActivity)
    fun inject(activity: SessionsActivity)
    fun inject(activity: SessionDetailsActivity)

    // Fragments
    fun inject(fragment: SpeakerListFragment)
    fun inject(fragment: MyScheduleFragment)
    fun inject(fragment: DayScheduleFragment)
    fun inject(fragment: PartnersFragment)

    // Adapters
    fun inject(adapter: ScheduleAdapter)

    // Services
    fun inject(service: CustomMessagingService)

}
