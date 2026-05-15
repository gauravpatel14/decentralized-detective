package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.iid.FirebaseInstanceId;
import defpackage.C0488cf0;
import defpackage.C1680wW;
import defpackage.C1797yf0;
import defpackage.InterfaceC1390rR1;
import defpackage.Ln0;
import defpackage.TE0;
import defpackage.TH;
import defpackage.TW;
import defpackage.UH;
import defpackage.of0;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@Keep
@KeepForSdk
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List getComponents() {
        TH thA = UH.a(FirebaseMessaging.class);
        thA.a(new TW(1, 0, C0488cf0.class));
        thA.a(new TW(1, 0, FirebaseInstanceId.class));
        thA.a(new TW(0, 1, C1680wW.class));
        thA.a(new TW(0, 1, Ln0.class));
        thA.a(new TW(0, 0, TransportFactory.class));
        thA.a(new TW(1, 0, of0.class));
        thA.a(new TW(1, 0, InterfaceC1390rR1.class));
        thA.e = C1797yf0.a;
        thA.c(1);
        return Arrays.asList(thA.b(), TE0.a("fire-fcm", "20.1.7_1p"));
    }
}
