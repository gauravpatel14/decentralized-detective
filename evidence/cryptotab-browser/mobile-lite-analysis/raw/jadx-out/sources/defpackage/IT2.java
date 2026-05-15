package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IT2 {
    public final Uri a;
    public final String b = "";
    public final boolean c;

    public IT2(Uri uri, boolean z, boolean z2) {
        this.a = uri;
        this.c = z;
    }

    public final AT2 a(long j, String str) {
        return new AT2(this, str, Long.valueOf(j));
    }

    public final GT2 b(String str, String str2) {
        return new GT2(this, str, str2);
    }

    public final CT2 c(String str, boolean z) {
        return new CT2(this, str, Boolean.valueOf(z));
    }
}
