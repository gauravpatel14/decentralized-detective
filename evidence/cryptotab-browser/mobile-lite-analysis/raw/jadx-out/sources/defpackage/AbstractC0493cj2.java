package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import com.google.android.gms.common.api.Api;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: cj2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0493cj2 {
    public AbstractC0493cj2() {
        new ConcurrentHashMap();
    }

    public abstract Typeface a(Context context, C0983kh0 c0983kh0, Resources resources, int i);

    public abstract Typeface b(Context context, C1289ph0[] c1289ph0Arr, int i);

    public Typeface c(Context context, Resources resources, int i, String str, int i2) {
        File fileD = AbstractC0544dj2.d(context);
        if (fileD == null) {
            return null;
        }
        try {
            if (AbstractC0544dj2.b(fileD, resources, i)) {
                return Typeface.createFromFile(fileD.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileD.delete();
        }
    }

    public C1289ph0 d(int i, C1289ph0[] c1289ph0Arr) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        C1289ph0 c1289ph0 = null;
        int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (C1289ph0 c1289ph02 : c1289ph0Arr) {
            int iAbs = (Math.abs(c1289ph02.c - i2) * 2) + (c1289ph02.d == z ? 0 : 1);
            if (c1289ph0 == null || i3 > iAbs) {
                c1289ph0 = c1289ph02;
                i3 = iAbs;
            }
        }
        return c1289ph0;
    }
}
