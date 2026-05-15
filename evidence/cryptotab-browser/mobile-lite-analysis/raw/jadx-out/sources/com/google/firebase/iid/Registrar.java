package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import defpackage.C0488cf0;
import defpackage.C0931jt1;
import defpackage.C1680wW;
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
public final class Registrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List getComponents() {
        TH thA = UH.a(FirebaseInstanceId.class);
        thA.a(new TW(1, 0, C0488cf0.class));
        thA.a(new TW(0, 1, C1680wW.class));
        thA.a(new TW(0, 1, Ln0.class));
        thA.a(new TW(1, 0, of0.class));
        thA.e = C0931jt1.b;
        thA.c(1);
        UH uhB = thA.b();
        TH thA2 = UH.a(C0931jt1.class);
        thA2.a(new TW(1, 0, FirebaseInstanceId.class));
        thA2.e = C0931jt1.c;
        return Arrays.asList(uhB, thA2.b(), TE0.a("fire-iid", "21.0.1"));
    }
}
