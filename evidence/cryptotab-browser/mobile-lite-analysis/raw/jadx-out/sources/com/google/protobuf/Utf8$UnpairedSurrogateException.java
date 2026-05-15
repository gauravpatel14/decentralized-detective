package com.google.protobuf;

import defpackage.Vx1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Utf8$UnpairedSurrogateException extends IllegalArgumentException {
    public Utf8$UnpairedSurrogateException(int i, int i2) {
        super(Vx1.a(i, i2, "Unpaired surrogate at index ", " of "));
    }
}
