package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: Qi0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0196Qi0 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ ArrayList u;
    public final /* synthetic */ ArrayList v;
    public final /* synthetic */ ArrayList w;
    public final /* synthetic */ ArrayList x;

    public RunnableC0196Qi0(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.t = i;
        this.u = arrayList;
        this.v = arrayList2;
        this.w = arrayList3;
        this.x = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i = 0; i < this.t; i++) {
            View view = (View) this.u.get(i);
            String str = (String) this.v.get(i);
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            view.setTransitionName(str);
            ((View) this.w.get(i)).setTransitionName((String) this.x.get(i));
        }
    }
}
