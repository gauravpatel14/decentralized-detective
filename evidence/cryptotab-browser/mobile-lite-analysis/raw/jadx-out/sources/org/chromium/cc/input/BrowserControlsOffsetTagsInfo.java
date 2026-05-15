package org.chromium.cc.input;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BrowserControlsOffsetTagsInfo {
    public final OffsetTag a;
    public int b;

    public BrowserControlsOffsetTagsInfo(OffsetTag offsetTag) {
        this.a = offsetTag;
    }

    public int getTopControlsHeight() {
        return this.b;
    }

    public OffsetTag getTopControlsOffsetTag() {
        return this.a;
    }
}
