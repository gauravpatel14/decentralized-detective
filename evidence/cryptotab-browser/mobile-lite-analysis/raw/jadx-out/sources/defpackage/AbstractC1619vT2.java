package defpackage;

import android.net.Uri;

/* JADX INFO: renamed from: vT2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1619vT2 {
    public static final gf a = new gf(0);

    public static synchronized Uri a() {
        gf gfVar = a;
        Uri uri = (Uri) gfVar.get("com.google.android.gms.measurement");
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
        gfVar.put("com.google.android.gms.measurement", uri2);
        return uri2;
    }
}
