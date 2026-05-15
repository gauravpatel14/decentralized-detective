package defpackage;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: renamed from: zB2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1821zB2 {
    u("RESPONSE_CODE_UNSPECIFIED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF18("SERVICE_TIMEOUT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF27("FEATURE_NOT_SUPPORTED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF36("SERVICE_DISCONNECTED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF44("OK"),
    /* JADX INFO: Fake field, exist only in values array */
    EF52("USER_CANCELED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF60("SERVICE_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF68("BILLING_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF77("ITEM_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF86("DEVELOPER_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF95("ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF104("ITEM_ALREADY_OWNED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF113("ITEM_NOT_OWNED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF126("EXPIRED_OFFER_TOKEN"),
    /* JADX INFO: Fake field, exist only in values array */
    EF139("NETWORK_ERROR");

    public static final PE2 v;
    public final int t;

    static {
        ND2 nd2 = new ND2();
        nd2.a = new Object[8];
        nd2.b = 0;
        for (EnumC1821zB2 enumC1821zB2 : values()) {
            Integer numValueOf = Integer.valueOf(enumC1821zB2.t);
            int i = nd2.b + 1;
            Object[] objArr = nd2.a;
            int length = objArr.length;
            int i2 = i + i;
            if (i2 > length) {
                int i3 = length + (length >> 1) + 1;
                if (i3 < i2) {
                    int iHighestOneBit = Integer.highestOneBit(i2 - 1);
                    i3 = iHighestOneBit + iHighestOneBit;
                }
                nd2.a = Arrays.copyOf(objArr, i3 < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i3);
            }
            Object[] objArr2 = nd2.a;
            int i4 = nd2.b;
            int i5 = i4 + i4;
            objArr2[i5] = numValueOf;
            objArr2[i5 + 1] = enumC1821zB2;
            nd2.b = i4 + 1;
        }
        HD2 hd2 = nd2.c;
        if (hd2 != null) {
            throw hd2.a();
        }
        PE2 pe2A = PE2.a(nd2.b, nd2.a, nd2);
        HD2 hd22 = nd2.c;
        if (hd22 != null) {
            throw hd22.a();
        }
        v = pe2A;
    }

    EnumC1821zB2(String str) {
        this.t = i;
    }
}
