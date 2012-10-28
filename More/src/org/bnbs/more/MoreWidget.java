
package org.bnbs.more;

import org.bnbs.more.R;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class MoreWidget extends AppWidgetProvider {
	private static final String LOG_TAG = "More... Widget";

	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		}
	
	@Override
	public void onDisabled(Context context) {
		super.onDisabled(context);
		Log.d(LOG_TAG, "Widget Provider destoryd!");
	}
	
	public void onCreate (Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];
            Intent intent = new Intent(context, MoreIdentifyActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget1);
            views.setOnClickPendingIntent(R.id.button, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
	
	public static void updateAppWidget(Context context,	AppWidgetManager appWidgetManager, int appWidgetId) {
		RemoteViews updateViews = new RemoteViews(context.getPackageName(),	R.layout.widget1);
		appWidgetManager.updateAppWidget(appWidgetId, updateViews);
	}

}
