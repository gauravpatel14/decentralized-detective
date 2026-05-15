package defpackage;

import android.os.Bundle;

/* JADX INFO: renamed from: dt1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0549dt1 extends XO0 implements Ys1 {
    public final String a;
    public final String b;
    public boolean c;
    public int d = -1;
    public int e;
    public Xs1 f;
    public int g;
    public final /* synthetic */ ServiceConnectionC0608et1 h;

    public C0549dt1(ServiceConnectionC0608et1 serviceConnectionC0608et1, String str, String str2) {
        this.h = serviceConnectionC0608et1;
        this.a = str;
        this.b = str2;
    }

    @Override // defpackage.Ys1
    public final int a() {
        return this.g;
    }

    @Override // defpackage.Ys1
    public final void b(Xs1 xs1) {
        this.f = xs1;
        int i = xs1.e;
        xs1.e = i + 1;
        Bundle bundle = new Bundle();
        bundle.putString("routeId", this.a);
        bundle.putString("routeGroupId", this.b);
        int i2 = xs1.d;
        xs1.d = i2 + 1;
        xs1.b(3, i2, i, null, bundle);
        this.g = i;
        if (this.c) {
            xs1.a(i);
            int i3 = this.d;
            if (i3 >= 0) {
                xs1.c(this.g, i3);
                this.d = -1;
            }
            int i4 = this.e;
            if (i4 != 0) {
                xs1.d(this.g, i4);
                this.e = 0;
            }
        }
    }

    @Override // defpackage.Ys1
    public final void c() {
        Xs1 xs1 = this.f;
        if (xs1 != null) {
            int i = this.g;
            int i2 = xs1.d;
            xs1.d = i2 + 1;
            xs1.b(4, i2, i, null, null);
            this.f = null;
            this.g = 0;
        }
    }

    @Override // defpackage.XO0
    public final void d() {
        ServiceConnectionC0608et1 serviceConnectionC0608et1 = this.h;
        serviceConnectionC0608et1.D.remove(this);
        c();
        serviceConnectionC0608et1.k();
    }

    @Override // defpackage.XO0
    public final void e() {
        this.c = true;
        Xs1 xs1 = this.f;
        if (xs1 != null) {
            xs1.a(this.g);
        }
    }

    @Override // defpackage.XO0
    public final void f(int i) {
        Xs1 xs1 = this.f;
        if (xs1 != null) {
            xs1.c(this.g, i);
        } else {
            this.d = i;
            this.e = 0;
        }
    }

    @Override // defpackage.XO0
    public final void g() {
        h(0);
    }

    @Override // defpackage.XO0
    public final void h(int i) {
        this.c = false;
        Xs1 xs1 = this.f;
        if (xs1 != null) {
            int i2 = this.g;
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", i);
            int i3 = xs1.d;
            xs1.d = i3 + 1;
            xs1.b(6, i3, i2, null, bundle);
        }
    }

    @Override // defpackage.XO0
    public final void i(int i) {
        Xs1 xs1 = this.f;
        if (xs1 != null) {
            xs1.d(this.g, i);
        } else {
            this.e += i;
        }
    }
}
