package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;

/* JADX INFO: renamed from: w23, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1651w23 {
    public final Context a;
    public final String c;
    public final String d;
    public final String e;
    public Object h;
    public final Object b = new Object();
    public boolean f = false;
    public boolean g = false;

    public AbstractC1651w23(Context context, String str, String str2) {
        this.a = context;
        this.c = str;
        this.d = str2.length() != 0 ? "com.google.android.gms.vision.dynamite.".concat(str2) : new String("com.google.android.gms.vision.dynamite.");
        this.e = str2;
    }

    public abstract Object a(m50 m50Var, Context context);

    public abstract void b();

    public final boolean c() {
        return e() != null;
    }

    public final void d() {
        synchronized (this.b) {
            if (this.h == null) {
                return;
            }
            try {
                b();
            } catch (RemoteException e) {
                Log.e(this.c, "Could not finalize native handle", e);
            }
        }
    }

    public final Object e() {
        m50 m50VarC;
        synchronized (this.b) {
            Object obj = this.h;
            if (obj != null) {
                return obj;
            }
            try {
                m50VarC = m50.c(this.a, m50.e, this.d);
            } catch (DynamiteModule$LoadingException unused) {
                String str = "com.google.android.gms.vision." + this.e;
                try {
                    m50VarC = m50.c(this.a, m50.b, str);
                } catch (DynamiteModule$LoadingException e) {
                    if (Log.isLoggable("Vision", 6)) {
                        String strConcat = "Error loading optional module ".concat(str);
                        String strValueOf = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + strConcat.length() + 2);
                        sb.append(strConcat);
                        sb.append(": ");
                        sb.append(strValueOf);
                        Log.e("Vision", sb.toString());
                    }
                    if (!this.f) {
                        String str2 = this.e;
                        Intent intent = new Intent();
                        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
                        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", str2);
                        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
                        this.a.sendBroadcast(intent);
                        this.f = true;
                    }
                    m50VarC = null;
                }
            }
            if (m50VarC != null) {
                try {
                    this.h = a(m50VarC, this.a);
                } catch (RemoteException | DynamiteModule$LoadingException e2) {
                    Log.e(this.c, "Error creating remote native handle", e2);
                }
            }
            boolean z = this.g;
            if (!z && this.h == null) {
                Log.w(this.c, "Native handle not yet available. Reverting to no-op handle.");
                this.g = true;
            } else if (z && this.h != null) {
                Log.w(this.c, "Native handle is now available.");
            }
            return this.h;
        }
    }
}
