package defpackage;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: renamed from: ea, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0593ea {
    public static Object a(String str, Bundle bundle) {
        return bundle.getParcelable(str, Uri.class);
    }
}
