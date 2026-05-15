package androidx.fragment.app;

import android.view.ViewGroup;
import defpackage.AbstractC1555uM1;
import defpackage.MG;
import defpackage.aM1;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    public int a;
    public int b;
    public final n c;
    public final ArrayList d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final ArrayList j;
    public final ArrayList k;
    public final u l;

    public y(int i, int i2, u uVar) {
        n nVar = uVar.c;
        this.a = i;
        this.b = i2;
        this.c = nVar;
        this.d = new ArrayList();
        this.i = true;
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        this.k = arrayList;
        this.l = uVar;
    }

    public final void a(ViewGroup viewGroup) {
        this.h = false;
        if (this.e) {
            return;
        }
        this.e = true;
        if (this.j.isEmpty()) {
            b();
            return;
        }
        for (AbstractC1555uM1 abstractC1555uM1 : MG.k(this.k)) {
            if (!abstractC1555uM1.b) {
                abstractC1555uM1.b(viewGroup);
            }
            abstractC1555uM1.b = true;
        }
    }

    public final void b() {
        this.h = false;
        if (!this.f) {
            this.f = true;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.c.mTransitioning = false;
        this.l.g();
    }

    public final void c(AbstractC1555uM1 abstractC1555uM1) {
        ArrayList arrayList = this.j;
        if (arrayList.remove(abstractC1555uM1) && arrayList.isEmpty()) {
            b();
        }
    }

    public final void d(int i, int i2) {
        int iB = aM1.b(i2);
        if (iB == 0) {
            if (this.a != 1) {
                this.a = i;
            }
        } else {
            if (iB != 1) {
                if (iB != 2) {
                    return;
                }
                this.a = 1;
                this.b = 3;
                this.i = true;
                return;
            }
            if (this.a == 1) {
                this.a = 2;
                this.b = 2;
                this.i = true;
            }
        }
    }

    public final String toString() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        StringBuilder sb = new StringBuilder("Operation {");
        sb.append(hexString);
        sb.append("} {finalState = ");
        int i = this.a;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED");
        sb.append(" lifecycleImpact = ");
        int i2 = this.b;
        sb.append(i2 != 1 ? i2 != 2 ? i2 != 3 ? "null" : "REMOVING" : "ADDING" : "NONE");
        sb.append(" fragment = ");
        sb.append(this.c);
        sb.append('}');
        return sb.toString();
    }
}
