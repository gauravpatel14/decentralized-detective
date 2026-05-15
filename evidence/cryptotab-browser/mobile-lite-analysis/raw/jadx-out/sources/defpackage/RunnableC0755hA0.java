package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: renamed from: hA0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0755hA0 implements Runnable {
    public final /* synthetic */ C0686gA0 t;
    public final /* synthetic */ nA0 u;

    public RunnableC0755hA0(nA0 na0, C0686gA0 c0686gA0, int i) {
        this.u = na0;
        this.t = c0686gA0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        nA0 na0 = this.u;
        RecyclerView recyclerView = na0.r;
        if (recyclerView == null || !recyclerView.M) {
            return;
        }
        C0686gA0 c0686gA0 = this.t;
        if (c0686gA0.D) {
            return;
        }
        ps1 ps1Var = c0686gA0.x;
        if (ps1Var.d() != -1) {
            WJ1 wj1 = na0.r.j0;
            if (wj1 == null || !wj1.k()) {
                ArrayList arrayList = na0.p;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (((C0686gA0) arrayList.get(i)).E) {
                    }
                }
                na0.m.n(ps1Var);
                return;
            }
            na0.r.post(this);
        }
    }
}
