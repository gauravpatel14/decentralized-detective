package defpackage;

import java.util.Iterator;

/* JADX INFO: renamed from: kg2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0982kg2 implements DE1 {
    public final DE1 a;
    public final RC0 b;

    /* JADX WARN: Multi-variable type inference failed */
    public C0982kg2(DE1 de1, InterfaceC0926jk0 interfaceC0926jk0) {
        this.a = de1;
        this.b = (RC0) interfaceC0926jk0;
    }

    @Override // defpackage.DE1
    public final Iterator iterator() {
        return new C0922jg2(this);
    }
}
