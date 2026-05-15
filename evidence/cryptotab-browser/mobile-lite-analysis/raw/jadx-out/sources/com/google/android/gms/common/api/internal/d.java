package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import defpackage.AbstractRunnableC0253Uy2;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends AbstractRunnableC0253Uy2 {
    public final ArrayList u;
    public final /* synthetic */ zaaw v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(zaaw zaawVar, ArrayList arrayList) {
        super(zaawVar);
        this.v = zaawVar;
        this.u = arrayList;
    }

    @Override // defpackage.AbstractRunnableC0253Uy2
    public final void a() {
        zaaw zaawVar = this.v;
        zaawVar.zaa.zag.zad = zaaw.zao(zaawVar);
        ArrayList arrayList = this.u;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Api.Client) arrayList.get(i)).getRemoteService(zaawVar.zao, zaawVar.zaa.zag.zad);
        }
    }
}
