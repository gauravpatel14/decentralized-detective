package org.chromium.cc.input;

import org.chromium.base.Token;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OffsetTag {
    public final Token a;

    public OffsetTag(Token token) {
        this.a = token;
    }

    public Token getToken() {
        return this.a;
    }

    public final String toString() {
        return this.a.toString();
    }
}
