package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: wu1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1701wu1 implements Comparable {
    public final boolean A;
    public boolean B;
    public boolean C;
    public C0586eW D;
    public C0994kw E;
    public String F;
    public C0049Dq2 G;
    public final int t;
    public final String u;
    public final int v;
    public final Object w;
    public mv1 x;
    public Integer y;
    public Lu1 z;

    public AbstractC1701wu1(int i, String str, mv1 mv1Var) {
        Uri uri;
        String host;
        int i2 = AbstractC1528tq2.a;
        this.w = new Object();
        this.A = true;
        int iHashCode = 0;
        this.B = false;
        this.C = false;
        this.E = null;
        this.t = i;
        this.u = str;
        this.x = mv1Var;
        this.D = new C0586eW(1.0f, 2500, 1);
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.v = iHashCode;
    }

    public void a() {
        synchronized (this.w) {
            this.B = true;
            this.x = null;
        }
    }

    public abstract void b(Object obj);

    public final void c() {
        Lu1 lu1 = this.z;
        if (lu1 != null) {
            synchronized (lu1.b) {
                lu1.b.remove(this);
            }
            synchronized (lu1.j) {
                Iterator it = lu1.j.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
            lu1.b();
        }
        int i = AbstractC1528tq2.a;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        AbstractC1701wu1 abstractC1701wu1 = (AbstractC1701wu1) obj;
        int iG = g();
        int iG2 = abstractC1701wu1.g();
        return iG == iG2 ? this.y.intValue() - abstractC1701wu1.y.intValue() : aM1.b(iG2) - aM1.b(iG);
    }

    public byte[] d() {
        return null;
    }

    public String e() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public final String f() {
        String str = this.u;
        int i = this.t;
        if (i == 0 || i == -1) {
            return str;
        }
        return Integer.toString(i) + '-' + str;
    }

    public int g() {
        return 2;
    }

    public final boolean h() {
        boolean z;
        synchronized (this.w) {
            z = this.C;
        }
        return z;
    }

    public final boolean i() {
        boolean z;
        synchronized (this.w) {
            z = this.B;
        }
        return z;
    }

    public final void j() {
        C0049Dq2 c0049Dq2;
        synchronized (this.w) {
            c0049Dq2 = this.G;
        }
        if (c0049Dq2 != null) {
            c0049Dq2.b(this);
        }
    }

    public final void k(ov1 ov1Var) {
        C0049Dq2 c0049Dq2;
        List list;
        synchronized (this.w) {
            c0049Dq2 = this.G;
        }
        if (c0049Dq2 != null) {
            C0994kw c0994kw = ov1Var.b;
            if (c0994kw != null) {
                if (c0994kw.e >= System.currentTimeMillis()) {
                    String strF = f();
                    synchronized (c0049Dq2) {
                        list = (List) c0049Dq2.a.remove(strF);
                    }
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            c0049Dq2.b.a((AbstractC1701wu1) it.next(), ov1Var, null);
                        }
                        return;
                    }
                    return;
                }
            }
            c0049Dq2.b(this);
        }
    }

    public abstract ov1 l(C1223oY0 c1223oY0);

    public final void m(int i) {
        Lu1 lu1 = this.z;
        if (lu1 != null) {
            lu1.b();
        }
    }

    public final String toString() {
        String str = "0x" + Integer.toHexString(this.v);
        StringBuilder sb = new StringBuilder();
        sb.append(i() ? "[X] " : "[ ] ");
        sb.append(this.u);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        int iG = g();
        sb.append(iG != 1 ? iG != 2 ? iG != 3 ? iG != 4 ? "null" : "IMMEDIATE" : "HIGH" : "NORMAL" : "LOW");
        sb.append(" ");
        sb.append(this.y);
        return sb.toString();
    }
}
