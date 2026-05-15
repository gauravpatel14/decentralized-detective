package org.chromium.content.browser;

import J.N;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.util.Log;
import android.util.Pair;
import defpackage.AbstractC0275Wp1;
import defpackage.AbstractC1499tM;
import defpackage.C0064Fa2;
import defpackage.C1402rf2;
import defpackage.F;
import defpackage.LP1;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class TracingControllerAndroidImpl {
    public final Context a;
    public final TracingIntentFilter c;
    public boolean d;
    public String f;
    public boolean g;
    public boolean h;
    public long i;
    public boolean e = true;
    public final C1402rf2 b = new C1402rf2(this);

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class TracingIntentFilter extends IntentFilter {
    }

    public TracingControllerAndroidImpl(Context context) {
        this.a = context;
        TracingIntentFilter tracingIntentFilter = new TracingIntentFilter();
        tracingIntentFilter.addAction(context.getPackageName() + ".GPU_PROFILER_START");
        tracingIntentFilter.addAction(context.getPackageName() + ".GPU_PROFILER_STOP");
        tracingIntentFilter.addAction(context.getPackageName() + ".GPU_PROFILER_LIST_CATEGORIES");
        this.c = tracingIntentFilter;
    }

    public static String generateTracingFilePath(String str) {
        LP1 lp1D = LP1.d();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                lp1D.close();
                return null;
            }
            if (str.isEmpty()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                str = "chrome-profile-results-" + simpleDateFormat.format(new Date());
            }
            String path = new File(AbstractC1499tM.a.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), str).getPath();
            lp1D.close();
            return path;
        } catch (Throwable th) {
            try {
                lp1D.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final void a() {
        if (this.i == 0) {
            this.i = N._J_O(46, this);
        }
    }

    public final boolean b(String str, boolean z, String str2, String str3, boolean z2, boolean z3) {
        this.e = z;
        Context context = this.a;
        if (str == null && (str = generateTracingFilePath("")) == null) {
            String string = context.getString(AbstractC0275Wp1.profiler_no_storage_toast);
            Log.e("cr_TracingController", string);
            if (this.e) {
                C0064Fa2.c(context, string, 0).e();
            }
            return false;
        }
        if (this.d) {
            Log.e("cr_TracingController", "Received startTracing, but we're already tracing");
            return false;
        }
        a();
        if (!N._Z_ZJOOO(0, z3, this.i, this, str2, str3)) {
            String string2 = context.getString(AbstractC0275Wp1.profiler_error_toast);
            Log.e("cr_TracingController", string2);
            if (this.e) {
                C0064Fa2.c(context, string2, 0).e();
            }
            return false;
        }
        Log.i("cr_TracingController", "Profiler started: " + str2);
        String strB = F.b(context.getString(AbstractC0275Wp1.profiler_started_toast), ": ", str2);
        if (this.e) {
            C0064Fa2.c(context, strB, 0).e();
        }
        this.f = str;
        this.g = z2;
        this.h = z3;
        this.d = true;
        return true;
    }

    public void onKnownCategoriesReceived(String[] strArr, Object obj) {
        if (obj != null) {
            ((Callback) obj).a0(strArr);
        }
    }

    public void onTraceBufferUsageReceived(float f, long j, Object obj) {
        ((Callback) obj).a0(new Pair(Float.valueOf(f), Long.valueOf(j)));
    }

    public void onTracingStopped(Object obj) {
        if (!this.d) {
            Log.e("cr_TracingController", "Received onTracingStopped, but we aren't tracing");
            return;
        }
        Log.i("cr_TracingController", "Profiler finished. Results are in " + this.f + ".");
        int i = AbstractC0275Wp1.profiler_stopped_toast;
        Object[] objArr = {this.f};
        Context context = this.a;
        String string = context.getString(i, objArr);
        if (this.e) {
            C0064Fa2.c(context, string, 0).e();
        }
        this.d = false;
        this.f = null;
        this.g = false;
        if (obj != null) {
            ((Callback) obj).a0(null);
        }
    }
}
