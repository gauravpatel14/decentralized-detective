package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import defpackage.C0324Zy2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Common {

    @KeepForSdk
    public static final Api API;

    @KeepForSdk
    public static final Api.ClientKey CLIENT_KEY;
    public static final zae zaa;
    private static final Api.AbstractClientBuilder zab;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        CLIENT_KEY = clientKey;
        C0324Zy2 c0324Zy2 = new C0324Zy2();
        zab = c0324Zy2;
        API = new Api("Common.API", c0324Zy2, clientKey);
        zaa = new zae();
    }
}
