package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.AN2;
import defpackage.IJ2;
import defpackage.KU2;
import defpackage.NB2;
import defpackage.Y62;
import defpackage.jI2;
import defpackage.nf0;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FirebaseAnalytics {
    public static volatile FirebaseAnalytics c;
    public final AN2 a;
    public NB2 b;

    public FirebaseAnalytics(AN2 an2) {
        Preconditions.checkNotNull(an2);
        this.a = an2;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (c == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (c == null) {
                        c = new FirebaseAnalytics(AN2.c(context, null));
                    }
                } finally {
                }
            }
        }
        return c;
    }

    @Keep
    public static KU2 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        AN2 an2C = AN2.c(context, bundle);
        if (an2C == null) {
            return null;
        }
        return new jI2(an2C);
    }

    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String) Y62.b(nf0.d().c(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        } catch (ExecutionException e2) {
            throw new IllegalStateException(e2.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @Deprecated
    public void setCurrentScreen(Activity activity, String str, String str2) {
        AN2 an2 = this.a;
        an2.getClass();
        an2.b(new IJ2(an2, activity, str, str2));
    }
}
