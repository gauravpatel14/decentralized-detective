package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import defpackage.AbstractC0098Hz2;
import defpackage.H62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zah extends AbstractC0098Hz2 {
    public final ListenerHolder.ListenerKey zab;

    public zah(ListenerHolder.ListenerKey listenerKey, H62 h62) {
        super(4, h62);
        this.zab = listenerKey;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq zabqVar) {
        zaci zaciVar = (zaci) zabqVar.zah().get(this.zab);
        return zaciVar != null && zaciVar.zaa.zab();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabq zabqVar) {
        zaci zaciVar = (zaci) zabqVar.zah().get(this.zab);
        if (zaciVar == null) {
            return null;
        }
        return zaciVar.zaa.getRequiredFeatures();
    }

    @Override // defpackage.AbstractC0098Hz2
    public final void zac(zabq zabqVar) {
        zaci zaciVar = (zaci) zabqVar.zah().remove(this.zab);
        if (zaciVar == null) {
            this.zaa.d(Boolean.FALSE);
            return;
        }
        zaciVar.zab.unregisterListener(zabqVar.zaf(), this.zaa);
        zaciVar.zaa.clearListener();
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void zag(zaad zaadVar, boolean z) {
    }
}
