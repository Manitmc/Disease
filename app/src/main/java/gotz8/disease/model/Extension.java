package gotz8.disease.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Gotz8 on 2/27/2018.
 */

public class Extension {

    public static PendingIntent createPendingShareIntent(Context c) {
        Intent actionIntent = new Intent(Intent.ACTION_SEND);
        actionIntent.setType("text/plain");
        actionIntent.putExtra(Intent.EXTRA_TEXT, "Sharing this! please read !@!!");
        return PendingIntent.getActivity(c, 0, actionIntent, 0);
    }
}
