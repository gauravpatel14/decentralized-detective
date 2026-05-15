package org.chromium.base.library_loader;

import defpackage.AbstractC1214oR1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ProcessInitException extends RuntimeException {
    public ProcessInitException(int i) {
        super(AbstractC1214oR1.a(i, "errorCode="));
    }

    public ProcessInitException(int i, Throwable th) {
        super(AbstractC1214oR1.a(i, "errorCode="), th);
    }
}
