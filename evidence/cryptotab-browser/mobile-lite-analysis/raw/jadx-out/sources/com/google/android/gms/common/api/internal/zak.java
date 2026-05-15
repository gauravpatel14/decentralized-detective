package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.AbstractC1214oR1;
import defpackage.C1192oA2;
import defpackage.C1426sA2;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zak extends zap {
    private final SparseArray zad;

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.zad = new SparseArray();
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zak zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zak zakVar = (zak) fragment.getCallbackOrNull("AutoManageHelper", zak.class);
        return zakVar != null ? zakVar : new zak(fragment);
    }

    private final C1192oA2 zai(int i) {
        if (this.zad.size() <= i) {
            return null;
        }
        SparseArray sparseArray = this.zad;
        return (C1192oA2) sparseArray.get(sparseArray.keyAt(i));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.zad.size(); i++) {
            C1192oA2 c1192oA2Zai = zai(i);
            if (c1192oA2Zai != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(c1192oA2Zai.t);
                printWriter.println(":");
                c1192oA2Zai.u.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        SparseArray sparseArray = this.zad;
        boolean z = this.zaa;
        String strValueOf = String.valueOf(sparseArray);
        StringBuilder sb = new StringBuilder("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(strValueOf);
        if (this.zab.get() == null) {
            for (int i = 0; i < this.zad.size(); i++) {
                C1192oA2 c1192oA2Zai = zai(i);
                if (c1192oA2Zai != null) {
                    c1192oA2Zai.u.connect();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        for (int i = 0; i < this.zad.size(); i++) {
            C1192oA2 c1192oA2Zai = zai(i);
            if (c1192oA2Zai != null) {
                c1192oA2Zai.u.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zab(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        C1192oA2 c1192oA2 = (C1192oA2) this.zad.get(i);
        if (c1192oA2 != null) {
            zae(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = c1192oA2.v;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zac() {
        for (int i = 0; i < this.zad.size(); i++) {
            C1192oA2 c1192oA2Zai = zai(i);
            if (c1192oA2Zai != null) {
                c1192oA2Zai.u.connect();
            }
        }
    }

    public final void zad(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        int iIndexOfKey = this.zad.indexOfKey(i);
        Preconditions.checkState(iIndexOfKey < 0, AbstractC1214oR1.a(i, "Already managing a GoogleApiClient with id "));
        C1426sA2 c1426sA2 = (C1426sA2) this.zab.get();
        boolean z = this.zaa;
        String strValueOf = String.valueOf(c1426sA2);
        StringBuilder sb = new StringBuilder("starting AutoManage for client ");
        sb.append(i);
        sb.append(" ");
        sb.append(z);
        sb.append(" ");
        sb.append(strValueOf);
        C1192oA2 c1192oA2 = new C1192oA2(this, i, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(c1192oA2);
        this.zad.put(i, c1192oA2);
        if (this.zaa && c1426sA2 == null) {
            "connecting ".concat(googleApiClient.toString());
            googleApiClient.connect();
        }
    }

    public final void zae(int i) {
        C1192oA2 c1192oA2 = (C1192oA2) this.zad.get(i);
        this.zad.remove(i);
        if (c1192oA2 != null) {
            GoogleApiClient googleApiClient = c1192oA2.u;
            googleApiClient.unregisterConnectionFailedListener(c1192oA2);
            googleApiClient.disconnect();
        }
    }
}
