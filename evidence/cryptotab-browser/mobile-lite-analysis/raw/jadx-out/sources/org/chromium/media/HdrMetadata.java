package org.chromium.media;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class HdrMetadata {
    public long a;
    public final Object b = new Object();

    public HdrMetadata(long j) {
        this.a = j;
    }

    public static HdrMetadata create(long j) {
        return new HdrMetadata(j);
    }

    public final void close() {
        synchronized (this.b) {
            this.a = 0L;
        }
    }
}
