package org.chromium.chrome.browser.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import defpackage.AbstractC1499tM;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class PlatformUtil {
    public static void launchExternalProtocol(String str) {
        Context context = AbstractC1499tM.a;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.BROWSABLE");
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e("cr_PlatformUtil", "cannot find activity to launch " + str, e);
        }
    }
}
