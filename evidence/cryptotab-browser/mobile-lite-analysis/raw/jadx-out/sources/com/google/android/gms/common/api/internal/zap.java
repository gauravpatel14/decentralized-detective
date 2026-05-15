package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import defpackage.C1426sA2;
import defpackage.GA2;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean zaa;
    protected final AtomicReference zab;
    protected final GoogleApiAvailability zac;
    private final Handler zad;

    public zap(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zab = new AtomicReference(null);
        this.zad = new GA2(Looper.getMainLooper());
        this.zac = googleApiAvailability;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zaa(ConnectionResult connectionResult, int i) {
        this.zab.set(null);
        zab(connectionResult, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zad() {
        this.zab.set(null);
        zac();
    }

    private static final int zae(C1426sA2 c1426sA2) {
        if (c1426sA2 == null) {
            return -1;
        }
        return c1426sA2.a;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onActivityResult(int i, int i2, Intent intent) {
        C1426sA2 c1426sA2 = (C1426sA2) this.zab.get();
        if (i != 1) {
            if (i == 2) {
                int iIsGooglePlayServicesAvailable = this.zac.isGooglePlayServicesAvailable(getActivity());
                if (iIsGooglePlayServicesAvailable == 0) {
                    zad();
                    return;
                } else {
                    if (c1426sA2 == null) {
                        return;
                    }
                    if (c1426sA2.b.getErrorCode() == 18 && iIsGooglePlayServicesAvailable == 18) {
                        return;
                    }
                }
            }
        } else if (i2 == -1) {
            zad();
            return;
        } else if (i2 == 0) {
            if (c1426sA2 != null) {
                zaa(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, c1426sA2.b.toString()), zae(c1426sA2));
                return;
            }
            return;
        }
        if (c1426sA2 != null) {
            zaa(c1426sA2.b, c1426sA2.a);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        zaa(new ConnectionResult(13, null), zae((C1426sA2) this.zab.get()));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zab.set(bundle.getBoolean("resolving_error", false) ? new C1426sA2(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C1426sA2 c1426sA2 = (C1426sA2) this.zab.get();
        if (c1426sA2 == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", c1426sA2.a);
        ConnectionResult connectionResult = c1426sA2.b;
        bundle.putInt("failed_status", connectionResult.getErrorCode());
        bundle.putParcelable("failed_resolution", connectionResult.getResolution());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.zaa = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.zaa = false;
    }

    public abstract void zab(ConnectionResult connectionResult, int i);

    public abstract void zac();

    public final void zah(ConnectionResult connectionResult, int i) {
        AtomicReference atomicReference;
        C1426sA2 c1426sA2 = new C1426sA2(connectionResult, i);
        do {
            atomicReference = this.zab;
            while (!atomicReference.compareAndSet(null, c1426sA2)) {
                if (atomicReference.get() != null) {
                }
            }
            this.zad.post(new g(this, c1426sA2));
            return;
        } while (atomicReference.get() == null);
    }
}
