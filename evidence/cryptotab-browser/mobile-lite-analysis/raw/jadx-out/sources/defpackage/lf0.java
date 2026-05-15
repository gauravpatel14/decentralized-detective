package defpackage;

import com.google.firebase.installations.FirebaseInstallationsException;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lf0 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ nf0 u;

    public /* synthetic */ lf0(nf0 nf0Var, int i) {
        this.t = i;
        this.u = nf0Var;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        C1631vi c1631viC;
        C1631vi c1631viB;
        switch (this.t) {
            case 0:
                this.u.a();
                return;
            case 1:
                this.u.a();
                return;
            default:
                nf0 nf0Var = this.u;
                nf0Var.getClass();
                Object obj = nf0.m;
                synchronized (obj) {
                    try {
                        C0488cf0 c0488cf0 = nf0Var.a;
                        c0488cf0.a();
                        WP wpA = WP.a(c0488cf0.a);
                        try {
                            c1631viC = nf0Var.c.c();
                            if (wpA != null) {
                                wpA.b();
                            }
                        } catch (Throwable th) {
                            if (wpA != null) {
                                wpA.b();
                            }
                            throw th;
                        }
                    } finally {
                    }
                }
                try {
                    int i = c1631viC.b;
                    if (i == 5 || i == 3) {
                        c1631viB = nf0Var.h(c1631viC);
                    } else if (!nf0Var.d.a(c1631viC)) {
                        return;
                    } else {
                        c1631viB = nf0Var.b(c1631viC);
                    }
                    synchronized (obj) {
                        try {
                            C0488cf0 c0488cf02 = nf0Var.a;
                            c0488cf02.a();
                            WP wpA2 = WP.a(c0488cf02.a);
                            try {
                                nf0Var.c.b(c1631viB);
                                if (wpA2 != null) {
                                    wpA2.b();
                                }
                            } catch (Throwable th2) {
                                if (wpA2 != null) {
                                    wpA2.b();
                                }
                                throw th2;
                            }
                        } finally {
                        }
                    }
                    synchronized (nf0Var) {
                        try {
                            if (nf0Var.k.size() != 0 && !c1631viC.a.equals(c1631viB.a)) {
                                Iterator it = nf0Var.k.iterator();
                                if (it.hasNext()) {
                                    if (it.next() != null) {
                                        throw new ClassCastException();
                                    }
                                    throw null;
                                }
                            }
                        } finally {
                        }
                    }
                    if (c1631viB.b == 4) {
                        String str = c1631viB.a;
                        synchronized (nf0Var) {
                            nf0Var.j = str;
                        }
                    }
                    int i2 = c1631viB.b;
                    if (i2 == 5) {
                        nf0Var.i(new FirebaseInstallationsException());
                        return;
                    } else if (i2 == 2 || i2 == 1) {
                        nf0Var.i(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                        return;
                    } else {
                        nf0Var.j(c1631viB);
                        return;
                    }
                } catch (FirebaseInstallationsException e) {
                    nf0Var.i(e);
                    return;
                }
        }
    }
}
