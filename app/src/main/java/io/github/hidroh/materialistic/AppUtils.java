package io.github.hidroh.materialistic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;

public class AppUtils {
    public static void openWebUrl(Context context, String url, String title) {
        final boolean isExternal = PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(context.getString(R.string.pref_external), false);
        if (isExternal) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        } else {
            final Intent intent = new Intent(context, WebActivity.class);
            intent.putExtra(WebActivity.EXTRA_TITLE, title);
            intent.putExtra(WebActivity.EXTRA_URL, url);
            context.startActivity(intent);
        }
    }
}