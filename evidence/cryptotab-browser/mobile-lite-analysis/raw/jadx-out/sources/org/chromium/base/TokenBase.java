package org.chromium.base;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TokenBase {
    public final long t;
    public final long u;

    public TokenBase(long j, long j2) {
        this.t = j;
        this.u = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        TokenBase tokenBase = (TokenBase) obj;
        return tokenBase.t == this.t && tokenBase.u == this.u;
    }

    public final long getHighForSerialization() {
        return this.t;
    }

    public final long getLowForSerialization() {
        return this.u;
    }

    public final int hashCode() {
        long j = this.u;
        long j2 = this.t;
        return (((int) (j ^ (j >>> 32))) * 31) + ((int) ((j2 >>> 32) ^ j2));
    }
}
