package org.chromium.content_public.common;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ResourceRequestBody {
    public byte[] a;

    public static ResourceRequestBody createFromEncodedNativeForm(byte[] bArr) {
        ResourceRequestBody resourceRequestBody = new ResourceRequestBody();
        resourceRequestBody.a = bArr;
        return resourceRequestBody;
    }

    public byte[] getEncodedNativeForm() {
        return this.a;
    }
}
