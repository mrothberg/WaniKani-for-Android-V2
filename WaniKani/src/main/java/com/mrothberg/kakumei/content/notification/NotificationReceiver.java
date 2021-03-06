package com.mrothberg.kakumei.content.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mrothberg.kakumei.database.DatabaseManager;
import com.mrothberg.kakumei.managers.PrefManager;
import com.mrothberg.kakumei.wkamodels.StudyQueue;

/**
 * This receiver is called on every screen unlock. It schedules an alarm to set off on the next review
 * time. It also checks whether a specific amount of time has passed since the last time a
 * notification was shown and calls {@link com.mrothberg.kakumei.content.notification.NotificationPublisher}
 * to display a new notification if any lessons are available.
 */
public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        handleSituation(context);
    }

    public void handleSituation(Context context) {
        NotificationPreferences prefs = new NotificationPreferences(context);

        if (!PrefManager.isFirstLaunch() && PrefManager.notificationsEnabled()) {
            if (!prefs.isAlarmSet()) {
                /** Schedule an alarm if none is scheduled yet */
                StudyQueue queue = DatabaseManager.getStudyQueue();
                //noinspection SimplifiableConditionalExpression
                if (queue != null ? queue.reviews_available == 0 : true) {
                    new NotificationScheduler(context).schedule();
                }
            }
            /** Show a notification anyways if a given period of time has passed */
            if (prefs.shouldShowNotification()) {
                new NotificationPublisher().publish(context);
            }
        }
    }
}