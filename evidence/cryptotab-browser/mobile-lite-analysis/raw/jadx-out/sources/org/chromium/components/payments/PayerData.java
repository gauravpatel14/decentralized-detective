package org.chromium.components.payments;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class PayerData {
    public final String a;
    public final String b;
    public final String c;
    public final Address d;
    public final String e;

    public PayerData(String str, String str2, String str3, Address address, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = address;
        this.e = str4;
    }

    public PayerData() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }
}
