package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MD0 {
    public static View a(int i, Context context) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        LP1 lp1C = LP1.c();
        try {
            View viewInflate = layoutInflaterFrom.inflate(i, (ViewGroup) null, false);
            lp1C.close();
            return viewInflate;
        } catch (Throwable th) {
            try {
                lp1C.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }
}
