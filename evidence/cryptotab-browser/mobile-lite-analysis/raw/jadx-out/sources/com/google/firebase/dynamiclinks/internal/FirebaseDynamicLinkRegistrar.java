package com.google.firebase.dynamiclinks.internal;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import defpackage.C0488cf0;
import defpackage.C0597ef0;
import defpackage.C0793hf0;
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
public final class FirebaseDynamicLinkRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List getComponents() {
        TH thA = UH.a(C0793hf0.class);
        thA.a(new TW(1, 0, C0488cf0.class));
        thA.a(new TW(0, 1, m7.class));
        thA.e = new C0597ef0();
        return Arrays.asList(thA.b());
    }
}
