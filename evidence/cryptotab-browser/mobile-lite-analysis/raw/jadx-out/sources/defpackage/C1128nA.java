package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.List;
import org.chromium.base.TraceEvent;
import org.chromium.base.process_launcher.FileDescriptorInfo;

/* JADX INFO: renamed from: nA, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1128nA {
    public final AbstractC1067mA a;
    public final String[] b;
    public final FileDescriptorInfo[] c;
    public final Mz d;
    public final List e;
    public final IBinder f;
    public volatile C0619fA g;

    public C1128nA(Handler handler, AbstractC1067mA abstractC1067mA, String[] strArr, FileDescriptorInfo[] fileDescriptorInfoArr, Mz mz, List list, IBinder iBinder) {
        handler.getLooper();
        Looper.myLooper();
        this.b = strArr;
        this.d = mz;
        this.a = abstractC1067mA;
        this.c = fileDescriptorInfoArr;
        this.e = list;
        this.f = iBinder;
    }

    public final boolean a(final C1005lA c1005lA) {
        Runnable runnable;
        Bundle bundle = new Bundle();
        this.a.b(bundle);
        Mz mz = this.d;
        Context context = AbstractC1499tM.a;
        mz.getClass();
        this.g = mz.c(context, bundle, new Iz(mz, c1005lA));
        if (this.g != null) {
            b();
            return true;
        }
        Mz mz2 = this.d;
        Runnable runnable2 = new Runnable() { // from class: kA
            @Override // java.lang.Runnable
            public final void run() {
                this.t.a(c1005lA);
            }
        };
        ArrayDeque arrayDeque = mz2.b;
        boolean zIsEmpty = arrayDeque.isEmpty();
        arrayDeque.add(runnable2);
        if (!zIsEmpty || (runnable = mz2.a) == null) {
            return false;
        }
        runnable.run();
        return false;
    }

    public final void b() {
        C1005lA c1005lA = new C1005lA(this);
        C1005lA c1005lA2 = new C1005lA(this);
        Bundle bundle = new Bundle();
        bundle.putStringArray("org.chromium.base.process_launcher.extra.command_line", this.b);
        bundle.putParcelableArray("org.chromium.base.process_launcher.extra.extraFiles", this.c);
        this.a.c(bundle);
        C0619fA c0619fA = this.g;
        List list = this.e;
        IBinder iBinder = this.f;
        if (c0619fA.m) {
            Log.w("cr_ChildProcessConn", "Tried to setup a connection that already disconnected.");
            c1005lA2.c();
            return;
        }
        TraceEvent traceEventJ = TraceEvent.j("ChildProcessConnection.setupConnection", null);
        try {
            c0619fA.h = c1005lA2;
            c0619fA.i = c1005lA;
            c0619fA.g = new C0510dA(bundle, list, iBinder);
            if (c0619fA.l) {
                c0619fA.f();
            }
            if (traceEventJ != null) {
                traceEventJ.close();
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
