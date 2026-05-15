package org.chromium.net;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AndroidCertVerifyResult {
    public final int a;
    public final boolean b;
    public final List c;

    public AndroidCertVerifyResult(List list, boolean z) {
        this.a = 0;
        this.b = z;
        this.c = new ArrayList(list);
    }

    public byte[][] getCertificateChainEncoded() {
        List list = this.c;
        byte[][] bArr = new byte[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            try {
                bArr[i] = ((X509Certificate) list.get(i)).getEncoded();
            } catch (CertificateEncodingException unused) {
                return new byte[0][];
            }
        }
        return bArr;
    }

    public int getStatus() {
        return this.a;
    }

    public boolean isIssuedByKnownRoot() {
        return this.b;
    }

    public AndroidCertVerifyResult(int i) {
        this.a = i;
        this.b = false;
        this.c = Collections.emptyList();
    }
}
