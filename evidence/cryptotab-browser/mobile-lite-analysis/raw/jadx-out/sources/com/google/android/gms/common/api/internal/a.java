package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.GA2;
import defpackage.KA2;
import defpackage.NA2;
import defpackage.OA2;
import defpackage.df;
import defpackage.gf;
import defpackage.wA2;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements zaca {
    public final Api.Client A;
    public Bundle B;
    public final Lock F;
    public final Context t;
    public final zabe u;
    public final Looper v;
    public final zabi w;
    public final zabi x;
    public final Map y;
    public final Set z = Collections.newSetFromMap(new WeakHashMap());
    public ConnectionResult C = null;
    public ConnectionResult D = null;
    public boolean E = false;
    public int G = 0;

    public a(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, gf gfVar, gf gfVar2, ClientSettings clientSettings, Api.AbstractClientBuilder abstractClientBuilder, Api.Client client, ArrayList arrayList, ArrayList arrayList2, gf gfVar3, gf gfVar4) {
        this.t = context;
        this.u = zabeVar;
        this.F = lock;
        this.v = looper;
        this.A = client;
        this.w = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, gfVar2, null, gfVar4, null, arrayList2, new NA2(this));
        this.x = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, gfVar, clientSettings, gfVar3, abstractClientBuilder, arrayList, new OA2(this));
        gf gfVar5 = new gf(0);
        Iterator it = ((df) gfVar2.keySet()).iterator();
        while (it.hasNext()) {
            gfVar5.put((Api.AnyClientKey) it.next(), this.w);
        }
        Iterator it2 = ((df) gfVar.keySet()).iterator();
        while (it2.hasNext()) {
            gfVar5.put((Api.AnyClientKey) it2.next(), this.x);
        }
        this.y = Collections.unmodifiableMap(gfVar5);
    }

    public static void d(a aVar) {
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        ConnectionResult connectionResult3 = aVar.C;
        boolean z = connectionResult3 != null && connectionResult3.isSuccess();
        zabi zabiVar = aVar.w;
        if (!z) {
            ConnectionResult connectionResult4 = aVar.C;
            zabi zabiVar2 = aVar.x;
            if (connectionResult4 != null && (connectionResult2 = aVar.D) != null && connectionResult2.isSuccess()) {
                zabiVar2.zar();
                aVar.a((ConnectionResult) Preconditions.checkNotNull(aVar.C));
                return;
            }
            ConnectionResult connectionResult5 = aVar.C;
            if (connectionResult5 == null || (connectionResult = aVar.D) == null) {
                return;
            }
            if (zabiVar2.zaf < zabiVar.zaf) {
                connectionResult5 = connectionResult;
            }
            aVar.a(connectionResult5);
            return;
        }
        ConnectionResult connectionResult6 = aVar.D;
        if ((connectionResult6 != null && connectionResult6.isSuccess()) || aVar.c()) {
            int i = aVar.G;
            if (i == 1) {
                aVar.b();
            } else if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
            } else {
                ((zabe) Preconditions.checkNotNull(aVar.u)).zab(aVar.B);
                aVar.b();
            }
            aVar.G = 0;
            return;
        }
        ConnectionResult connectionResult7 = aVar.D;
        if (connectionResult7 != null) {
            if (aVar.G == 1) {
                aVar.b();
            } else {
                aVar.a(connectionResult7);
                zabiVar.zar();
            }
        }
    }

    public final void a(ConnectionResult connectionResult) {
        int i = this.G;
        if (i == 1) {
            b();
        } else if (i != 2) {
            Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        } else {
            this.u.zaa(connectionResult);
            b();
        }
        this.G = 0;
    }

    public final void b() {
        Set set = this.z;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((SignInConnectionListener) it.next()).onComplete();
        }
        set.clear();
    }

    public final boolean c() {
        ConnectionResult connectionResult = this.D;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    public final PendingIntent e() {
        Api.Client client = this.A;
        if (client == null) {
            return null;
        }
        return PendingIntent.getActivity(this.t, System.identityHashCode(this.u), client.getSignInIntent(), wA2.a | 134217728);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zab() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zac(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zad(Api api) {
        Object obj = this.y.get(api.zab());
        zabi zabiVar = this.x;
        return Objects.equal(obj, zabiVar) ? c() ? new ConnectionResult(4, e()) : zabiVar.zad(api) : this.w.zad(api);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl zae(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabiVar = (zabi) this.y.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zabiVar, "GoogleApiClient is not configured to use the API required for this call.");
        zabi zabiVar2 = this.x;
        if (!zabiVar.equals(zabiVar2)) {
            this.w.zae(apiMethodImpl);
            return apiMethodImpl;
        }
        if (c()) {
            apiMethodImpl.setFailedResult(new Status(4, (String) null, e()));
            return apiMethodImpl;
        }
        zabiVar2.zae(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl zaf(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabiVar = (zabi) this.y.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zabiVar, "GoogleApiClient is not configured to use the API required for this call.");
        zabi zabiVar2 = this.x;
        if (!zabiVar.equals(zabiVar2)) {
            return this.w.zaf(apiMethodImpl);
        }
        if (!c()) {
            return zabiVar2.zaf(apiMethodImpl);
        }
        apiMethodImpl.setFailedResult(new Status(4, (String) null, e()));
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zaq() {
        this.G = 2;
        this.E = false;
        this.D = null;
        this.C = null;
        this.w.zaq();
        this.x.zaq();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zar() {
        this.D = null;
        this.C = null;
        this.G = 0;
        this.w.zar();
        this.x.zar();
        b();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zas(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.x.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.w.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zat() {
        this.w.zat();
        this.x.zat();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zau() {
        Lock lock = this.F;
        lock.lock();
        try {
            boolean zZax = zax();
            this.x.zar();
            this.D = new ConnectionResult(4);
            if (zZax) {
                new GA2(this.v).post(new KA2(this));
            } else {
                b();
            }
            lock.unlock();
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    @Override // com.google.android.gms.common.api.internal.zaca
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zaw() {
        /*
            r4 = this;
            java.util.concurrent.locks.Lock r0 = r4.F
            r0.lock()
            com.google.android.gms.common.api.internal.zabi r1 = r4.w     // Catch: java.lang.Throwable -> L23
            boolean r1 = r1.zaw()     // Catch: java.lang.Throwable -> L23
            r2 = 0
            if (r1 == 0) goto L25
            com.google.android.gms.common.api.internal.zabi r1 = r4.x     // Catch: java.lang.Throwable -> L23
            boolean r1 = r1.zaw()     // Catch: java.lang.Throwable -> L23
            r3 = 1
            if (r1 != 0) goto L21
            boolean r1 = r4.c()     // Catch: java.lang.Throwable -> L23
            if (r1 != 0) goto L21
            int r1 = r4.G     // Catch: java.lang.Throwable -> L23
            if (r1 != r3) goto L25
        L21:
            r2 = r3
            goto L25
        L23:
            r1 = move-exception
            goto L29
        L25:
            r0.unlock()
            return r2
        L29:
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.a.zaw():boolean");
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zax() {
        Lock lock = this.F;
        lock.lock();
        try {
            return this.G == 2;
        } finally {
            lock.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        zabi zabiVar = this.x;
        Lock lock = this.F;
        lock.lock();
        try {
            boolean z = false;
            if (zax() || zaw()) {
                if (!zabiVar.zaw()) {
                    this.z.add(signInConnectionListener);
                    z = true;
                    if (this.G == 0) {
                        this.G = 1;
                    }
                    this.D = null;
                    zabiVar.zaq();
                }
            }
            lock.unlock();
            return z;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }
}
