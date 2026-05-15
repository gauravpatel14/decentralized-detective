package org.chromium.net;

import java.net.InetAddress;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class DnsStatus {
    public final List a;
    public final boolean b;
    public final String c;
    public final String d;

    public DnsStatus(List list, boolean z, String str, String str2) {
        this.a = list;
        this.b = z;
        this.c = str == null ? "" : str;
        this.d = str2 == null ? "" : str2;
    }

    public byte[][] getDnsServers() {
        List list = this.a;
        byte[][] bArr = new byte[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            bArr[i] = ((InetAddress) list.get(i)).getAddress();
        }
        return bArr;
    }

    public boolean getPrivateDnsActive() {
        return this.b;
    }

    public String getPrivateDnsServerName() {
        return this.c;
    }

    public String getSearchDomains() {
        return this.d;
    }
}
