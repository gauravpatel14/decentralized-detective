package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import defpackage.C0488cf0;
import defpackage.InterfaceC1390rR1;
import defpackage.KF2;
import defpackage.TE0;
import defpackage.TH;
import defpackage.TW;
import defpackage.UH;
import defpackage.m7;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@Keep
@KeepForSdk
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    @KeepForSdk
    @SuppressLint({"MissingPermission"})
    public List getComponents() {
        TH thA = UH.a(m7.class);
        thA.a(new TW(1, 0, C0488cf0.class));
        thA.a(new TW(1, 0, Context.class));
        thA.a(new TW(1, 0, InterfaceC1390rR1.class));
        thA.e = KF2.a;
        thA.c(2);
        return Arrays.asList(thA.b(), TE0.a("fire-analytics", "21.0.0"));
    }
}
