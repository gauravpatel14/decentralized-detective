package defpackage;

import android.view.View;
import android.view.animation.BaseInterpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: np2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1173np2 {
    public BaseInterpolator c;
    public AbstractC1293pp2 d;
    public boolean e;
    public long b = -1;
    public final C1110mp2 f = new C1110mp2(this);
    public final ArrayList a = new ArrayList();

    public final void a() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((C1050lp2) it.next()).b();
            }
            this.e = false;
        }
    }

    public final void b() {
        View view;
        if (this.e) {
            return;
        }
        for (C1050lp2 c1050lp2 : this.a) {
            long j = this.b;
            if (j >= 0) {
                c1050lp2.c(j);
            }
            BaseInterpolator baseInterpolator = this.c;
            if (baseInterpolator != null && (view = (View) c1050lp2.a.get()) != null) {
                view.animate().setInterpolator(baseInterpolator);
            }
            if (this.d != null) {
                c1050lp2.d(this.f);
            }
            View view2 = (View) c1050lp2.a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.e = true;
    }
}
