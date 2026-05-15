package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.n;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import defpackage.C0116Jz2;
import defpackage.C0218Rz2;
import defpackage.C0298Xz2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zag implements DialogInterface.OnClickListener {
    public static zag zab(Activity activity, Intent intent, int i) {
        return new C0116Jz2(activity, intent, i);
    }

    public static zag zac(n nVar, Intent intent, int i) {
        return new C0218Rz2(nVar, intent, i);
    }

    public static zag zad(LifecycleFragment lifecycleFragment, Intent intent, int i) {
        return new C0298Xz2(intent, lifecycleFragment);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            try {
                zaa();
            } catch (ActivityNotFoundException e) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }

    public abstract void zaa();
}
