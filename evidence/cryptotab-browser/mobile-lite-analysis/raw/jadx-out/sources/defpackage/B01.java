package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class B01 {
    public final Bundle a;
    public IconCompat b;
    public final Gt1[] c;
    public final boolean d;
    public final boolean e;
    public final int f;
    public final CharSequence g;
    public PendingIntent h;

    public B01(IconCompat iconCompat, String str, PendingIntent pendingIntent) {
        this(iconCompat, str, pendingIntent, new Bundle(), null, null, true, true);
    }

    public B01(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, Gt1[] gt1Arr, Gt1[] gt1Arr2, boolean z, boolean z2) {
        this.e = true;
        this.b = iconCompat;
        if (iconCompat != null) {
            int i = iconCompat.a;
            if ((i == -1 ? AbstractC1870zs0.c(iconCompat.b) : i) == 2) {
                this.f = iconCompat.b();
            }
        }
        this.g = F01.b(charSequence);
        this.h = pendingIntent;
        this.a = bundle == null ? new Bundle() : bundle;
        this.c = gt1Arr;
        this.d = z;
        this.e = z2;
    }
}
