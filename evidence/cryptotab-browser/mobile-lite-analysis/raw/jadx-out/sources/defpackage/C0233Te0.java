package defpackage;

import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: renamed from: Te0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0233Te0 {
    public final Signature a;
    public final Cipher b;
    public final Mac c;

    public C0233Te0(Signature signature) {
        this.a = signature;
        this.b = null;
        this.c = null;
    }

    public C0233Te0(Cipher cipher) {
        this.b = cipher;
        this.a = null;
        this.c = null;
    }

    public C0233Te0(Mac mac) {
        this.c = mac;
        this.b = null;
        this.a = null;
    }
}
