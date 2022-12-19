package com.revhalisi.appchurch.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.revhalisi.appchurch.Notification;

public class broadcasterManager extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Notification _notificationUtils = new Notification(context);
        NotificationCompat.Builder _builder = _notificationUtils.setNotification("Testing", "Testing notification system");
        _notificationUtils.getManager().notify(101, _builder.build());
    }
}
