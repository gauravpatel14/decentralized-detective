package defpackage;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WQ2 {
    public static String a(Context context) {
        try {
            return context.getResources().getResourcePackageName(AbstractC0275Wp1.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }
}
