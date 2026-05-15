package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import defpackage.C0488cf0;
import defpackage.C1287pf0;
import defpackage.Jn0;
import defpackage.Kn0;
import defpackage.SH;
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
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        TH thA = UH.a(of0.class);
        thA.a(new TW(1, 0, C0488cf0.class));
        thA.a(new TW(0, 1, Kn0.class));
        thA.e = new C1287pf0();
        UH uhB = thA.b();
        Jn0 jn0 = new Jn0();
        TH thA2 = UH.a(Jn0.class);
        thA2.d = 1;
        thA2.e = new SH(jn0);
        return Arrays.asList(uhB, thA2.b(), TE0.a("fire-installations", "17.0.1"));
    }
}
