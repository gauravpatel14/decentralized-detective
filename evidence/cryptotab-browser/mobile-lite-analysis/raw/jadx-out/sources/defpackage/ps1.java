package defpackage;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ps1 {
    public static final List M = Collections.emptyList();
    public int C;
    public RecyclerView K;
    public Pr1 L;
    public final View t;
    public WeakReference u;
    public int v = -1;
    public int w = -1;
    public long x = -1;
    public int y = -1;
    public int z = -1;
    public ps1 A = null;
    public ps1 B = null;
    public ArrayList D = null;
    public List E = null;
    public int F = 0;
    public C0738gs1 G = null;
    public boolean H = false;
    public int I = 0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f34J = -1;

    public ps1(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.t = view;
    }

    public final void c(int i) {
        this.C = i | this.C;
    }

    public final int d() {
        RecyclerView recyclerView = this.K;
        if (recyclerView == null) {
            return -1;
        }
        return recyclerView.J(this);
    }

    public final int e() {
        RecyclerView recyclerView;
        Pr1 pr1;
        int iJ;
        if (this.L == null || (recyclerView = this.K) == null || (pr1 = recyclerView.F) == null || (iJ = recyclerView.J(this)) == -1 || this.L != pr1) {
            return -1;
        }
        return iJ;
    }

    public final int f() {
        int i = this.z;
        return i == -1 ? this.v : i;
    }

    public final List g() {
        ArrayList arrayList;
        return ((this.C & 1024) != 0 || (arrayList = this.D) == null || arrayList.size() == 0) ? M : this.E;
    }

    public final boolean h(int i) {
        return (i & this.C) != 0;
    }

    public final boolean i() {
        View view = this.t;
        return (view.getParent() == null || view.getParent() == this.K) ? false : true;
    }

    public final boolean j() {
        return (this.C & 1) != 0;
    }

    public final boolean k() {
        return (this.C & 4) != 0;
    }

    public final boolean l() {
        if ((this.C & 16) == 0) {
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            if (!this.t.hasTransientState()) {
                return true;
            }
        }
        return false;
    }

    public final boolean m() {
        return (this.C & 8) != 0;
    }

    public final boolean n() {
        return this.G != null;
    }

    public final boolean o() {
        return (this.C & 256) != 0;
    }

    public final boolean p() {
        return (this.C & 2) != 0;
    }

    public final void q(int i, boolean z) {
        if (this.w == -1) {
            this.w = this.v;
        }
        if (this.z == -1) {
            this.z = this.v;
        }
        if (z) {
            this.z += i;
        }
        this.v += i;
        View view = this.t;
        if (view.getLayoutParams() != null) {
            ((C0321Zr1) view.getLayoutParams()).c = true;
        }
    }

    public final void r() {
        int[] iArr = RecyclerView.W0;
        this.C = 0;
        this.v = -1;
        this.w = -1;
        this.x = -1L;
        this.z = -1;
        this.F = 0;
        this.A = null;
        this.B = null;
        ArrayList arrayList = this.D;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.C &= -1025;
        this.I = 0;
        this.f34J = -1;
        RecyclerView.m(this);
    }

    public final void s(boolean z) {
        int i = this.F;
        int i2 = z ? i - 1 : i + 1;
        this.F = i2;
        if (i2 < 0) {
            this.F = 0;
            int[] iArr = RecyclerView.W0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z && i2 == 1) {
            this.C |= 16;
        } else if (z && i2 == 0) {
            this.C &= -17;
        }
        int[] iArr2 = RecyclerView.W0;
    }

    public final boolean t() {
        return (this.C & 128) != 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.v + " id=" + this.x + ", oldPos=" + this.w + ", pLpos:" + this.z);
        if (n()) {
            sb.append(" scrap ");
            sb.append(this.H ? "[changeScrap]" : "[attachedScrap]");
        }
        if (k()) {
            sb.append(" invalid");
        }
        if (!j()) {
            sb.append(" unbound");
        }
        if ((this.C & 2) != 0) {
            sb.append(" update");
        }
        if (m()) {
            sb.append(" removed");
        }
        if (t()) {
            sb.append(" ignored");
        }
        if (o()) {
            sb.append(" tmpDetached");
        }
        if (!l()) {
            sb.append(" not recyclable(" + this.F + ")");
        }
        if ((this.C & 512) != 0 || k()) {
            sb.append(" undefined adapter position");
        }
        if (this.t.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }

    public final boolean u() {
        return (this.C & 32) != 0;
    }
}
