package org.chromium.base;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Token extends TokenBase {
    public Token(long j, long j2) {
        super(j, j2);
    }

    public final String toString() {
        return String.format("%016X%016X", Long.valueOf(this.t), Long.valueOf(this.u));
    }
}
