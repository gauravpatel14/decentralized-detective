package defpackage;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class xH1 {
    public final SharedPreferences a;
    public final ScheduledThreadPoolExecutor e;
    public final ArrayDeque d = new ArrayDeque();
    public final String b = "topic_operation_queue";
    public final String c = ",";

    public xH1(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.a = sharedPreferences;
        this.e = scheduledThreadPoolExecutor;
    }

    public static xH1 a(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        xH1 xh1 = new xH1(sharedPreferences, scheduledThreadPoolExecutor);
        synchronized (xh1.d) {
            try {
                xh1.d.clear();
                String string = xh1.a.getString(xh1.b, "");
                if (!TextUtils.isEmpty(string) && string.contains(xh1.c)) {
                    String[] strArrSplit = string.split(xh1.c, -1);
                    if (strArrSplit.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            xh1.d.add(str);
                        }
                    }
                }
            } finally {
            }
        }
        return xh1;
    }
}
