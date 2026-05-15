package defpackage;

import android.net.Uri;
import android.util.Log;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class U40 implements U41, Q41 {
    public final /* synthetic */ W40 a;

    @Override // defpackage.U41
    public void a(Object obj) {
        String str;
        C0267We1 c0267We1 = (C0267We1) obj;
        W40 w40 = this.a;
        w40.getClass();
        String string = null;
        if (c0267We1 != null) {
            DynamicLinkData dynamicLinkData = c0267We1.a;
            Uri uri = (dynamicLinkData == null || (str = dynamicLinkData.u) == null) ? null : Uri.parse(str);
            if (uri != null) {
                string = uri.toString();
            }
        }
        Log.i("cr_DynamicLinkController", "Dynamic link url: " + string);
        w40.c.set(string);
        w40.a.countDown();
    }

    @Override // defpackage.Q41
    public void d(Exception exc) {
        W40 w40 = this.a;
        w40.getClass();
        Log.w("cr_DynamicLinkController", "Dynamic link error", exc);
        w40.c.set(null);
        w40.a.countDown();
    }
}
