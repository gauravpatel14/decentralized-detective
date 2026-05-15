package defpackage;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: pS2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1275pS2 {
    public long A;
    public long B;
    public String C;
    public boolean D;
    public long E;
    public long F;
    public final C1391rR2 a;
    public final String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g;
    public long h;
    public long i;
    public String j;
    public long k;
    public String l;
    public long m;
    public long n;
    public boolean o;
    public long p;
    public boolean q;
    public String r;
    public Boolean s;
    public long t;
    public ArrayList u;
    public String v;
    public long w;
    public long x;
    public long y;
    public long z;

    public C1275pS2(C1391rR2 c1391rR2, String str) {
        Preconditions.checkNotNull(c1391rR2);
        Preconditions.checkNotEmpty(str);
        this.a = c1391rR2;
        this.b = str;
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
    }

    public final void A(List list) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        if (JQ2.a(this.u, list)) {
            return;
        }
        this.D = true;
        this.u = list != null ? new ArrayList(list) : null;
    }

    public final boolean B() {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        return this.q;
    }

    public final long C() {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        return this.k;
    }

    public final long D() {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        return this.t;
    }

    public final String E() {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        return this.r;
    }

    public final String F() {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        String str = this.C;
        u(null);
        return str;
    }

    public final String G() {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        return this.b;
    }

    public final String H() {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        return this.c;
    }

    public final String I() {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        return this.j;
    }

    public final String J() {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        return this.f;
    }

    public final String K() {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        return this.d;
    }

    public final void a() {
        C1391rR2 c1391rR2 = this.a;
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        long j = this.g + 1;
        if (j > 2147483647L) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.i.b(WO2.n(this.b), "Bundle index overflow. appId");
            j = 0;
        }
        this.D = true;
        this.g = j;
    }

    public final void b(String str) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.D |= true ^ JQ2.a(this.r, str);
        this.r = str;
    }

    public final void c(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.p != j;
        this.p = j;
    }

    public final void d(String str) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= !JQ2.a(this.c, str);
        this.c = str;
    }

    public final void e(String str) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= !JQ2.a(this.l, str);
        this.l = str;
    }

    public final void f(String str) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= !JQ2.a(this.j, str);
        this.j = str;
    }

    public final void g(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.k != j;
        this.k = j;
    }

    public final void h(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.E != j;
        this.E = j;
    }

    public final void i(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.z != j;
        this.z = j;
    }

    public final void j(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.A != j;
        this.A = j;
    }

    public final void k(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.y != j;
        this.y = j;
    }

    public final void l(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.x != j;
        this.x = j;
    }

    public final void m(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.B != j;
        this.B = j;
    }

    public final void n(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.w != j;
        this.w = j;
    }

    public final void o(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.n != j;
        this.n = j;
    }

    public final void p(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.t != j;
        this.t = j;
    }

    public final void q(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.F != j;
        this.F = j;
    }

    public final void r(String str) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= !JQ2.a(this.f, str);
        this.f = str;
    }

    public final void s(String str) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.D |= true ^ JQ2.a(this.d, str);
        this.d = str;
    }

    public final void t(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.m != j;
        this.m = j;
    }

    public final void u(String str) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= !JQ2.a(this.C, str);
        this.C = str;
    }

    public final void v(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.i != j;
        this.i = j;
    }

    public final void w(long j) {
        Preconditions.checkArgument(j >= 0);
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.g != j;
        this.g = j;
    }

    public final void x(long j) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.h != j;
        this.h = j;
    }

    public final void y(boolean z) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= this.o != z;
        this.o = z;
    }

    public final void z(String str) {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        this.D |= !JQ2.a(this.e, str);
        this.e = str;
    }
}
