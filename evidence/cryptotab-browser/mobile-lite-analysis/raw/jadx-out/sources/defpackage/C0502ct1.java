package defpackage;

import android.os.Bundle;

/* JADX INFO: renamed from: ct1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0502ct1 extends UO0 implements Ys1 {
    public final String f;
    public boolean g;
    public int i;
    public Xs1 j;
    public final /* synthetic */ ServiceConnectionC0608et1 l;
    public int h = -1;
    public int k = -1;

    public C0502ct1(ServiceConnectionC0608et1 serviceConnectionC0608et1, String str) {
        this.l = serviceConnectionC0608et1;
        this.f = str;
    }

    @Override // defpackage.Ys1
    public final int a() {
        return this.k;
    }

    @Override // defpackage.Ys1
    public final void b(Xs1 xs1) {
        bt1 bt1Var = new bt1(this);
        this.j = xs1;
        int i = xs1.e;
        xs1.e = i + 1;
        int i2 = xs1.d;
        xs1.d = i2 + 1;
        Bundle bundle = new Bundle();
        bundle.putString("memberRouteId", this.f);
        xs1.b(11, i2, i, null, bundle);
        xs1.h.put(i2, bt1Var);
        this.k = i;
        if (this.g) {
            xs1.a(i);
            int i3 = this.h;
            if (i3 >= 0) {
                xs1.c(this.k, i3);
                this.h = -1;
            }
            int i4 = this.i;
            if (i4 != 0) {
                xs1.d(this.k, i4);
                this.i = 0;
            }
        }
    }

    @Override // defpackage.Ys1
    public final void c() {
        Xs1 xs1 = this.j;
        if (xs1 != null) {
            int i = this.k;
            int i2 = xs1.d;
            xs1.d = i2 + 1;
            xs1.b(4, i2, i, null, null);
            this.j = null;
            this.k = 0;
        }
    }

    @Override // defpackage.XO0
    public final void d() {
        ServiceConnectionC0608et1 serviceConnectionC0608et1 = this.l;
        serviceConnectionC0608et1.D.remove(this);
        c();
        serviceConnectionC0608et1.k();
    }

    @Override // defpackage.XO0
    public final void e() {
        this.g = true;
        Xs1 xs1 = this.j;
        if (xs1 != null) {
            xs1.a(this.k);
        }
    }

    @Override // defpackage.XO0
    public final void f(int i) {
        Xs1 xs1 = this.j;
        if (xs1 != null) {
            xs1.c(this.k, i);
        } else {
            this.h = i;
            this.i = 0;
        }
    }

    @Override // defpackage.XO0
    public final void g() {
        h(0);
    }

    @Override // defpackage.XO0
    public final void h(int i) {
        this.g = false;
        Xs1 xs1 = this.j;
        if (xs1 != null) {
            int i2 = this.k;
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", i);
            int i3 = xs1.d;
            xs1.d = i3 + 1;
            xs1.b(6, i3, i2, null, bundle);
        }
    }

    @Override // defpackage.XO0
    public final void i(int i) {
        Xs1 xs1 = this.j;
        if (xs1 != null) {
            xs1.d(this.k, i);
        } else {
            this.i += i;
        }
    }
}
