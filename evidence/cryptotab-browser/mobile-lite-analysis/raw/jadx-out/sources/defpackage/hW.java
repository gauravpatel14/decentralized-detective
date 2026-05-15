package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.f;
import androidx.fragment.app.g;
import androidx.fragment.app.y;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hW implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Object u;
    public final /* synthetic */ Object v;

    public /* synthetic */ hW(int i, Object obj, Object obj2) {
        this.t = i;
        this.u = obj;
        this.v = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                ((g) this.u).a((y) this.v);
                break;
            case 1:
                AbstractC0207Ri0.j((Rect) this.v, (View) this.u);
                break;
            default:
                Iterator it = ((f) this.u).c.iterator();
                while (it.hasNext()) {
                    y yVar = ((qW) it.next()).a;
                    View view = yVar.c.getView();
                    if (view != null) {
                        AbstractC1609vM1.a(yVar.a, view, (ViewGroup) this.v);
                    }
                }
                break;
        }
    }

    public /* synthetic */ hW(AbstractC0207Ri0 abstractC0207Ri0, View view, Rect rect) {
        this.t = 1;
        this.u = view;
        this.v = rect;
    }
}
