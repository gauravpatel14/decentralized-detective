package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

/* JADX INFO: renamed from: u40, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C1539u40 {
    public final C1711x40 t;

    public C1539u40(Context context, View view) {
        this.t = new C1711x40(context, view);
    }

    public final void a(BaseAdapter baseAdapter) {
        C1711x40 c1711x40 = this.t;
        c1711x40.A = baseAdapter;
        c1711x40.B.setAdapter((ListAdapter) baseAdapter);
        c1711x40.z.h();
    }
}
