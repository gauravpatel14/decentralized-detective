package defpackage;

import J.N;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import org.chromium.content.browser.TracingControllerAndroidImpl;

/* JADX INFO: renamed from: rf2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1402rf2 extends BroadcastReceiver {
    public final /* synthetic */ TracingControllerAndroidImpl a;

    public C1402rf2(TracingControllerAndroidImpl tracingControllerAndroidImpl) {
        this.a = tracingControllerAndroidImpl;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean zEndsWith = intent.getAction().endsWith("GPU_PROFILER_START");
        TracingControllerAndroidImpl tracingControllerAndroidImpl = this.a;
        if (zEndsWith) {
            String stringExtra = intent.getStringExtra("categories");
            String strReplaceFirst = TextUtils.isEmpty(stringExtra) ? (String) N._O_O(75, tracingControllerAndroidImpl) : stringExtra.replaceFirst("_DEFAULT_CHROME_CATEGORIES", (String) N._O_O(75, tracingControllerAndroidImpl));
            String str = intent.getStringExtra("continuous") == null ? "record-until-full" : "record-continuously";
            String stringExtra2 = intent.getStringExtra("file");
            if (stringExtra2 != null) {
                this.a.b(stringExtra2, true, strReplaceFirst, str, false, false);
                return;
            } else {
                this.a.b(null, true, strReplaceFirst, str, false, false);
                return;
            }
        }
        if (intent.getAction().endsWith("GPU_PROFILER_STOP")) {
            if (tracingControllerAndroidImpl.d) {
                N._V_ZZJOOO(1, tracingControllerAndroidImpl.g, tracingControllerAndroidImpl.h, tracingControllerAndroidImpl.i, tracingControllerAndroidImpl, tracingControllerAndroidImpl.f, null);
            }
        } else {
            if (!intent.getAction().endsWith("GPU_PROFILER_LIST_CATEGORIES")) {
                Log.e("cr_TracingController", String.format(Locale.US, "Unexpected intent: %s", intent));
                return;
            }
            tracingControllerAndroidImpl.a();
            if (N._Z_JOO(17, tracingControllerAndroidImpl.i, tracingControllerAndroidImpl, null)) {
                return;
            }
            Log.e("cr_TracingController", "Unable to fetch tracing category list.");
        }
    }
}
