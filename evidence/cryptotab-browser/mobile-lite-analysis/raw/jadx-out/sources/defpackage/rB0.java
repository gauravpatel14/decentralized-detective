package defpackage;

import android.util.Log;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class rB0 extends AbstractC1701wu1 {
    public final Object H;
    public nv1 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f35J;

    public rB0(int i, String str, String str2, nv1 nv1Var, mv1 mv1Var) {
        super(i, str, mv1Var);
        this.H = new Object();
        this.I = nv1Var;
        this.f35J = str2;
    }

    @Override // defpackage.AbstractC1701wu1
    public final void a() {
        super.a();
        synchronized (this.H) {
            this.I = null;
        }
    }

    @Override // defpackage.AbstractC1701wu1
    public final void b(Object obj) {
        nv1 nv1Var;
        synchronized (this.H) {
            nv1Var = this.I;
        }
        if (nv1Var != null) {
            nv1Var.a(obj);
        }
    }

    @Override // defpackage.AbstractC1701wu1
    public final byte[] d() {
        String str = this.f35J;
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            Log.wtf("Volley", AbstractC1583uq2.a("Unsupported Encoding while trying to get the bytes of %s using %s", str, "utf-8"));
            return null;
        }
    }

    @Override // defpackage.AbstractC1701wu1
    public final String e() {
        return "application/json; charset=utf-8";
    }
}
